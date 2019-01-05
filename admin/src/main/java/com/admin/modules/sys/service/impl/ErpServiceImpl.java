package com.admin.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.dao.ErpDao;
import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.entity.vo.ErpVo;
import com.admin.modules.sys.service.ErpService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("erpService")
@SuppressWarnings("ALL")
public class ErpServiceImpl extends ServiceImpl<ErpDao, ErpEntity> implements ErpService {

    @Autowired
    private ErpDao erpDao;

    /**
     * 保存ERP账户
     *
     * @param erp
     * @return
     */
    @Override
    public R save(ErpEntity erp) {
        // 查询该公司未删除的ERP账号中该ERP账号是否存在
        boolean isExist = existErp(erp);
        if (isExist) {
            return R.error("该账号已存在!");
        }
        ValidatorUtils.validateEntity(erp);
        this.insert(erp);
        return R.ok();
    }

    /**
     * 编辑ERP账户
     *
     * @param erp
     * @return
     */
    @Override
    public R update(ErpEntity erp) {
        // 查询该公司未删除的ERP账号中该ERP账号是否存在
        boolean isExist = existErp(erp);
        if (isExist) {
            return R.error("该账号已存在!");
        }
        ValidatorUtils.validateEntity(erp);
        //全部更新
        this.updateAllColumnById(erp);
        return R.ok();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErpEntity> page = this.selectPage(
                new Query<ErpEntity>(params).getPage(),
                new EntityWrapper<ErpEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询未绑定在职员工的ERP账号
     *
     * @return
     */
    @Override
    public R getErpList() {
        List<ErpEntity> erpList = erpDao.getErpList();
        return R.ok().put("list", erpList);
    }

    /**
     * 查询ERP账号列表
     *
     * @param params
     * @return
     */
    @Override
    public R queryPageErpList(Map<String, Object> params) {
        Page<ErpVo> page = new Query<ErpVo>(params).getPage();

        ErpVo erpVo = BeanUtil.mapToBean(params, ErpVo.class, true);
        List<ErpVo> erpVoList = erpDao.queryPageErpList(page, erpVo);
        page.setRecords(erpVoList);
        PageUtils pageUtils = new PageUtils(page);

        return R.ok().put("page", pageUtils);
    }

    /**
     * 查询该公司未删除的ERP账号中该ERP账号是否存在
     *
     * @param erp
     * @return
     */
    private boolean existErp(ErpEntity erp) {
        String erpNumber = erp.getErpNumber();
        Integer companyId = erp.getCompanyId();
        return this.selectCount(new EntityWrapper<ErpEntity>()
                .eq(StrUtil.isNotBlank(erp.getErpNumber()), "erp_number", erpNumber)
                .eq(ObjectUtil.isNotNull(companyId), "company_id", companyId)) > 0 ? true : false;
    }
}

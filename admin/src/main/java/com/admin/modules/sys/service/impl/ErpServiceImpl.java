package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.modules.sys.dao.ErpDao;
import com.admin.modules.sys.entity.ErpEntity;
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
     * @return
     */
    @Override
    public R getErpList() {
        List<ErpEntity> erpList = erpDao.getErpList();
        return R.ok().put("list", erpList);
    }

}

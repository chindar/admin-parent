package com.admin.modules.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.AreaDao;
import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.entity.vo.AreaEntityVo;
import com.admin.modules.sys.service.AreaService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Autowired
    private AreaDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        Page<AreaEntity> page = this.selectPage(
//                new Query<AreaEntity>(params).getPage(),
//                new EntityWrapper<AreaEntity>()
//        );
        AreaEntity entity = new AreaEntity();
        Page page = new Query<AreaEntity>(params).getPage();
        if (params.get("name") != null && Tools.notEmpty(params.get("name").toString()))
            entity.setName(params.get("name").toString());
        if (params.get("companyId") != null && Tools.notEmpty(params.get("companyId").toString()))
            entity.setCompanyId(Integer.parseInt(params.get("companyId").toString()));
        List<AreaEntityVo> list = dao.getAreaList(page,entity);
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 获取单条信息
     * @param id
     * @return
     */
    @Override
    public AreaEntityVo getAreaById(Integer id) {
        return dao.getAreaById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteAreaById(Integer id) {
        //删除则校验该公司下面有无绑定的待生效、生效中的合同，如果有则提示：删除失败，该公司有待生效/生效中的合同。
        int pactcount = dao.getPactByCompanyId(id,"tb_area");
        if (pactcount>0){
            throw new RuntimeException("删除失败，该公司有待生效/生效中的合同");
        }
        int count = dao.deleteAreaById(id);
        return count;
    }

    /**
     * 获取该公司下所有有效的片区(不带分页)
     * @param companyId
     * @return
     */
    @Override
    public List<AreaEntity> getAllAreaList(Integer companyId) {
        return dao.getAllAreaList(companyId);
    }

    /**
     * 获取所有有效的片区(不带分页)
     *
     * @return
     * @param companyId
     */
    @Override
    public R listAll(Integer companyId) {
        return R.ok().put("list", this.selectList(new EntityWrapper<AreaEntity>()
                .eq(ObjectUtil.isNotNull(companyId), "company_id", companyId)));
    }
}

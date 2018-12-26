package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.AreaDao;
import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.entity.CompanyEntity;
import com.admin.modules.sys.entity.DispatchInfoEntity;
import com.admin.modules.sys.entity.vo.AreaEntityVo;
import com.admin.modules.sys.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

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
        if (id == 2){
            throw new RuntimeException("该片区不能删除");
        }
        int count = dao.deleteAreaById(id);
        return count;
    }
}

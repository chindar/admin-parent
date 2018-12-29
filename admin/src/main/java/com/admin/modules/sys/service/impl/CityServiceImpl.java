package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.CityDao;
import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.entity.vo.AreaEntityVo;
import com.admin.modules.sys.entity.vo.CityEntityVo;
import com.admin.modules.sys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Autowired
    private CityDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        Page<CityEntity> page = this.selectPage(
//                new Query<CityEntity>(params).getPage(),
//                new EntityWrapper<CityEntity>()
//        );
        CityEntity entity = new CityEntity();
        Page page = new Query<CityEntity>(params).getPage();
        if (params.get("name") != null && Tools.notEmpty(params.get("name").toString()))
            entity.setName(params.get("name").toString());
        if (params.get("companyId") != null && Tools.notEmpty(params.get("companyId").toString()))
            entity.setCompanyId(Integer.parseInt(params.get("companyId").toString()));
        if (params.get("areaId") != null && Tools.notEmpty(params.get("areaId").toString()))
            entity.setAreaId(Integer.parseInt(params.get("areaId").toString()));
        List<CityEntityVo> list = dao.getCityList(page,entity);
        page.setRecords(list);
        return new PageUtils(page);
    }

    @Override
    public int deleteCityById(Integer id) {
        //删除则校验该公司下面有无绑定的待生效、生效中的合同，如果有则提示：删除失败，该公司有待生效/生效中的合同。
        if (id == 2){
            throw new RuntimeException("该城市不能删除");
        }
        int count = dao.deleteCityById(id);
        return count;
    }
}

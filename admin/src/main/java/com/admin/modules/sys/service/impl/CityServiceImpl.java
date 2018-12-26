package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.modules.sys.dao.CityDao;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.service.CityService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CityEntity> page = this.selectPage(
                new Query<CityEntity>(params).getPage(),
                new EntityWrapper<CityEntity>()
        );

        return new PageUtils(page);
    }

}

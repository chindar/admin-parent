package com.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.modules.sys.dao.CityInfoDao;
import com.admin.modules.sys.entity.CityInfoEntity;
import com.admin.modules.sys.service.CityInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cityInfoService")
public class CityInfoServiceImpl extends ServiceImpl<CityInfoDao, CityInfoEntity> implements CityInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CityInfoEntity> page = this.selectPage(
                new Query<CityInfoEntity>(params).getPage(),
                new EntityWrapper<CityInfoEntity>()
        );

        return new PageUtils(page);
    }

}

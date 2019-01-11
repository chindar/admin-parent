package com.admin.modules.sys.service;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.modules.sys.entity.CityEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 城市信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int deleteCityById(Integer id);

    List<CityEntity> getAllCityList(Integer areaId);
    /**
     * 获取所有有效的城市信息(不带分页)
     * @return
     */
    R listAll();
}


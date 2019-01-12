package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.entity.vo.CityEntityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 城市信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface CityDao extends BaseMapper<CityEntity> {

    List<CityEntityVo> getCityList(RowBounds var1, CityEntity params);

    int deleteCityById(@Param("id") Integer id);

    List<CityEntity> getAllCityList(@Param("areaId") Integer areaId);

    Integer getCityId(@Param("siteId") Integer siteId, @Param("companyId") Integer companyId);
}

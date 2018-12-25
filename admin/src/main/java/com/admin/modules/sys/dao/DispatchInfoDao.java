package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.CityInfoEntity;
import com.admin.modules.sys.entity.CourierEntity;
import com.admin.modules.sys.entity.DispatchInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 配送信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface DispatchInfoDao extends BaseMapper<DispatchInfoEntity> {

    List<DispatchInfoEntity> getDispatchList(RowBounds var1, DispatchInfoEntity params);

    CourierEntity getCourierInfo(@Param("courierName") String courierName,@Param("erpId") String erpId);

    CityInfoEntity getCityInfo(@Param("cityName")String cityName);

    int insertDispatch(DispatchInfoEntity entity);

    List<DispatchInfoEntity> getExportData(@Param("ids")Integer[] ids);
	
}

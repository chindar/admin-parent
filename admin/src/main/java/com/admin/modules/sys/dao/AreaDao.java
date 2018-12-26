package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.entity.DispatchInfoEntity;
import com.admin.modules.sys.entity.vo.AreaEntityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 片区表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface AreaDao extends BaseMapper<AreaEntity> {

    List<AreaEntityVo> getAreaList(RowBounds var1, AreaEntity params);

    AreaEntityVo getAreaById(@Param("id")Integer id);

    int deleteAreaById(@Param("id") Integer id);

    List<AreaEntity> getAllAreaList(@Param("companyId") Integer companyId);
}

package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.entity.vo.PactEntityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 合同信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface PactDao extends BaseMapper<PactEntity> {


    List<PactEntityVo> getPactList(RowBounds var1, PactEntity params);

    List<PactEntity> listAll();
}

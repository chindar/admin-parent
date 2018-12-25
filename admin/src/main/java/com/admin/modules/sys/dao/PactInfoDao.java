package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.PactInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 合同信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface PactInfoDao extends BaseMapper<PactInfoEntity> {


    List<PactInfoEntity> getPactList(RowBounds var1, PactInfoEntity params);

    /**
     * 获取全部合同信息
     * @return
     */
    List<PactInfoEntity> getAll();
}

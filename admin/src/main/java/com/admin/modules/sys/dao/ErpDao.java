package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.ErpEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * erp账号表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface ErpDao extends BaseMapper<ErpEntity> {

    /**
     * 查询未绑定在职员工的ERP账号
     * @return
     */
    List<ErpEntity> getErpList();
}

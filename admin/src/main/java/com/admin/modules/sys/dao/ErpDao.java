package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.entity.vo.ErpVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

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

    /**
     * 查询ERP账号列表
     * @param page
     * @param erpVo
     * @return
     */
    List<ErpVo> queryPageErpList(Page<ErpVo> page, ErpVo erpVo);
}

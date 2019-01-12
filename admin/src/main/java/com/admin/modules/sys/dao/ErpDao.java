package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.entity.vo.ErpVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

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
     * @param companyId
     */
    List<ErpEntity> getErpList(@Param("companyId") String companyId);

    /**
     * 查询ERP账号列表
     * @param page
     * @param erpVo
     * @return
     */
    List<ErpVo> queryPageErpList(Page<ErpVo> page, ErpVo erpVo);

    /**
     * 获取ERP账号全部信息
     * @return
     */
    List<ErpVo> selectAll();

    /**
     * 根据ERP账号获取erpId
     * @param erpNumber
     * @param companyId
     * @return
     */
    Integer getOneByNumber(@Param("erpNumber") String erpNumber, @Param("companyId") Integer companyId);
}

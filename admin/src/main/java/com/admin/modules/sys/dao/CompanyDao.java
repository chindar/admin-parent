package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.CompanyEntity;
import com.admin.modules.sys.entity.vo.CompanyEntityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 公司信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface CompanyDao extends BaseMapper<CompanyEntity> {
    /**
     * 获取所有有效的公司
     * @return
     */
    List<CompanyEntity> getAllCompanyList();

    List<CompanyEntity> getCompanyList(RowBounds var1, CompanyEntity params);

    List<CompanyEntityVo> getComList(RowBounds var1, CompanyEntity params);

    int deleteComById(@Param("id") Integer id);

    /**
     * 根据公司名称获取公司id
     * @param companyName
     * @return
     */
    Integer getOneByName(@Param("name") String companyName);
}

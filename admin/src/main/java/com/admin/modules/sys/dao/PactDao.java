package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.entity.vo.PactEntityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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


    List<PactEntityVo> getPactList(RowBounds var1, PactEntityVo params);

    List<PactEntity> listAll(@Param("companyId") Integer companyId);

    int deletePactById(@Param("id")Integer id);

    PactEntityVo getPactInfoById(@Param("id")Integer id);

    /**
     * 根据合同名称获取合同id
     * @param pactName
     * @return
     */
    Integer getOneByName(@Param("pactName") String pactName);
}

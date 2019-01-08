package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.CourierEntity;
import com.admin.modules.sys.entity.vo.CourierVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 快递员信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface CourierDao extends BaseMapper<CourierEntity> {

    /**
     * 查询分页列表
     * @param page
     * @param courierVo
     * @return
     */
    List<CourierVo> selectMyPage(Page<CourierVo> page, CourierVo courierVo);

    /**
     * 更新导入信息
     * @param batchId
     */
    void updateByBatch(@Param("batchId") String batchId, @Param("pactId") String pactId);

    /**
     * 查询
     * @return
     */
    List<CourierVo> selectAll();

    /**
     * 查询配送员信息
     * @param page
     * @param courierVo
     * @return
     */
    List<CourierVo> queryCourierList(Page<CourierVo> page, CourierVo courierVo);

    /**
     * 获取运营数据中配送员相关信息
     * @param erpNumber
     * @return
     */
    CourierVo getListByErpNumber(@Param("erpNumber") String erpNumber);
}

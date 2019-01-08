package com.admin.modules.sys.dao;

import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.entity.vo.DispatchVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 配送信息表
 * 
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface DispatchDao extends BaseMapper<DispatchEntity> {

    /**
     * 查询分页营运信息
     * @param page
     * @param dispatchVo
     * @return
     */
    List<DispatchVo> queryPage(Page<DispatchVo> page, DispatchVo dispatchVo);

    /**
     * 获取全部导出数据
     * @return
     */
    List<DispatchVo> selectAll();
}

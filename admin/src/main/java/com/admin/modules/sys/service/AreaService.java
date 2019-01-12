package com.admin.modules.sys.service;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.entity.vo.AreaEntityVo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 片区表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface AreaService extends IService<AreaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    AreaEntityVo getAreaById(Integer id);

    int deleteAreaById(Integer id);

    List<AreaEntity> getAllAreaList(Integer companyId);

    /**
     * 获取所有有效的片区(不带分页)
     * @return
     * @param companyId
     */
    R listAll(String companyId);
}


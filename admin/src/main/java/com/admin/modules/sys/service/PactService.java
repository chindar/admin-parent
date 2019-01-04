package com.admin.modules.sys.service;

import com.admin.common.utils.R;
import com.baomidou.mybatisplus.service.IService;
import com.admin.common.utils.PageUtils;
import com.admin.modules.sys.entity.PactEntity;

import java.util.Map;

/**
 * 合同信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface PactService extends IService<PactEntity> {

    PageUtils queryPage(Map<String, Object> params,String path);

    /**
     * 获取所有有效的合同信息
     * @return
     */
    R listAll();
}


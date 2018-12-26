package com.admin.modules.sys.service;

import com.admin.common.utils.PageUtils;
import com.admin.modules.sys.entity.ErpEntity;
import com.baomidou.mybatisplus.service.IService;
import java.util.Map;

/**
 * erp账号表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
public interface ErpService extends IService<ErpEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


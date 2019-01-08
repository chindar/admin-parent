package com.admin.modules.sys.service;

import com.admin.common.utils.R;
import com.admin.modules.sys.entity.DispatchEntity;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 配送信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface DispatchService extends IService<DispatchEntity> {

    R queryPage(Map<String, Object> params);

    void exportDispatch(HttpServletResponse res);
}


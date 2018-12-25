package com.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.admin.common.utils.PageUtils;
import com.admin.modules.sys.entity.DispatchInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 配送信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface DispatchInfoService extends IService<DispatchInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getDispatchList(Map<String, Object> params);

    int importData(DispatchInfoEntity entity);

    List<DispatchInfoEntity> getExportData(Integer[] ids);
}


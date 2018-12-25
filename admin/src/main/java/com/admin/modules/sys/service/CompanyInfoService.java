package com.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.admin.common.utils.PageUtils;
import com.admin.modules.sys.entity.CompanyInfoEntity;

import java.util.Map;

/**
 * 公司信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface CompanyInfoService extends IService<CompanyInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getCompanyList(Map<String, Object> params,String path);
}


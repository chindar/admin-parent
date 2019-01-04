package com.admin.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.admin.common.utils.PageUtils;
import com.admin.modules.sys.entity.CompanyEntity;

import java.util.List;
import java.util.Map;

/**
 * 公司信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface CompanyService extends IService<CompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CompanyEntity> getAllCompanyList();

    PageUtils getCompanyList(Map<String, Object> params,String path);

    int deleteComById(Integer id);
}


package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.modules.sys.dao.SiteDao;
import com.admin.modules.sys.entity.SiteEntity;
import com.admin.modules.sys.service.SiteService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("siteService")
public class SiteServiceImpl extends ServiceImpl<SiteDao, SiteEntity> implements SiteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SiteEntity> page = this.selectPage(
                new Query<SiteEntity>(params).getPage(),
                new EntityWrapper<SiteEntity>()
        );

        return new PageUtils(page);
    }

}

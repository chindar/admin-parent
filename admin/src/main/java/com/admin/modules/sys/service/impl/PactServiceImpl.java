package com.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;

import com.admin.modules.sys.dao.PactDao;
import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.service.PactService;


@Service("pactService")
public class PactServiceImpl extends ServiceImpl<PactDao, PactEntity> implements PactService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PactEntity> page = this.selectPage(
                new Query<PactEntity>(params).getPage(),
                new EntityWrapper<PactEntity>()
        );

        return new PageUtils(page);
    }

}

package com.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;

import com.admin.modules.sys.dao.DispatchDao;
import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.service.DispatchService;


@Service("dispatchService")
public class DispatchServiceImpl extends ServiceImpl<DispatchDao, DispatchEntity> implements DispatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DispatchEntity> page = this.selectPage(
                new Query<DispatchEntity>(params).getPage(),
                new EntityWrapper<DispatchEntity>()
        );

        return new PageUtils(page);
    }

}

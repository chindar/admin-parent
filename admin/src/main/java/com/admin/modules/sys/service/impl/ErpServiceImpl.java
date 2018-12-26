package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.modules.sys.dao.ErpDao;
import com.admin.modules.sys.entity.ErpEntity;
import com.admin.modules.sys.service.ErpService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("erpService")
public class ErpServiceImpl extends ServiceImpl<ErpDao, ErpEntity> implements ErpService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErpEntity> page = this.selectPage(
                new Query<ErpEntity>(params).getPage(),
                new EntityWrapper<ErpEntity>()
        );

        return new PageUtils(page);
    }

}

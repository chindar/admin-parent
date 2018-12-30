package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.modules.sys.dao.PactDao;
import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.service.PactService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


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

    /**
     * 获取所有有效的合同信息
     *
     * @return
     */
    @Override
    public R listAll() {
        return R.ok().put("list", this.selectList(new EntityWrapper<PactEntity>()));
    }

}

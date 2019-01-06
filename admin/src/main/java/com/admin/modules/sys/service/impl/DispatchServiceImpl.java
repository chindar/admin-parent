package com.admin.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.modules.sys.dao.DispatchDao;
import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.entity.vo.DispatchVo;
import com.admin.modules.sys.service.DispatchService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@SuppressWarnings("ALL")
@Service("dispatchService")
public class DispatchServiceImpl extends ServiceImpl<DispatchDao, DispatchEntity> implements DispatchService {

    @Autowired
    private DispatchDao dispatchDao;
    @Override
    public R queryPage(Map<String, Object> params) {
        Page<DispatchVo> page = new Query<DispatchVo>(params).getPage();
        DispatchVo dispatchVo = BeanUtil.mapToBean(params, DispatchVo.class, true);
        List<DispatchVo> dispatchVoList = dispatchDao.queryPage(page, dispatchVo);
        page.setRecords(dispatchVoList);

        PageUtils pageUtils = new PageUtils(page);
        return R.ok().put("page", pageUtils);
    }

}

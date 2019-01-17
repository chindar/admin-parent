package com.admin.modules.sys.service;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.entity.vo.PactEntityVo;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 合同信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
public interface PactService extends IService<PactEntity> {

    PageUtils queryPage(Map<String, Object> params,String path);

    /**
     * 获取所有有效的合同信息
     * @return
     * @param companyId
     */
    R listAll(String companyId);

    int deletePactById(Integer id);

    PactEntityVo getPactInfoById(Integer id);

    int getCount(PactEntity entity);
}


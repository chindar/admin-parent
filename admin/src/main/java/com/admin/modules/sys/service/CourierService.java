package com.admin.modules.sys.service;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.modules.sys.entity.CourierEntity;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 快递员信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-15 12:06:08
 */
public interface CourierService extends IService<CourierEntity> {

    PageUtils queryPage(Map<String, Object> params);

//    /**
//     * 上传文件
//     * @param file
//     * @return
//     */
//    R importCourier(MultipartFile file);
//
//    PageUtils selectMyPage(Map<String, Object> params);
//
//    /**
//     * 批量更新配送员信息
//     * @param batchId
//     * @param pactId
//     * @return
//     */
//    R editBatch(String batchId, String pactId);
//
    /**
     * 导出配送员信息
     * @param res
     */
    void exportCourier(HttpServletResponse res);

    /**
     * 查询配送员列表
     * @param params
     * @return
     */
    R queryCourierList(Map<String, Object> params);
}


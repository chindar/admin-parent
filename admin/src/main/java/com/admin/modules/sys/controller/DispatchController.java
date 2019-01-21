package com.admin.modules.sys.controller;

import com.admin.common.annotation.SysLog;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;



/**
 * 配送信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@RestController
@RequestMapping("sys/dispatch")
public class DispatchController {
    @Autowired
    private DispatchService dispatchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        return dispatchService.queryPage(params);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
//        DispatchEntity dispatch = dispatchService.selectById(id);

        return dispatchService.getById(id);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DispatchEntity dispatch){
        dispatchService.insert(dispatch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DispatchEntity dispatch){
        ValidatorUtils.validateEntity(dispatch);
        dispatchService.updateAllColumnById(dispatch);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        dispatchService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 导出配送员信息
     * @return
     */
    @SysLog("导出配送员信息")
    @GetMapping("/leadOut")
    public void exportDispatch(HttpServletResponse res) {
        dispatchService.exportDispatch(res);
    }

    /**
     * 导入运营数据
     * @param file
     * @return
     */
    @SysLog("导入运营数据")
    @PostMapping("/upload")
    public R importCourier(@RequestParam("file") MultipartFile file) {

        return dispatchService.importDispatch(file);
    }

}

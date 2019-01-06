package com.admin.modules.sys.controller;

import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.entity.DispatchEntity;
import com.admin.modules.sys.service.DispatchService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequiresPermissions("sys:dispatch:info")
    public R info(@PathVariable("id") Integer id){
        DispatchEntity dispatch = dispatchService.selectById(id);

        return R.ok().put("dispatch", dispatch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dispatch:save")
    public R save(@RequestBody DispatchEntity dispatch){
        dispatchService.insert(dispatch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dispatch:update")
    public R update(@RequestBody DispatchEntity dispatch){
        ValidatorUtils.validateEntity(dispatch);
        dispatchService.updateAllColumnById(dispatch);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dispatch:delete")
    public R delete(@RequestBody Integer[] ids){
        dispatchService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}

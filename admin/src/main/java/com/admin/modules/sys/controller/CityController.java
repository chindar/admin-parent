package com.admin.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.service.CityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 城市信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
@RestController
@RequestMapping("sys/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:city:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:city:info")
    public R info(@PathVariable("id") Integer id){
        CityEntity city = cityService.selectById(id);

        return R.ok().put("city", city);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:city:save")
    public R save(@RequestBody CityEntity city){
        cityService.insert(city);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:city:update")
    public R update(@RequestBody CityEntity city){
        ValidatorUtils.validateEntity(city);
        cityService.updateAllColumnById(city);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:city:delete")
    public R delete(@RequestBody Integer[] ids){
        cityService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}

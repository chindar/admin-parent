package com.admin.modules.sys.controller;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.common.validator.group.UpdateGroup;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.service.CityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


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
     * 获取所有有效的城市信息(不带分页)
     * @return
     */
    @GetMapping("/listAll")
    public R listAll() {
        return cityService.listAll();
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
        ValidatorUtils.validateEntity(city,UpdateGroup.class);
        cityService.insert(city);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:city:update")
    public R update(@RequestBody CityEntity city){
        ValidatorUtils.validateEntity(city,UpdateGroup.class);
        cityService.updateAllColumnById(city);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:city:delete")
    public R delete(@RequestParam(value = "id",defaultValue = "") Integer id){
//        cityService.deleteBatchIds(Arrays.asList(ids));
        try {
            cityService.deleteCityById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }

        return R.ok();
    }

}

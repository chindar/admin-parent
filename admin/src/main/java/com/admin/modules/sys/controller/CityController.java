package com.admin.modules.sys.controller;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.common.validator.group.UpdateGroup;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cityService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 获取该片区下所有有效的城市(不带分页)
     * liriming
     * 2019-01-11
     */
    @RequestMapping(value = "getAllCityList")
    public R getAllCityList(@RequestParam(value = "areaId",defaultValue = "") Integer areaId){
        List<CityEntity> list = cityService.getAllCityList(areaId);
        return R.ok().put("list",list);
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
    public R info(@PathVariable("id") Integer id){
        CityEntity city = cityService.selectById(id);

        return R.ok().put("city", city);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CityEntity city){
        ValidatorUtils.validateEntity(city,UpdateGroup.class);
        cityService.insert(city);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CityEntity city){
        ValidatorUtils.validateEntity(city,UpdateGroup.class);
        cityService.updateAllColumnById(city);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
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

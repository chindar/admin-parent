package com.admin.modules.sys.controller;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.validator.ValidatorUtils;
import com.admin.common.validator.group.UpdateGroup;
import com.admin.modules.sys.entity.AreaEntity;
import com.admin.modules.sys.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 片区表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:19:10
 */
@RestController
@RequestMapping("sys/area")
public class AreaController {
    @Autowired
    private AreaService areaService;


    /**
     * 获取该公司下所有有效的片区(不带分页)
     * @return
     */
    @RequestMapping(value = "getAllAreaList")
    public R getAllAreaList(@RequestParam(value = "companyId",defaultValue = "") Integer companyId){
        List<AreaEntity> list = areaService.getAllAreaList(companyId);
        return R.ok().put("list",list);
    }

    /**
     * 获取所有有效的片区(不带分页)
     * @return
     */
    @GetMapping("/listAll/{companyId}")
    public R listAll(@PathVariable("companyId") Integer companyId) {
        return areaService.listAll(companyId);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = areaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        AreaEntity area = areaService.selectById(id);
//        AreaEntity area = areaService.getAreaById(id);
        return R.ok().put("area", area);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AreaEntity area){
        ValidatorUtils.validateEntity(area,UpdateGroup.class);
        areaService.insert(area);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AreaEntity area){
        ValidatorUtils.validateEntity(area,UpdateGroup.class);
        areaService.updateAllColumnById(area);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    public R delete(@RequestParam(value = "id",defaultValue = "") Integer id){
//        areaService.deleteBatchIds(Arrays.asList(ids));
        try {
            areaService.deleteAreaById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }
        return R.ok();
    }

}

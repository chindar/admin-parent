package com.admin.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.AreaDao;
import com.admin.modules.sys.dao.CityDao;
import com.admin.modules.sys.entity.CityEntity;
import com.admin.modules.sys.entity.vo.CityEntityVo;
import com.admin.modules.sys.service.CityService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Autowired
    private CityDao dao;

    @Autowired
    private AreaDao areaDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//        Page<CityEntity> page = this.selectPage(
//                new Query<CityEntity>(params).getPage(),
//                new EntityWrapper<CityEntity>()
//        );
        CityEntity entity = new CityEntity();
        Page page = new Query<CityEntity>(params).getPage();
        if (params.get("name") != null && Tools.notEmpty(params.get("name").toString()))
            entity.setName(params.get("name").toString());
        if (params.get("companyId") != null && Tools.notEmpty(params.get("companyId").toString()))
            entity.setCompanyId(Integer.parseInt(params.get("companyId").toString()));
        if (params.get("areaId") != null && Tools.notEmpty(params.get("areaId").toString()))
            entity.setAreaId(Integer.parseInt(params.get("areaId").toString()));
        List<CityEntityVo> list = dao.getCityList(page,entity);
        page.setRecords(list);
        return new PageUtils(page);
    }

    @Override
    public int deleteCityById(Integer id) {
        //删除则校验该公司下面有无绑定的待生效、生效中的合同，如果有则提示：删除失败，该公司有待生效/生效中的合同。
        int pactcount = areaDao.getPactByCompanyId(id,"tb_city");
        if (pactcount>0){
            throw new RuntimeException("删除失败，该公司有待生效/生效中的合同");
        }
        int sitecount = dao.getSiteByAreaId(id);
        if (sitecount>0){
            throw new RuntimeException("删除失败，该城市下存在站点不可删除。");
        }
        int count = dao.deleteCityById(id);
        return count;
    }

    /**
     * 获取该片区下所有有效的城市(不带分页)
     * @param areaId
     * @return
     */
    @Override
    public List<CityEntity> getAllCityList(Integer areaId) {
        return dao.getAllCityList(areaId);
    }
    /**
     * 获取所有有效的城市信息(不带分页)
     *
     * @return
     * @param areaId
     */
    @Override
    public R listAll(String areaId) {
        boolean condition = StrUtil.isNotBlank(areaId) && !StrUtil.equals(areaId, "undefined");
        return R.ok().put("list", this.selectList(new EntityWrapper<CityEntity>()
        .eq(condition, "area_id", areaId)));
    }
}

package com.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.PactInfoDao;
import com.admin.modules.sys.entity.PactInfoEntity;
import com.admin.modules.sys.service.PactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


@Service("pactInfoService")
public class PactInfoServiceImpl extends ServiceImpl<PactInfoDao, PactInfoEntity> implements PactInfoService {

    @Autowired
    private PactInfoDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PactInfoEntity> page = this.selectPage(
                new Query<PactInfoEntity>(params).getPage(),
                new EntityWrapper<PactInfoEntity>()
        );
        System.out.println(page);
        return new PageUtils(page);
    }

    @Override
    public PageUtils getPactList(Map<String, Object> params,String path) {
        PactInfoEntity entity = new PactInfoEntity();
        Page page = new Query<PactInfoEntity>(params).getPage();
        if (params.get("businessName") != null && Tools.notEmpty(params.get("businessName").toString()))
            entity.setBusinessName(params.get("businessName").toString());
        if (params.get("businessName") != null && Tools.notEmpty(params.get("cityId").toString()))
            entity.setCityId(Integer.valueOf(params.get("cityId").toString()));
        if (params.get("businessName") != null && Tools.notEmpty(params.get("pactStatus").toString()))
            entity.setPactStatus(Integer.valueOf(params.get("pactStatus").toString()));
        List<PactInfoEntity> list = dao.getPactList(page,entity);
        if (list.size() > 0){
            for (PactInfoEntity info: list) {
                if (Tools.notEmpty(info.getFileId())){
                    info.setFileUrl(MessageFormat.format("{0}sys/pactinfo/downloadFile?fileId={1}&dbname={2}", path, info.getFileId(),"pact"));
                }
            }
        }
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 获取全部合同信息
     *
     * @return
     */
    @Override
    public List<PactInfoEntity> getAll() {
        return dao.getAll();
    }


}

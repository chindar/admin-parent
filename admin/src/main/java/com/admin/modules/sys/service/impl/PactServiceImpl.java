package com.admin.modules.sys.service.impl;

import com.admin.common.utils.PageUtils;
import com.admin.common.utils.Query;
import com.admin.common.utils.R;
import com.admin.common.utils.Tools;
import com.admin.modules.sys.dao.PactDao;
import com.admin.modules.sys.entity.PactEntity;
import com.admin.modules.sys.entity.vo.PactEntityVo;
import com.admin.modules.sys.service.PactService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
@Service("pactService")
public class PactServiceImpl extends ServiceImpl<PactDao, PactEntity> implements PactService {

    @Autowired
    private PactDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params,String path) {
//        Page<PactEntity> page = this.selectPage(
//                new Query<PactEntity>(params).getPage(),
//                new EntityWrapper<PactEntity>()
//        );

        PactEntityVo entity = new PactEntityVo();
        Page page = new Query<PactEntityVo>(params).getPage();
        if (params.get("businessName") != null && Tools.notEmpty(params.get("businessName").toString()))
            entity.setBusinessName(params.get("businessName").toString());
        if (params.get("name") != null && Tools.notEmpty(params.get("name").toString()))
            entity.setName(params.get("name").toString());
        if (params.get("pactStatus") != null && Tools.notEmpty(params.get("pactStatus").toString()))
            entity.setPactStatus(Integer.valueOf(params.get("pactStatus").toString()));
        if (params.get("companyId") != null && Tools.notEmpty(params.get("companyId").toString()))
            entity.setCompanyId(Integer.valueOf(params.get("companyId").toString()));
        if (params.get("timeType") != null && Tools.notEmpty(params.get("timeType").toString()))
            entity.setTimeType(Integer.valueOf(params.get("timeType").toString()));
        if (params.get("startDate") != null && Tools.notEmpty(params.get("startDate").toString()))
            entity.setStartDate(params.get("startDate").toString());
        if (params.get("endDate") != null && Tools.notEmpty(params.get("endDate").toString()))
            entity.setEndDate(params.get("endDate").toString());
        List<PactEntityVo> list = dao.getPactList(page,entity);
        if (list.size() > 0){
            for (PactEntityVo info: list) {
                if (Tools.notEmpty(info.getFileId())){
                    info.setFileUrl(MessageFormat.format("{0}sys/pactinfo/downloadFile?fileId={1}&dbname={2}", path, info.getFileId(),"pact"));
                }
            }
        }
        page.setRecords(list);
        return new PageUtils(page);
    }

    /**
     * 获取所有有效的合同信息
     *
     * @return
     * @param companyId
     */
    @Override
    public R listAll(String companyId) {
        return R.ok().put("list", dao.listAll(companyId));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deletePactById(Integer id) {
        return dao.deletePactById(id);
    }

    @Override
    public PactEntityVo getPactInfoById(Integer id) {
        return dao.getPactInfoById(id);
    }

    @Override
    public int getCount(PactEntity entity) {
        return dao.getCount(entity);
    }
}

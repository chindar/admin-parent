package com.admin.modules.sys.controller;

import com.admin.common.utils.MongoUtils;
import com.admin.common.utils.PageUtils;
import com.admin.common.utils.R;
import com.admin.common.utils.Tools;
import com.admin.common.validator.ValidatorUtils;
import com.admin.common.validator.group.UpdateGroup;
import com.admin.modules.sys.entity.CompanyEntity;
import com.admin.modules.sys.entity.vo.CompanyEntityVo;
import com.admin.modules.sys.service.CompanyService;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 公司信息表
 *
 * @author lxj
 * @email sunlightcs@gmail.com
 * @date 2018-12-26 10:55:09
 */
@RestController
@RequestMapping("sys/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    /**
     * 获取所有有效的公司(不带分页)
     * @return
     */
    @RequestMapping(value = "getAllCompanyList")
    public R getAllCompanyList(){
        List<CompanyEntity> list = companyService.getAllCompanyList();
        return R.ok().put("list",list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params,HttpServletRequest request){

        String QUERY_FILE_PATH = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
        PageUtils page = companyService.getCompanyList(params,QUERY_FILE_PATH);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id,HttpServletRequest request){
//        CompanyEntity company = companyService.selectById(id);
        String path = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
        CompanyEntityVo company = companyService.getCompanyById(id);
        if (company != null){
            if (Tools.notEmpty(company.getBusinessFileid())){
                company.setBusinessFileUrl(MessageFormat.format("{0}sys/company/getFile?fileId={1}&dbname={2}", path, company.getBusinessFileid(),"businessFile"));
            }
            if (Tools.notEmpty(company.getBusinessFileid())){
                company.setCardFileUrl(MessageFormat.format("{0}sys/company/getFile?fileId={1}&dbname={2}", path, company.getCardFileid(),"cardFile"));
            }
        }
        return R.ok().put("company", company);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CompanyEntity company){

        ValidatorUtils.validateEntity(company, UpdateGroup.class);
        companyService.insert(company);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CompanyEntity company){
        ValidatorUtils.validateEntity(company);
        companyService.updateAllColumnById(company);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestParam(value = "id",defaultValue = "") Integer id){
        try {
            companyService.deleteComById(id);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 上传图片文件
     * @param multipartRequest
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("upload")
    public R uploadFiles(MultipartHttpServletRequest multipartRequest, HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(value = "dbname",defaultValue = "")String dbname
    ) throws Exception {
        Map result = new HashMap();
        try{
            String QUERY_FILE_PATH = request.getScheme() + "://" +
                    request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath() + "/";
            // 封装上传文件的Map
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            MultipartFile file=null;
            for(Map.Entry<String,MultipartFile> entry:fileMap.entrySet()){
                file=entry.getValue();
                String fileId=String.valueOf(System.currentTimeMillis());
                MongoUtils mongo=new MongoUtils();
                // 保存文件到mongodb,以指标id作为文件的唯一标识
                mongo.saveFile(file.getInputStream(),fileId,file.getOriginalFilename(),dbname);
                result.put("fileId",fileId);
                result.put("fileName",file.getOriginalFilename());
                result.put("fileUrl", MessageFormat.format("{0}sys/company/getFile?fileId={1}&dbname={2}", QUERY_FILE_PATH, fileId,dbname));
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return R.ok().put("data",result);
    }

    @RequestMapping(value = "/getFile")
    @ResponseBody
    public void getFile(
            @RequestParam(value = "fileId",defaultValue = "") String fileId,
            @RequestParam(value = "dbname",defaultValue = "")String dbname,
            HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            MongoUtils mongo=new MongoUtils();
            HashMap<String, Object> params = new HashMap<String, Object>(4);
            params.put("fileId", fileId);
            GridFSDBFile file = mongo.findFirstFile(params,dbname);
            response.setContentType(file.getContentType());
            // 输出流
            ServletOutputStream out = null;
            byte[] bytes = input2byte(file.getInputStream());
            out = response.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}

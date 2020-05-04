package com.hzs.rc.controller;



import com.aliyun.oss.model.OSSObjectSummary;
import com.hzs.rc.entity.FileUploadResult;
import com.hzs.rc.service.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年04月09日
 */
@Controller
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    /**
     * @author 团子
     * @desc 文件上传到oss
     * @return FileUploadResult
     * @Param uploadFile
     */
    @PostMapping("file/upload")
    @ResponseBody
    public FileUploadResult upload(@RequestParam("file") MultipartFile uploadFile)
            throws Exception {
        return this.fileUploadService.upload(uploadFile);
    }

    /**
     * @return FileUploadResult
     * @desc 根据文件名删除oss上的文件
     * @author 团子
     * @Param objectName
     */
    @PostMapping("file/delete")
    @ResponseBody
    public FileUploadResult delete(@RequestParam("fileName") String objectName)
            throws Exception {
        return this.fileUploadService.delete(objectName);
    }

    /**
     * @author 团子
     * @desc 查询oss上的所有文件
     * @return List<OSSObjectSummary>
     * @Param
     */
    @PostMapping("file/list")
    @ResponseBody
    public List<OSSObjectSummary> list()
            throws Exception {
        return this.fileUploadService.list();
    }

    /**
     * @author 团子
     * @desc 根据文件名下载oss上的文件
     * @return
     * @Param objectName
     */
    @PostMapping("file/download")
    @ResponseBody
    public void download(@RequestParam("fileName") String objectName, HttpServletResponse response) throws IOException {
        //通知浏览器以附件形式下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(objectName.getBytes(), "ISO-8859-1"));
        this.fileUploadService.exportOssFile(response.getOutputStream(),objectName);
    }
}
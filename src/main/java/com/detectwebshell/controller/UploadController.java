package com.detectwebshell.controller;

import com.detectwebshell.pojo.PhpFile;
import com.detectwebshell.service.PhpFileService;
import com.detectwebshell.service.UploadService;
import com.detectwebshell.utils.FileCommonUtils;
import com.detectwebshell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;


/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private PhpFileService phpFileService;

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    //private static final String filePath = "D://phpfiles//";

    /**
     * statuCode
     * 0 => 编译失败
     * 1 => 检测成功
     * 2 => 上传失败
     * 3 => 文件格式不正确
     * 4 => 文件大于10M
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResultVO upload(@RequestParam("file") MultipartFile file) throws IOException {
        ResultVO res = new ResultVO();
        res.setPhpFileName(file.getOriginalFilename());
        if (file.isEmpty()) {

            log.error("上传失败，请选择文件");

            res.setStatusCode(2);
            res.setMessage("上传失败，请选择文件");
            return res;
        }

        if (!FileCommonUtils.checkFileSize(file.getSize(), 10, "M")) {
            log.error("文件检测失败，文件大于10M");
            res.setStatusCode(4);
            res.setMessage("文件检测失败，文件大于10M");
            return res;
        }

        String fileName = file.getOriginalFilename();
        int lastIndex = fileName.lastIndexOf(".");
        String suffix = fileName.substring(lastIndex + 1);
        suffix = suffix.toLowerCase();
        if (!suffix.equals("php")) {
            log.error("该文件不是PHP文件，请检测后上传");
            res.setStatusCode(3);
            res.setMessage("请上传php脚本文件");
            return res;
        }

        ResultVO finalRes = uploadService.judgeWebshell(file);

        if (finalRes.getStatusCode() == 0) {
            res.setStatusCode(0);
            res.setMessage(finalRes.getMessage());
            return res;
        }
        //只有检测通过的时候，才会往数据库里写内容
        if (finalRes.getStatusCode() == 1) {
            PhpFile phpFile = new PhpFile();
            phpFile.setDate(new Date());
            phpFile.setFilename(file.getOriginalFilename());
            phpFile.setNormal(finalRes.getNormal());
            phpFile.setWebshell(finalRes.getWebshell());
            phpFile.setType(finalRes.getResType());
            phpFile.setDetectres(finalRes.getResName());
            phpFileService.insertFile(phpFile);
        }
        return finalRes;
    }
}

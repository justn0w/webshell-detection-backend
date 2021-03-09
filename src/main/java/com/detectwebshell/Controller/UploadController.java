package com.detectwebshell.Controller;

import com.detectwebshell.pojo.PhpFile;
import com.detectwebshell.service.PhpFileService;
import com.detectwebshell.service.UploadService;
import com.detectwebshell.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    @PostMapping("/upload")
    public ResultVO upload(@RequestParam("file") MultipartFile file) throws IOException {
//        ResultVO res = new ResultVO();
//        if (file.isEmpty()) {
//            log.error("上传失败，请选择文件");
//            res.setStatusCode(0);
//            res.setMessage("上传失败，请选择文件");
//            return res;
//        }
//        String fileName = file.getOriginalFilename();
//        File dest = new File(filePath + fileName);
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            log.error(e.toString(), e);
//            res.setStatusCode(2);
//            res.setMessage(e.toString());
//            return res;
//        }


        ResultVO finalRes = uploadService.judgeWebshell(file);
        finalRes.setMessage("sucess");
        finalRes.setStatusCode(1);
        PhpFile phpFile = new PhpFile();
        phpFile.setDate(new Date());
        phpFile.setFilename(finalRes.getPhpFileName());
        phpFile.setProbability(finalRes.getProbability());
        phpFile.setType(finalRes.getResType());
        phpFile.setDetectres(finalRes.getResName());

        phpFileService.insertFile(phpFile);

        return finalRes;
    }
}

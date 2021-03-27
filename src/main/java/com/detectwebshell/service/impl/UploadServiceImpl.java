package com.detectwebshell.service.impl;

import com.detectwebshell.dto.DetectResult;
import com.detectwebshell.service.UploadService;
import com.detectwebshell.vo.ResultVO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */

@Service
public class UploadServiceImpl implements UploadService {

    private final static String url = "http://192.168.223.128:5000/judge";

    @Override
    public ResultVO judgeWebshell(MultipartFile file) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {

            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
            @Override
            public long contentLength() {
                return file.getSize();
            }
        };

        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("file", fileAsResource);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity  = new HttpEntity<>(multiValueMap, headers);
        DetectResult detectResult = restTemplate.postForObject(url, requestEntity, DetectResult.class);



        ResultVO res = new ResultVO();
        res.setPhpFileName(file.getOriginalFilename());
        if (detectResult.getCode() == 0) {
            res.setStatusCode(0);
            res.setMessage("编译错误");
            return res;
        }


        Double webshell = detectResult.getWebshell();

        Double normal = detectResult.getNormal();

        res.setMessage("sucess");
        res.setWebshell(webshell);
        res.setNormal(normal);
        if (webshell > normal) {
            res.setResName("Webshell");
            res.setResType(0);
        } else {
            res.setResName("正常网页脚本");
            res.setResType(1);
        }

        res.setStatusCode(1);
//        if (probability > 0.5) {
//            res.setProbability(1 - probability);
//            res.setResName("Webshell");
//            res.setResType(0);
//        } else {
//            res.setProbability(1 - probability);
//            res.setResName("正常网页脚本");
//            res.setResType(1);
//        }
        return res;
    }
}

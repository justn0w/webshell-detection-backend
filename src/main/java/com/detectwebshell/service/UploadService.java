package com.detectwebshell.service;

import com.detectwebshell.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */
public interface UploadService {


    ResultVO judgeWebshell(MultipartFile file) throws IOException;
}

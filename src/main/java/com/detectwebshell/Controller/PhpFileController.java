package com.detectwebshell.Controller;

import com.detectwebshell.pojo.PhpFile;
import com.detectwebshell.service.PhpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */

@RestController
public class PhpFileController {

    @Autowired
    private PhpFileService phpFileService;

    @GetMapping("/all")
    public List<PhpFile> getAllPhpFiles() {
        return phpFileService.queryPhpFiles();
    }
}

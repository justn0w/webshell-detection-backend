package com.detectwebshell.service.impl;

import com.detectwebshell.mapper.PhpFileMapper;
import com.detectwebshell.pojo.PhpFile;
import com.detectwebshell.service.PhpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */

@Service
public class PhpFileServiceImpl implements PhpFileService {

    @Autowired
    private PhpFileMapper phpFileMapper;

    @Override
    public List<PhpFile> queryPhpFiles() {
        return phpFileMapper.queryPhpFiles();
    }

    @Override
    public void insertFile(PhpFile phpFile) {
        phpFileMapper.insertFile(phpFile);
    }

}

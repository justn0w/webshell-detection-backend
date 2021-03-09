package com.detectwebshell.service;

import com.detectwebshell.pojo.PhpFile;

import java.util.List;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */
public interface PhpFileService {
    public List<PhpFile> queryPhpFiles();
    public void insertFile(PhpFile phpFile);
}

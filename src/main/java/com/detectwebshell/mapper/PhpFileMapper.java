package com.detectwebshell.mapper;

import com.detectwebshell.pojo.PhpFile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */
@Repository
public interface PhpFileMapper {
    public List<PhpFile> queryPhpFiles();

    void insertFile(PhpFile phpFile);
}

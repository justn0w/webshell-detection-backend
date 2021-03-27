package com.detectwebshell.utils;

/**
 * @author justnow
 * Created on 2021-03-27
 * Description
 */
public class FileCommonUtils {

    public static boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        unit = unit.toUpperCase();
        if ("B".equals(unit)) {
            fileSize = (double) len;
        } else if ("K".equals(unit)) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit)) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit)) {
            fileSize = (double) len / 1073741824;
        }

        if (fileSize >size) {
            return false;
        }

        return true;
    }
}

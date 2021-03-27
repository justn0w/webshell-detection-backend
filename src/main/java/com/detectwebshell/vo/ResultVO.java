package com.detectwebshell.vo;

/**
 * @author justnow
 * Created on 2021-03-08
 * Description
 */
public class ResultVO {

    private String phpFileName;
    private String md5Value;
    private Double webshell;
    private Double normal;

    public Double getWebshell() {
        return webshell;
    }

    public void setWebshell(Double webshell) {
        this.webshell = webshell;
    }

    public Double getNormal() {
        return normal;
    }

    public void setNormal(Double normal) {
        this.normal = normal;
    }

    private String resName;
    private Integer resType;
    private Integer statusCode;
    private String message;

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getPhpFileName() {
        return phpFileName;
    }

    public void setPhpFileName(String phpFileName) {
        this.phpFileName = phpFileName;
    }

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }


}

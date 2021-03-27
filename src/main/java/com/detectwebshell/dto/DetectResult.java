package com.detectwebshell.dto;


/**
 * @author justnow
 * Created on 2021-03-08
 * Description
 */
public class DetectResult {

    private Integer code;
    private Double webshell;
    private Double normal;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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
}

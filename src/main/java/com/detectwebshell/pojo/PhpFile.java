package com.detectwebshell.pojo;

import java.util.Date;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */


public class PhpFile {

    private String id;
    private String filename;
    private Date date;
    private Integer type;
    private Double probability;
    private String detectres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getDetectres() {
        return detectres;
    }

    public void setDetectres(String detectres) {
        this.detectres = detectres;
    }
}

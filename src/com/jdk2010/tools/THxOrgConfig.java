package com.jdk2010.tools;

import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class THxOrgConfig extends Model<Model<THxOrgConfig>>{
    private Integer id;
    private String saleorg;
    private String storecode;
                   
    private String sapordertypeexce;
    private String email;
    private String sms;
    private String pdf;

    @TableField
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @TableField
    public String getSaleorg() {
        return saleorg;
    }

    public void setSaleorg(String saleorg) {
        this.saleorg = saleorg;
    }

    @TableField
    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode;
    }

   
    @TableField
    public String getSapordertypeexce() {
        return sapordertypeexce;
    }

    public void setSapordertypeexce(String sapordertypeexce) {
        this.sapordertypeexce = sapordertypeexce;
    }

    @TableField
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @TableField
    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    @TableField
    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

}

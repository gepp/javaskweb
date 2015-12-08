package com.jdk2010.base.security.securityuser.model;

import java.util.Date;

import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityUserExt extends Model<Model> {

    private int id;
    private String userId;
    private String organizationCode;
    private String sex;
    private Date birthday;

    @TableField
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @TableField
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @TableField
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @TableField
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @TableField
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}

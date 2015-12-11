package com.jdk2010.nsrxx.skqnsrxx.model;

import java.util.Date;
import java.util.List;

import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;

public class SkqNsrxx extends Model<SkqNsrxx> {
    /* id */
    private Integer id;
    /* 纳税人微机编码 */
    private String nsrwjbm;
    /* 纳税人识别号 */
    private String nsrsbh;
    /* 纳税人名称 */
    private String nsrmc;
    /* 经营地址 */
    private String jydz;
    /* 法人代表 */
    private String frdb;
    /* 注册类型编码 */
    private String zclxbm;
    /* 行业编码 */
    private String hybm;
    /* 行业明细编码 */
    private String hymxbm;
    /* 征收方式 */
    private Integer zsfs;
    /* 月核定营业额 */
    private Double yhde;
    /* 税务机关编码 */
    private String swjgbm;
    /* 办税员 */
    private String bsy;
    /* 联系方式 */
    private String ssgly;
    /* 状态 */
    private Integer status;

    @TableField
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @TableField
    public String getNsrwjbm() {
        return nsrwjbm;
    }

    public void setNsrwjbm(String nsrwjbm) {
        this.nsrwjbm = nsrwjbm;
    }

    @TableField
    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    @TableField
    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    @TableField
    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz;
    }

    @TableField
    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    @TableField
    public String getZclxbm() {
        return zclxbm;
    }

    public void setZclxbm(String zclxbm) {
        this.zclxbm = zclxbm;
    }

    @TableField
    public String getHybm() {
        return hybm;
    }

    public void setHybm(String hybm) {
        this.hybm = hybm;
    }

    @TableField
    public String getHymxbm() {
        return hymxbm;
    }

    public void setHymxbm(String hymxbm) {
        this.hymxbm = hymxbm;
    }

    @TableField
    public Integer getZsfs() {
        return zsfs;
    }

    public void setZsfs(Integer zsfs) {
        this.zsfs = zsfs;
    }

    @TableField
    public Double getYhde() {
        return yhde;
    }

    public void setYhde(Double yhde) {
        this.yhde = yhde;
    }

    @TableField
    public String getSwjgbm() {
        return swjgbm;
    }

    public void setSwjgbm(String swjgbm) {
        this.swjgbm = swjgbm;
    }

    @TableField
    public String getBsy() {
        return bsy;
    }

    public void setBsy(String bsy) {
        this.bsy = bsy;
    }

    @TableField
    public String getSsgly() {
        return ssgly;
    }

    public void setSsgly(String ssgly) {
        this.ssgly = ssgly;
    }

    @TableField
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private String hymc;
    private String hymxmc;
    private String zclxmc;
    private String swjgmc;

    private List<SkqNsrszsm> nsrszsmList;

    private List<SkqJqxx> jqxxList;

    public List<SkqNsrszsm> getNsrszsmList() {
        return nsrszsmList;
    }

    public void setNsrszsmList(List<SkqNsrszsm> nsrszsmList) {
        this.nsrszsmList = nsrszsmList;
    }

    public List<SkqJqxx> getJqxxList() {
        return jqxxList;
    }

    public void setJqxxList(List<SkqJqxx> jqxxList) {
        this.jqxxList = jqxxList;
    }

    public String getHymc() {
        return hymc;
    }

    public void setHymc(String hymc) {
        this.hymc = hymc;
    }

    public String getHymxmc() {
        return hymxmc;
    }

    public void setHymxmc(String hymxmc) {
        this.hymxmc = hymxmc;
    }

    public String getZclxmc() {
        return zclxmc;
    }

    public void setZclxmc(String zclxmc) {
        this.zclxmc = zclxmc;
    }

    public String getSwjgmc() {
        return swjgmc;
    }

    public void setSwjgmc(String swjgmc) {
        this.swjgmc = swjgmc;
    }
}
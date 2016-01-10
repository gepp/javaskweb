package com.jdk2010.invoice.skqfpkj.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqFpkj extends Model<SkqFpkj> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 开票日期 */
    	private Date kprq;
        	/* 开票类型 */
    	private Integer kplx;
        	/* 发票代码 */
    	private String fpdm;
        	/* 发票号码 */
    	private Integer fphm;
        	/* 开票金额 */
    	private Double hjzje;
        	/* 原发票号码 */
    	private Integer yfphm;
        	/* 付款单位 */
    	private String fkdw;
        	/* 收款员 */
    	private String sky;
        	/* 项目数 */
    	private Integer xms;
        	/* 税控码 */
    	private String skm;
        	/* 确认标志 */
    	private Integer qrbz;
        	/* 状态 */
    	private Integer status;
        	/* 上传时间 */
    	private Date scsj;
        	/* 备注 */
    	private String bz;
             	 
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
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public Date getKprq() {
			return kprq;
		}
		public void setKprq(Date kprq) {
			this.kprq = kprq;
		}
        	 
  		@TableField
		public Integer getKplx() {
			return kplx;
		}
		public void setKplx(Integer kplx) {
			this.kplx = kplx;
		}
        	 
  		@TableField
		public String getFpdm() {
			return fpdm;
		}
		public void setFpdm(String fpdm) {
			this.fpdm = fpdm;
		}
        	 
  		@TableField
		public Integer getFphm() {
			return fphm;
		}
		public void setFphm(Integer fphm) {
			this.fphm = fphm;
		}
        	 
  		@TableField
		public Double getHjzje() {
			return hjzje;
		}
		public void setHjzje(Double hjzje) {
			this.hjzje = hjzje;
		}
        	 
  		@TableField
		public Integer getYfphm() {
			return yfphm;
		}
		public void setYfphm(Integer yfphm) {
			this.yfphm = yfphm;
		}
        	 
  		@TableField
		public String getFkdw() {
			return fkdw;
		}
		public void setFkdw(String fkdw) {
			this.fkdw = fkdw;
		}
        	 
  		@TableField
		public String getSky() {
			return sky;
		}
		public void setSky(String sky) {
			this.sky = sky;
		}
        	 
  		@TableField
		public Integer getXms() {
			return xms;
		}
		public void setXms(Integer xms) {
			this.xms = xms;
		}
        	 
  		@TableField
		public String getSkm() {
			return skm;
		}
		public void setSkm(String skm) {
			this.skm = skm;
		}
        	 
  		@TableField
		public Integer getQrbz() {
			return qrbz;
		}
		public void setQrbz(Integer qrbz) {
			this.qrbz = qrbz;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
        	 
  		@TableField
		public Date getScsj() {
			return scsj;
		}
		public void setScsj(Date scsj) {
			this.scsj = scsj;
		}
        	 
  		@TableField
		public String getBz() {
			return bz;
		}
		public void setBz(String bz) {
			this.bz = bz;
		}
		
		private String nsrsbh;
		private String nsrmc;

		public String getNsrsbh() {
			return nsrsbh;
		}
		public void setNsrsbh(String nsrsbh) {
			this.nsrsbh = nsrsbh;
		}
		public String getNsrmc() {
			return nsrmc;
		}
		public void setNsrmc(String nsrmc) {
			this.nsrmc = nsrmc;
		}
		
    }
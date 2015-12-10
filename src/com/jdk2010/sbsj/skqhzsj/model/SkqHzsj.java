package com.jdk2010.sbsj.skqhzsj.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqHzsj extends Model<SkqHzsj> {
        	/* id */
    	private Integer id;
        	/* 年 */
    	private Integer year;
        	/* 月 */
    	private Integer month;
        	/* 正常票份数 */
    	private Integer zcpfs;
        	/* 退票份数 */
    	private Integer tpfs;
        	/* 废票份数 */
    	private Integer fpfs;
        	/* 正常票总金额 */
    	private Double zcpzje;
        	/* 退票总金额 */
    	private Double tpzje;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 汇总日期 */
    	private Date hzrq;
        	/* 处理标志 */
    	private Integer clbz;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
        	 
  		@TableField
		public Integer getMonth() {
			return month;
		}
		public void setMonth(Integer month) {
			this.month = month;
		}
        	 
  		@TableField
		public Integer getZcpfs() {
			return zcpfs;
		}
		public void setZcpfs(Integer zcpfs) {
			this.zcpfs = zcpfs;
		}
        	 
  		@TableField
		public Integer getTpfs() {
			return tpfs;
		}
		public void setTpfs(Integer tpfs) {
			this.tpfs = tpfs;
		}
        	 
  		@TableField
		public Integer getFpfs() {
			return fpfs;
		}
		public void setFpfs(Integer fpfs) {
			this.fpfs = fpfs;
		}
        	 
  		@TableField
		public Double getZcpzje() {
			return zcpzje;
		}
		public void setZcpzje(Double zcpzje) {
			this.zcpzje = zcpzje;
		}
        	 
  		@TableField
		public Double getTpzje() {
			return tpzje;
		}
		public void setTpzje(Double tpzje) {
			this.tpzje = tpzje;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
        	 
  		@TableField
		public Date getHzrq() {
			return hzrq;
		}
		public void setHzrq(Date hzrq) {
			this.hzrq = hzrq;
		}
        	 
  		@TableField
		public Integer getClbz() {
			return clbz;
		}
		public void setClbz(Integer clbz) {
			this.clbz = clbz;
		}
    }
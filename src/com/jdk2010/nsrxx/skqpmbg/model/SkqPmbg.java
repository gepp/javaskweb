package com.jdk2010.nsrxx.skqpmbg.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqPmbg extends Model<SkqPmbg> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 原税目编码 */
    	private String ysmbm;
        	/* 变更税目编码 */
    	private String bgsmbm;
        	/* 变更说明 */
    	private String bgsm;
        	/* 申请时间 */
    	private Date sqsj;
        	/* 申请时间 */
    	private Integer clbz;
        	/* 处理者 */
    	private String clz;
        	/* 处理意见 */
    	private String clyj;
        	/* 处理意见 */
    	private Date clsj;
        	/* 处理意见 */
    	private Integer xzbs;
             	 
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
		public String getYsmbm() {
			return ysmbm;
		}
		public void setYsmbm(String ysmbm) {
			this.ysmbm = ysmbm;
		}
        	 
  		@TableField
		public String getBgsmbm() {
			return bgsmbm;
		}
		public void setBgsmbm(String bgsmbm) {
			this.bgsmbm = bgsmbm;
		}
        	 
  		@TableField
		public String getBgsm() {
			return bgsm;
		}
		public void setBgsm(String bgsm) {
			this.bgsm = bgsm;
		}
        	 
  		@TableField
		public Date getSqsj() {
			return sqsj;
		}
		public void setSqsj(Date sqsj) {
			this.sqsj = sqsj;
		}
        	 
  		@TableField
		public Integer getClbz() {
			return clbz;
		}
		public void setClbz(Integer clbz) {
			this.clbz = clbz;
		}
        	 
  		@TableField
		public String getClz() {
			return clz;
		}
		public void setClz(String clz) {
			this.clz = clz;
		}
        	 
  		@TableField
		public String getClyj() {
			return clyj;
		}
		public void setClyj(String clyj) {
			this.clyj = clyj;
		}
        	 
  		@TableField
		public Date getClsj() {
			return clsj;
		}
		public void setClsj(Date clsj) {
			this.clsj = clsj;
		}
        	 
  		@TableField
		public Integer getXzbs() {
			return xzbs;
		}
		public void setXzbs(Integer xzbs) {
			this.xzbs = xzbs;
		}
    }
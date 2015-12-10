package com.jdk2010.sbsj.skqjksjkz.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJksjkz extends Model<SkqJksjkz> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 原因 */
    	private String tzyy;
        	/* 限制时间 */
    	private Date tzsj;
        	/* 创建者 */
    	private String cjz;
        	/* 状态 */
    	private Integer status;
        	/* 开放时间 */
    	private Date kfsj;
             	 
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
		public String getTzyy() {
			return tzyy;
		}
		public void setTzyy(String tzyy) {
			this.tzyy = tzyy;
		}
        	 
  		@TableField
		public Date getTzsj() {
			return tzsj;
		}
		public void setTzsj(Date tzsj) {
			this.tzsj = tzsj;
		}
        	 
  		@TableField
		public String getCjz() {
			return cjz;
		}
		public void setCjz(String cjz) {
			this.cjz = cjz;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
        	 
  		@TableField
		public Date getKfsj() {
			return kfsj;
		}
		public void setKfsj(Date kfsj) {
			this.kfsj = kfsj;
		}
    }
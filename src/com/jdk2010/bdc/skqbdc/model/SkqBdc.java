package com.jdk2010.bdc.skqbdc.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdc extends Model<SkqBdc> {
        	/* id */
    	private Integer id;
        	/* 项目名称 */
    	private String xmmc;
        	/* 状态 */
    	private Integer status;
        	/* 创建者 */
    	private String cjz;
        	/* 创建时间 */
    	private Date cjsj;
        	/* 税务机关编码 */
    	private String swjgbm;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getXmmc() {
			return xmmc;
		}
		public void setXmmc(String xmmc) {
			this.xmmc = xmmc;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
        	 
  		@TableField
		public String getCjz() {
			return cjz;
		}
		public void setCjz(String cjz) {
			this.cjz = cjz;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
        	 
  		@TableField
		public String getSwjgbm() {
			return swjgbm;
		}
		public void setSwjgbm(String swjgbm) {
			this.swjgbm = swjgbm;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
    }
package com.jdk2010.system.skqzclx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqZclx extends Model<SkqZclx> {
        	/* id */
    	private Integer id;
        	/* 注册类型编码 */
    	private String zclxbm;
        	/* 注册类型名称 */
    	private String zclxmc;
        	/* 注册类型简称 */
    	private String zclxjc;
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
		public String getZclxbm() {
			return zclxbm;
		}
		public void setZclxbm(String zclxbm) {
			this.zclxbm = zclxbm;
		}
        	 
  		@TableField
		public String getZclxmc() {
			return zclxmc;
		}
		public void setZclxmc(String zclxmc) {
			this.zclxmc = zclxmc;
		}
        	 
  		@TableField
		public String getZclxjc() {
			return zclxjc;
		}
		public void setZclxjc(String zclxjc) {
			this.zclxjc = zclxjc;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
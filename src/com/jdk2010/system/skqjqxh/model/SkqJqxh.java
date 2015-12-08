package com.jdk2010.system.skqjqxh.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJqxh extends Model<SkqJqxh> {
        	/* id */
    	private Integer id;
        	/* 机器型号编码 */
    	private String jqxhbm;
        	/* 机器型号名称 */
    	private String jqxhmc;
        	/* 生产厂商 */
    	private String sccs;
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
		public String getJqxhbm() {
			return jqxhbm;
		}
		public void setJqxhbm(String jqxhbm) {
			this.jqxhbm = jqxhbm;
		}
        	 
  		@TableField
		public String getJqxhmc() {
			return jqxhmc;
		}
		public void setJqxhmc(String jqxhmc) {
			this.jqxhmc = jqxhmc;
		}
        	 
  		@TableField
		public String getSccs() {
			return sccs;
		}
		public void setSccs(String sccs) {
			this.sccs = sccs;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
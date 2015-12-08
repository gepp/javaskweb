package com.jdk2010.system.skqhy.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqHy extends Model<SkqHy> {
        	/* id */
    	private Integer id;
        	/* 行业编码 */
    	private String hybm;
        	/* 行业名称 */
    	private String hymc;
        	/* 行业简称 */
    	private String hyjc;
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
		public String getHybm() {
			return hybm;
		}
		public void setHybm(String hybm) {
			this.hybm = hybm;
		}
        	 
  		@TableField
		public String getHymc() {
			return hymc;
		}
		public void setHymc(String hymc) {
			this.hymc = hymc;
		}
        	 
  		@TableField
		public String getHyjc() {
			return hyjc;
		}
		public void setHyjc(String hyjc) {
			this.hyjc = hyjc;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
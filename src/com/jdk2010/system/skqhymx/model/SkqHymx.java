package com.jdk2010.system.skqhymx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqHymx extends Model<SkqHymx> {
        	/* id */
    	private Integer id;
        	/* 行业编码ID */
    	private Integer hyid;
        	/* 行业编码 */
    	private String hybm;
        	/* 行业明细编码 */
    	private String hymxbm;
        	/* 行业明细名称 */
    	private String hymxmc;
        	/* 行业明细简称 */
    	private String hymxjc;
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
		public Integer getHyid() {
			return hyid;
		}
		public void setHyid(Integer hyid) {
			this.hyid = hyid;
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
		public String getHymxmc() {
			return hymxmc;
		}
		public void setHymxmc(String hymxmc) {
			this.hymxmc = hymxmc;
		}
        	 
  		@TableField
		public String getHymxjc() {
			return hymxjc;
		}
		public void setHymxjc(String hymxjc) {
			this.hymxjc = hymxjc;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
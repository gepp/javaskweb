package com.jdk2010.system.skqfp.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqFp extends Model<SkqFp> {
        	/* id */
    	private Integer id;
        	/* 票种编码 */
    	private String fpbm;
        	/* 票种名称 */
    	private String fpmc;
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
		public String getFpbm() {
			return fpbm;
		}
		public void setFpbm(String fpbm) {
			this.fpbm = fpbm;
		}
        	 
  		@TableField
		public String getFpmc() {
			return fpmc;
		}
		public void setFpmc(String fpmc) {
			this.fpmc = fpmc;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
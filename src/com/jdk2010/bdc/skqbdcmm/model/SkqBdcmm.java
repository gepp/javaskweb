package com.jdk2010.bdc.skqbdcmm.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdcmm extends Model<SkqBdcmm> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 密码 */
    	private String password;
        	/* 创建时间 */
    	private Date cjsj;
             	 
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
    }
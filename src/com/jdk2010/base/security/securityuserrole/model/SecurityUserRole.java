package com.jdk2010.base.security.securityuserrole.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityUserRole extends Model<SecurityUserRole> {
        	/* id */
    	private Integer id;
        	/* user_id */
    	private Integer userId;
        	/* role_id */
    	private String roleId;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
        	 
  		@TableField
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
    }
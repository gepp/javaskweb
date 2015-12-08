package com.jdk2010.base.security.securityorganizationuser.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityOrganizationUser extends Model<SecurityOrganizationUser> {
        	/* id */
    	private Integer id;
        	/* user_id */
    	private String userId;
        	/* organization_id */
    	private Integer organizationId;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
        	 
  		@TableField
		public Integer getOrganizationId() {
			return organizationId;
		}
		public void setOrganizationId(Integer organizationId) {
			this.organizationId = organizationId;
		}
    }
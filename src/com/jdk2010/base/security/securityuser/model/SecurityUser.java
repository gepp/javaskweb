package com.jdk2010.base.security.securityuser.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityUser extends Model<SecurityUser> {
        	/* ID */
    	private Integer id;
        	/* 代码 */
    	private String code;
        	/* 姓名 */
    	private String username;
        	/* 邮箱 */
    	private String email;
        	/* 密码 */
    	private String userpwd;
        	/* 手机 */
    	private String phone;
        	/* 真实姓名 */
    	private String realname;
        	/* 状态 */
    	private Integer status;
        	/* 创建时间 */
    	private Date ctime;
        	/* 组织编码 */
    	private Integer organizationId;
        
    	private String organizationName;
    	
  		public String getOrganizationName() {
            return organizationName;
        }
        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }
        @TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
		@TableField
  		public String getUserpwd() {
            return userpwd;
        }
        public void setUserpwd(String userpwd) {
            this.userpwd = userpwd;
        }
        @TableField
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
        	 
  		@TableField
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
        	 
  		@TableField
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
        	 
  	 
        	 
  		@TableField
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
        	 
  		@TableField
		public String getRealname() {
			return realname;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
        	 
  		@TableField
		public Date getCtime() {
			return ctime;
		}
		public void setCtime(Date ctime) {
			this.ctime = ctime;
		}
		@TableField
        public Integer getOrganizationId() {
            return organizationId;
        }
        public void setOrganizationId(Integer organizationId) {
            this.organizationId = organizationId;
        }
        	 
  		 
    }
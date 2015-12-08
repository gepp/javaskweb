package com.jdk2010.base.security.securityrole.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityRole extends Model<SecurityRole> {
        	/* id */
    	private Integer id;
        	/* 编码 */
    	private String code;
        	/* 角色名称 */
    	private String name;
        	/* 角色描述 */
    	private String description;
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
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
        	 
  		@TableField
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
        	 
  		@TableField
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }
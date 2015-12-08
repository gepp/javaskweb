package com.jdk2010.base.security.securityrolemenu.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityRoleMenu extends Model<SecurityRoleMenu> {
        	/* id */
    	private Integer id;
        	/* role_id */
    	private Integer roleId;
        	/* menu_id */
    	private Integer menuId;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
        	 
  		@TableField
		public Integer getMenuId() {
			return menuId;
		}
		public void setMenuId(Integer menuId) {
			this.menuId = menuId;
		}
    }
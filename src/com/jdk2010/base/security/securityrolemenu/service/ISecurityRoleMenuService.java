package com.jdk2010.base.security.securityrolemenu.service; 
import java.util.List;

import com.jdk2010.base.security.securityrolemenu.model.SecurityRoleMenu;
import com.jdk2010.base.service.IBaseService;
public interface ISecurityRoleMenuService  extends IBaseService{

    public List<SecurityRoleMenu> getSecurityRoleMenuByRoleId(Integer roleId);
    
    public void  deleteSecurityRoleMenuByRoleId(Integer roleId);
}

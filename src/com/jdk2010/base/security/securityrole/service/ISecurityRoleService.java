package com.jdk2010.base.security.securityrole.service; 
import com.jdk2010.base.service.IBaseService;
public interface ISecurityRoleService  extends IBaseService{
    
    public boolean isExistRoleCode(String code);
    
}

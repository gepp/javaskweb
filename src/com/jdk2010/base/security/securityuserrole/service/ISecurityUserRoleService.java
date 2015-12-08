package com.jdk2010.base.security.securityuserrole.service;

import java.util.List;

import com.jdk2010.base.security.securityuserrole.model.SecurityUserRole;
import com.jdk2010.base.service.IBaseService;

public interface ISecurityUserRoleService extends IBaseService {

    public List<SecurityUserRole> getSecurityUserRoleByRoleId(Integer roleId);
    
    public void deleteSecurityUserRoleByUserId(Integer userId);
    
    public List<SecurityUserRole> getSecurityUserRoleByUserId(Integer userId);
}

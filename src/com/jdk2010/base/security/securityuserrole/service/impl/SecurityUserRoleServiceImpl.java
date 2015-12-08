package com.jdk2010.base.security.securityuserrole.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.jdk2010.base.security.securityuserrole.model.SecurityUserRole;
import com.jdk2010.base.security.securityuserrole.service.ISecurityUserRoleService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityUserRoleService")
public class SecurityUserRoleServiceImpl extends BaseServiceImpl implements ISecurityUserRoleService {
    @Resource
    DalClient dalClient;

    @Override
    public List<SecurityUserRole> getSecurityUserRoleByRoleId(Integer roleId) {
        String sql = "select * from security_user_role where role_id=" + roleId;
        return dalClient.queryForObjectList(sql, SecurityUserRole.class);
    }

    @Override
    public void deleteSecurityUserRoleByUserId(Integer userId) {
        String sql = "delete from security_user_role where user_id=" + userId;
        dalClient.update(sql);

    }

    @Override
    public List<SecurityUserRole> getSecurityUserRoleByUserId(Integer userId) {
        String sql = "select * from security_user_role where user_id=" + userId;
        return dalClient.queryForObjectList(sql, SecurityUserRole.class);
    }

}

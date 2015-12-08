package com.jdk2010.base.security.securityrolemenu.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.base.security.securityrolemenu.model.SecurityRoleMenu;
import com.jdk2010.base.security.securityrolemenu.service.ISecurityRoleMenuService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityRoleMenuService")
public class SecurityRoleMenuServiceImpl extends BaseServiceImpl implements ISecurityRoleMenuService{
  	@Resource
    DalClient dalClient;

    @Override
    public List<SecurityRoleMenu> getSecurityRoleMenuByRoleId(Integer roleId) {
        String sql="select * from security_role_menu where role_id="+roleId+"";
        return dalClient.queryForObjectList(sql,SecurityRoleMenu.class);
    }

    @Override
    public void deleteSecurityRoleMenuByRoleId(Integer roleId) {
        String sql="delete from security_role_menu where role_id="+roleId+"";
        dalClient.update(sql);
        
    }
}

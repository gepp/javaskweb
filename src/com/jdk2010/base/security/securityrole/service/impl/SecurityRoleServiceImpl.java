package com.jdk2010.base.security.securityrole.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jdk2010.base.security.securityrole.service.ISecurityRoleService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;

@Service("securityRoleService")
public class SecurityRoleServiceImpl extends BaseServiceImpl implements ISecurityRoleService{
  	@Resource
    DalClient dalClient;

    @Override
    public boolean isExistRoleCode(String code) {
        String sql="select * from security_role where code='"+code+"'";
        List<Map<String,Object>> roleList=dalClient.queryForObjectList(sql);
        if(roleList.size()>0){
            return true;
        }else{
            return false;
        }
        
    }
}

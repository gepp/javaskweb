package com.jdk2010.base.security.securityorganizationuser.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.base.security.securityorganizationuser.service.ISecurityOrganizationUserService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityOrganizationUserService")
public class SecurityOrganizationUserServiceImpl extends BaseServiceImpl implements ISecurityOrganizationUserService{
  	@Resource
    DalClient dalClient;
}

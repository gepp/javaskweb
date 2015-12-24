package com.jdk2010.base.security.securitynews.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.base.security.securitynews.service.ISecurityNewsService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityNewsService")
public class SecurityNewsServiceImpl extends BaseServiceImpl implements ISecurityNewsService{
  	@Resource
    DalClient dalClient;
}

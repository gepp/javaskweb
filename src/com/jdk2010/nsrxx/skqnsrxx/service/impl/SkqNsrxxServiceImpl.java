package com.jdk2010.nsrxx.skqnsrxx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqNsrxxService")
public class SkqNsrxxServiceImpl extends BaseServiceImpl implements ISkqNsrxxService{
  	@Resource
    DalClient dalClient;
}

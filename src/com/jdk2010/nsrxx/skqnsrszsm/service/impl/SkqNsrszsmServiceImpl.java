package com.jdk2010.nsrxx.skqnsrszsm.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqNsrszsmService")
public class SkqNsrszsmServiceImpl extends BaseServiceImpl implements ISkqNsrszsmService{
  	@Resource
    DalClient dalClient;
}

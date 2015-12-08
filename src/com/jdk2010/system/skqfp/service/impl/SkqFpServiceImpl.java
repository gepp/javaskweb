package com.jdk2010.system.skqfp.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqfp.service.ISkqFpService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqFpService")
public class SkqFpServiceImpl extends BaseServiceImpl implements ISkqFpService{
  	@Resource
    DalClient dalClient;
}

package com.jdk2010.invoice.skqfpjmx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.invoice.skqfpjmx.service.ISkqFpjmxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqFpjmxService")
public class SkqFpjmxServiceImpl extends BaseServiceImpl implements ISkqFpjmxService{
  	@Resource
    DalClient dalClient;
}

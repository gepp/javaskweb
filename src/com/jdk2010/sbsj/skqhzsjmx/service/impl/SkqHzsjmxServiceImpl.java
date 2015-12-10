package com.jdk2010.sbsj.skqhzsjmx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqhzsjmx.service.ISkqHzsjmxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqHzsjmxService")
public class SkqHzsjmxServiceImpl extends BaseServiceImpl implements ISkqHzsjmxService{
  	@Resource
    DalClient dalClient;
}

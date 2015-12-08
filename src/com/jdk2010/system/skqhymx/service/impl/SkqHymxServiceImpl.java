package com.jdk2010.system.skqhymx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqhymx.service.ISkqHymxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqHymxService")
public class SkqHymxServiceImpl extends BaseServiceImpl implements ISkqHymxService{
  	@Resource
    DalClient dalClient;
}

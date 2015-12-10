package com.jdk2010.bdc.skqbdc.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdc.service.ISkqBdcService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdcService")
public class SkqBdcServiceImpl extends BaseServiceImpl implements ISkqBdcService{
  	@Resource
    DalClient dalClient;
}

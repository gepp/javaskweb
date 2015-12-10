package com.jdk2010.bdc.skqbdcmm.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdcmm.service.ISkqBdcmmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdcmmService")
public class SkqBdcmmServiceImpl extends BaseServiceImpl implements ISkqBdcmmService{
  	@Resource
    DalClient dalClient;
}

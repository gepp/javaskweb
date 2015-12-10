package com.jdk2010.bdc.skqbdclp.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdclp.service.ISkqBdclpService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdclpService")
public class SkqBdclpServiceImpl extends BaseServiceImpl implements ISkqBdclpService{
  	@Resource
    DalClient dalClient;
}

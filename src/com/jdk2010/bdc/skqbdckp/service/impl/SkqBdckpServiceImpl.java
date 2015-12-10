package com.jdk2010.bdc.skqbdckp.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdckp.service.ISkqBdckpService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdckpService")
public class SkqBdckpServiceImpl extends BaseServiceImpl implements ISkqBdckpService{
  	@Resource
    DalClient dalClient;
}

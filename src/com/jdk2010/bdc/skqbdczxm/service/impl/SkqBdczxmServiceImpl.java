package com.jdk2010.bdc.skqbdczxm.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdczxm.service.ISkqBdczxmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdczxmService")
public class SkqBdczxmServiceImpl extends BaseServiceImpl implements ISkqBdczxmService{
  	@Resource
    DalClient dalClient;
}

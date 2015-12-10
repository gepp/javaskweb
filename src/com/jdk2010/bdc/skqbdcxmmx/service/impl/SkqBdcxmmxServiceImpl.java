package com.jdk2010.bdc.skqbdcxmmx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdcxmmx.service.ISkqBdcxmmxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdcxmmxService")
public class SkqBdcxmmxServiceImpl extends BaseServiceImpl implements ISkqBdcxmmxService{
  	@Resource
    DalClient dalClient;
}

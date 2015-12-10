package com.jdk2010.nsrxx.skqdhde.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.nsrxx.skqdhde.service.ISkqDhdeService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqDhdeService")
public class SkqDhdeServiceImpl extends BaseServiceImpl implements ISkqDhdeService{
  	@Resource
    DalClient dalClient;
}

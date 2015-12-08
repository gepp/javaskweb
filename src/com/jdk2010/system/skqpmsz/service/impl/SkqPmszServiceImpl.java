package com.jdk2010.system.skqpmsz.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqpmsz.service.ISkqPmszService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqPmszService")
public class SkqPmszServiceImpl extends BaseServiceImpl implements ISkqPmszService{
  	@Resource
    DalClient dalClient;
}

package com.jdk2010.system.skqhy.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqhy.service.ISkqHyService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqHyService")
public class SkqHyServiceImpl extends BaseServiceImpl implements ISkqHyService{
  	@Resource
    DalClient dalClient;
}

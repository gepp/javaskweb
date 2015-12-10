package com.jdk2010.jzaz.skqjzaz.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.jzaz.skqjzaz.service.ISkqJzazService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJzazService")
public class SkqJzazServiceImpl extends BaseServiceImpl implements ISkqJzazService{
  	@Resource
    DalClient dalClient;
}

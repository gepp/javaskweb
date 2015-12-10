package com.jdk2010.jzaz.skqjzazkp.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.jzaz.skqjzazkp.service.ISkqJzazkpService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJzazkpService")
public class SkqJzazkpServiceImpl extends BaseServiceImpl implements ISkqJzazkpService{
  	@Resource
    DalClient dalClient;
}

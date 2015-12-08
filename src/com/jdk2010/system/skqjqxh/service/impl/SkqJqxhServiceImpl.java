package com.jdk2010.system.skqjqxh.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqjqxh.service.ISkqJqxhService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJqxhService")
public class SkqJqxhServiceImpl extends BaseServiceImpl implements ISkqJqxhService{
  	@Resource
    DalClient dalClient;
}

package com.jdk2010.jqxx.skqjqxx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJqxxService")
public class SkqJqxxServiceImpl extends BaseServiceImpl implements ISkqJqxxService{
  	@Resource
    DalClient dalClient;
}

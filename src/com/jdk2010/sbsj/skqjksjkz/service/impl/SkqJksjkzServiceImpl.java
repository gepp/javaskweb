package com.jdk2010.sbsj.skqjksjkz.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqjksjkz.service.ISkqJksjkzService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJksjkzService")
public class SkqJksjkzServiceImpl extends BaseServiceImpl implements ISkqJksjkzService{
  	@Resource
    DalClient dalClient;
}

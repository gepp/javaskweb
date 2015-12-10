package com.jdk2010.sbsj.skqjsgz.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqjsgz.service.ISkqJsgzService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJsgzService")
public class SkqJsgzServiceImpl extends BaseServiceImpl implements ISkqJsgzService{
  	@Resource
    DalClient dalClient;
}

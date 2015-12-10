package com.jdk2010.sbsj.skqsbsjmx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqsbsjmx.service.ISkqSbsjmxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqSbsjmxService")
public class SkqSbsjmxServiceImpl extends BaseServiceImpl implements ISkqSbsjmxService{
  	@Resource
    DalClient dalClient;
}

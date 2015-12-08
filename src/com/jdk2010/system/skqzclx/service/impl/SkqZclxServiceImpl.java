package com.jdk2010.system.skqzclx.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.system.skqzclx.service.ISkqZclxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqZclxService")
public class SkqZclxServiceImpl extends BaseServiceImpl implements ISkqZclxService{
  	@Resource
    DalClient dalClient;
}

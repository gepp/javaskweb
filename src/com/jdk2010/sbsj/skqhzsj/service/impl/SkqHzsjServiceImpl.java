package com.jdk2010.sbsj.skqhzsj.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqhzsj.service.ISkqHzsjService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqHzsjService")
public class SkqHzsjServiceImpl extends BaseServiceImpl implements ISkqHzsjService{
  	@Resource
    DalClient dalClient;
}

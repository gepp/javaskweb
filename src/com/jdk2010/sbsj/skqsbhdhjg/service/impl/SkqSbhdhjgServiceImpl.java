package com.jdk2010.sbsj.skqsbhdhjg.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqsbhdhjg.service.ISkqSbhdhjgService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqSbhdhjgService")
public class SkqSbhdhjgServiceImpl extends BaseServiceImpl implements ISkqSbhdhjgService{
  	@Resource
    DalClient dalClient;
}

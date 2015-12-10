package com.jdk2010.sbsj.skqsbsj.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqsbsj.service.ISkqSbsjService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqSbsjService")
public class SkqSbsjServiceImpl extends BaseServiceImpl implements ISkqSbsjService{
  	@Resource
    DalClient dalClient;
}

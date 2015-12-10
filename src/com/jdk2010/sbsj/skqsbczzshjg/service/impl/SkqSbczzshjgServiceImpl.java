package com.jdk2010.sbsj.skqsbczzshjg.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqsbczzshjg.service.ISkqSbczzshjgService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqSbczzshjgService")
public class SkqSbczzshjgServiceImpl extends BaseServiceImpl implements ISkqSbczzshjgService{
  	@Resource
    DalClient dalClient;
}

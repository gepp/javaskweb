package com.jdk2010.sbsj.skqskjs.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqskjs.service.ISkqSkjsService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqSkjsService")
public class SkqSkjsServiceImpl extends BaseServiceImpl implements ISkqSkjsService{
  	@Resource
    DalClient dalClient;
}

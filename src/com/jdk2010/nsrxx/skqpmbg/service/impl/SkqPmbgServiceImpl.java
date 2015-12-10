package com.jdk2010.nsrxx.skqpmbg.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.nsrxx.skqpmbg.service.ISkqPmbgService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqPmbgService")
public class SkqPmbgServiceImpl extends BaseServiceImpl implements ISkqPmbgService{
  	@Resource
    DalClient dalClient;
}

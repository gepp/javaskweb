package com.jdk2010.nsrxx.skqxebg.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.nsrxx.skqxebg.service.ISkqXebgService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqXebgService")
public class SkqXebgServiceImpl extends BaseServiceImpl implements ISkqXebgService{
  	@Resource
    DalClient dalClient;
}

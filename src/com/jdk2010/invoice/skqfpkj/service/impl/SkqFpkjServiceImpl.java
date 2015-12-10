package com.jdk2010.invoice.skqfpkj.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.invoice.skqfpkj.service.ISkqFpkjService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqFpkjService")
public class SkqFpkjServiceImpl extends BaseServiceImpl implements ISkqFpkjService{
  	@Resource
    DalClient dalClient;
}

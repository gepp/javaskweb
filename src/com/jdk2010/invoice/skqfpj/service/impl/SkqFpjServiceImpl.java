package com.jdk2010.invoice.skqfpj.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqFpjService")
public class SkqFpjServiceImpl extends BaseServiceImpl implements ISkqFpjService{
  	@Resource
    DalClient dalClient;
}

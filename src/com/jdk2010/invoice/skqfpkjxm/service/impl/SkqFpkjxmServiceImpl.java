package com.jdk2010.invoice.skqfpkjxm.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.invoice.skqfpkjxm.service.ISkqFpkjxmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqFpkjxmService")
public class SkqFpkjxmServiceImpl extends BaseServiceImpl implements ISkqFpkjxmService{
  	@Resource
    DalClient dalClient;
}

package com.jdk2010.sbsj.skqwdhxh.service.impl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.sbsj.skqwdhxh.service.ISkqWdhxhService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqWdhxhService")
public class SkqWdhxhServiceImpl extends BaseServiceImpl implements ISkqWdhxhService{
  	@Resource
    DalClient dalClient;
}

package com.jdk2010.jqxx.skqjqszsm.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqszsm.service.ISkqJqszsmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJqszsmService")
public class SkqJqszsmServiceImpl extends BaseServiceImpl implements ISkqJqszsmService{
  	@Resource
    DalClient dalClient;

    @Override
    public List<SkqJqszsm> getJqszsmListByJqbh(String jqbh) {
        return dalClient.queryForObjectList("select * from skq_jqszsm where jqbh='"+jqbh+"'",SkqJqszsm.class);
    }
}

package com.jdk2010.nsrxx.skqnsrszsm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqNsrszsmService")
public class SkqNsrszsmServiceImpl extends BaseServiceImpl implements ISkqNsrszsmService {
    @Resource
    DalClient dalClient;

    @Override
    public List<SkqNsrszsm> getNsrszsmList(String nsrwjbm) {
        List<SkqNsrszsm> nsrszsmList = dalClient.queryForObjectList("select * from skq_nsrszsm where NSRWJBM='"
                + nsrwjbm + "'", SkqNsrszsm.class);
        return nsrszsmList;
    }

    @Override
    public void deleteNsrszsmByNsrwjbm(String nsrwjbm) {
        dalClient.update("delete from skq_nsrszsm where nsrwjbm='" + nsrwjbm + "'");
    }

}

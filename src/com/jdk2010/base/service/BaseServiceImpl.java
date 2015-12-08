package com.jdk2010.base.service;

import javax.annotation.Resource;

import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.dal.dialect.IDialect;
import com.jdk2010.framework.service.impl.AbstractBaseServiceImpl;

public class BaseServiceImpl extends AbstractBaseServiceImpl {

    @Resource
    public IDialect mysqlDialect;

    @Resource
    public DalClient dalClient;

    @Override
    public DalClient getDalClient() {
        return dalClient;
    }

    @Override
    public IDialect getDialect() {
        return mysqlDialect;
    }

}

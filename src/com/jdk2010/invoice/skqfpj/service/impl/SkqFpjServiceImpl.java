package com.jdk2010.invoice.skqfpj.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;

@Service("skqFpjService")
public class SkqFpjServiceImpl extends BaseServiceImpl implements
		ISkqFpjService {
	@Resource
	DalClient dalClient;

	@Override
	public List<SkqFpjmx> selectFpxf(String nsrwjbm) {
		String sql = "select * from SKQ_FPJMX where NSRWJBM='" + nsrwjbm
				+ "' and FPXFZT=0";
		List<SkqFpjmx> fpjmxList = dalClient.queryForObjectList(sql,
				SkqFpjmx.class);
		return fpjmxList;
	}
}

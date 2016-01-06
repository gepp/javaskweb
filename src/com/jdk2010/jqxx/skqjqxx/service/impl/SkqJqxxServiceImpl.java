package com.jdk2010.jqxx.skqjqxx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqszsm.service.ISkqJqszsmService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJqxxService")
public class SkqJqxxServiceImpl extends BaseServiceImpl implements
		ISkqJqxxService {
	@Resource
	DalClient dalClient;

	@Resource
	ISkqJqszsmService skqJqszsmService;

	@Override
	public List<SkqJqxx> getJqxxListByNsrwjbm(String nsrwjbm) {
		List<SkqJqxx> jqxxList = dalClient
				.queryForObjectList(
						"select t.*,a.nsrmc,b.jqxhmc from skq_jqxx t left join skq_nsrxx a on t.nsrwjbm=a.nsrwjbm left join skq_jqxh b on t.jqxhbm=b.jqxhbm where t.nsrwjbm='"
								+ nsrwjbm + "'", SkqJqxx.class);
		for (SkqJqxx jqxx : jqxxList) {
			List<SkqJqszsm> jqszsmList = skqJqszsmService
					.getJqszsmListByJqbh(jqxx.getJqbh());
			if (jqszsmList != null) {
				jqxx.setJqszsmList(jqszsmList);
			}
		}

		return jqxxList;
	}

	@Override
	public SkqJqxx getJqxxByJqbh(String jqbh) {
		SkqJqxx jqxx = dalClient.queryForObject(
				"select * from skq_jqxx where jqbh='" + jqbh + "'",
				SkqJqxx.class);
		if (jqxx != null) {
			List<SkqJqszsm> jqszsmList = skqJqszsmService
					.getJqszsmListByJqbh(jqxx.getJqbh());
			if (jqszsmList != null && jqxx != null) {
				jqxx.setJqszsmList(jqszsmList);
			}
		}
		return jqxx;
	}

	@Override
	public void deleteJqszsmByJqbh(String jqbh) {
		dalClient.update("delete from skq_jqszsm where jqbh='" + jqbh + "'");
	}

	@Override
	public boolean isExistsSKKH(String skkh) {
		String sql = "select * from skq_jqxx where skkh='" + skkh + "'";
		List<Map<String, Object>> list = dalClient.queryForObjectList(sql);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExistsYHKH(String yhkh) {
		String sql = "select * from skq_jqxx where yhkh='" + yhkh + "'";
		List<Map<String, Object>> list = dalClient.queryForObjectList(sql);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExistsJQBH(String jqbh) {
		String sql = "select * from skq_jqxx where jqbh='" + jqbh + "'";
		List<Map<String, Object>> list = dalClient.queryForObjectList(sql);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}

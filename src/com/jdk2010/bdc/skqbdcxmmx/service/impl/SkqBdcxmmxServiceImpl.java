package com.jdk2010.bdc.skqbdcxmmx.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.bdc.skqbdcxmmx.service.ISkqBdcxmmxService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqBdcxmmxService")
public class SkqBdcxmmxServiceImpl extends BaseServiceImpl implements ISkqBdcxmmxService{
  	@Resource
    DalClient dalClient;

	public long getBdcxmmxLsh() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String cxrq = sdf1.format(new Date());
		// TODO Auto-generated method stub
		Map<String,Object> map = dalClient.queryForObject("select count(id) as num from SKQ_BDCXMMX where CJSJ>='"+cxrq+"'");
		long lsh = (Long)map.get("num");
		return lsh;
	}

	@Override
	public long getBdcLpCount(String ids) {
		// TODO Auto-generated method stub
		Map<String,Object> map = dalClient.queryForObject("select count(id) as num from skq_bdclp where parentid in("+ids+")");
		long num = (Long)map.get("num");
		return num;
	}
}

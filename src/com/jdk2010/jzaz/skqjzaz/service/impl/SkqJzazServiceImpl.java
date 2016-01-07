package com.jdk2010.jzaz.skqjzaz.service.impl;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
 
import com.jdk2010.jzaz.skqjzaz.service.ISkqJzazService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("skqJzazService")
public class SkqJzazServiceImpl extends BaseServiceImpl implements ISkqJzazService{
  	@Resource
    DalClient dalClient;

	@Override
	public long getJzazLsh() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String cxrq = sdf1.format(new Date());
		// TODO Auto-generated method stub
		Map<String,Object> map = dalClient.queryForObject("select count(id) as num from SKQ_JZAZ where PARENTID=0 and CJSJ>='"+cxrq+"'");
		long lsh = (Long)map.get("num");
		return lsh;
	}
	
	@Override
	public long getJzazFbLsh(String parentid) {
		Map<String,Object> map = dalClient.queryForObject("select count(id) as num from SKQ_JZAZ where PARENTID="+parentid);
		long lsh = (Long)map.get("num");
		return lsh;
	}

	@Override
	public double getJzazKpje(String id) {
		// TODO Auto-generated method stub
		Map<String,Object> map = dalClient.queryForObject("select sum(HJZJE) as zcpzje from SKQ_JZAZKP where PARENTID="+id+" and KPLX=1");
		Double zcpzje = (Double)map.get("zcpzje");
		if(zcpzje==null){
			zcpzje = (double) 0;
		}
		Map<String,Object> map1 = dalClient.queryForObject("select sum(HJZJE) as tpzje from SKQ_JZAZKP where PARENTID="+id+" and KPLX=2");
		Double tpzje = (Double)map1.get("tpzje");
		if(tpzje==null){
			tpzje = (double) 0;
		}
		double kpje = zcpzje-tpzje;
		return kpje;
	}

	@Override
	public double getJzazSyje(String id, String parentid, double zbxmje) {
		String sqlStr = "";
		if(id!=null&&!"".equals(id)){
			sqlStr = " and id!="+id;
		}
		Map<String,Object> map1 = dalClient.queryForObject("select sum(GCK) as GCK from SKQ_JZAZ where PARENTID="+parentid+sqlStr);
		BigDecimal gck1 = (BigDecimal)map1.get("gck");
		if(gck1==null){
			gck1 = new BigDecimal(0.00);
		}
		Double gck = (gck1).doubleValue();
		
		double syje = zbxmje-gck;
		return syje;
	}
}

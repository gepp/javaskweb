package com.jdk2010.nsrxx.skqnsrxx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;

@Service("skqNsrxxService")
public class SkqNsrxxServiceImpl extends BaseServiceImpl implements ISkqNsrxxService {
    @Resource
    DalClient dalClient;

    @Resource
    ISkqNsrszsmService skqNsrszsmService;

    @Resource
    ISkqJqxxService skqJqxxService;

    @Override
    public SkqNsrxx getNsrxxByNsrwjbm(String nsrwjbm) {
        SkqNsrxx nsrxx = dalClient
                .queryForObject(
                        "select t.*,a.hymc,b.hymxmc,c.zclxmc,d.name as swjgmc from skq_nsrxx t left join skq_hy a on t.hybm=a.hybm left join skq_hymx b on t.hymxbm=b.hymxbm left join skq_zclx c on t.zclxbm=c.zclxbm left join security_organization d on t.swjgbm=d.code where t.nsrwjbm='"
                                + nsrwjbm + "'", SkqNsrxx.class);
        List<SkqNsrszsm> nsrszsmList = skqNsrszsmService.getNsrszsmList(nsrwjbm);
        if (nsrszsmList != null) {
            nsrxx.setNsrszsmList(nsrszsmList);
        }
        List<SkqJqxx> jqxxList = skqJqxxService.getJqxxListByNsrwjbm(nsrwjbm);
        if (jqxxList != null) {
            nsrxx.setJqxxList(jqxxList);
        }
        return nsrxx;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        ISkqNsrxxService nsrxxService = factory.getBean(ISkqNsrxxService.class);
//        SkqNsrxx nsrxx = nsrxxService.getNsrxxByNsrwjbm("1");
//        System.out.println(nsrxx.getNsrszsmList().size());
        System.out.println(nsrxxService.getNsrwjbmByNsrsbh("234234242"));
    }

	@Override
	public String getNsrwjbmByNsrsbh(String nsrsbh) {
		String nsrwjbm = dalClient.queryColumn("select NSRWJBM from skq_nsrxx where NSRSBH='"+nsrsbh+"'", "NSRWJBM");
		return nsrwjbm;
	}

    @Override
    public boolean isExistsNsrwjbm(String nsrwjbm) {
        String sql = "select * from skq_nsrxx where nsrwjbm='" + nsrwjbm + "'";
        List<Map<String, Object>> list = dalClient.queryForObjectList(sql);
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}

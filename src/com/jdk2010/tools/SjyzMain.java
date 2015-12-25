package com.jdk2010.tools;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;

public class SjyzMain {
 
 
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        DalClient mysqlDalClient=(DalClient)factory.getBean("dalClient");
        DalClient sybaseDalClient=(DalClient)factory.getBean("sybaseDalClient");
//        DalClient oracleDalClient=(DalClient)factory.getBean("oracleDalClient");
//        System.out.println("======移植t_hx_org_config======");
//        List<THxOrgConfig> listOrgConfig=oracleDalClient.queryForObjectList("select * from t_hx_org_config",THxOrgConfig.class);
//        for(int i=0;i<listOrgConfig.size();i++){
//            mysqlDalClient.save(listOrgConfig.get(i));
//        }
//        System.out.println("======移植t_hx_org_config结束======");
        
        System.out.println("======移植skq_nsrxx======");
        List<SkqNsrxx> nsrxxList=sybaseDalClient.queryForObjectList("select * from skq_nsrxx",SkqNsrxx.class);
        System.out.println("总共："+nsrxxList.size()+"条记录等待移植...");
        for(int i=0;i<nsrxxList.size();i++){
            System.out.println("剩余移植记录："+(nsrxxList.size()-i));
            mysqlDalClient.save(nsrxxList.get(i));
        }
        System.out.println("======移植skq_nsrxx结束======");
        
    }
}

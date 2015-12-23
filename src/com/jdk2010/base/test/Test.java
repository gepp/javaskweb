package com.jdk2010.base.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.base.security.menu.model.SecurityMenu;
import com.jdk2010.base.security.securityorganization.model.SecurityOrganization;
import com.jdk2010.framework.dal.client.DalClient;

public class Test {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        DalClient oracleDalClient=(DalClient)factory.getBean("oracleDalClient");
        List<Map<String,Object>> mapList=oracleDalClient.queryForObjectList("select * from BAK_T_HX_ORG_CONFIG t");
        for(Map<String,Object> map:mapList){
            System.out.println(map.get("saleorg"));
        }
    }
}

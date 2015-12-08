package com.jdk2010.base.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.base.security.menu.model.SecurityMenu;
import com.jdk2010.base.security.securityorganization.model.SecurityOrganization;
import com.jdk2010.framework.dal.client.DalClient;

public class Test {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        DalClient dalClient = factory.getBean(DalClient.class);
        String id="1";
        SecurityOrganization securityMenu = dalClient.findById("2", SecurityOrganization.class);
        System.out.println(securityMenu.getOrderlist());
    }
}

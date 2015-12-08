package com.jdk2010.base.security.securityorganization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityOrganizationService")
public class SecurityOrganizationServiceImpl extends BaseServiceImpl implements ISecurityOrganizationService {
    @Resource
    DalClient dalClient;

    @Override
    public List<Map<String, Object>> getOrganizationByParentId(String pid) throws Exception {
        DbKit dbKit = new DbKit("select * from security_organization  where parent_id='" + pid
                + "' order by orderlist asc");
        List<Map<String, Object>> List = dalClient.queryForObjectList(dbKit);
        return List;
    }

    @Override
    public List<Map<String, Object>> getOrganizationListByParentId(String pid) throws Exception {
        List returnList = new ArrayList<Map<String, Object>>();
        List menuList = getOrganizationByParentId(pid);
        for (int i = 0; i < menuList.size(); i++) {
            Map map = (HashMap<String, Object>) menuList.get(i);
            returnList.add(map);
            int k = 0;
            String leftStr = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            for (int m = 0; m < k; m++) {
                leftStr = leftStr + leftStr;
            }
            // String span="<span style=\"margin-left:"+leftStr+"px;\"></span>";
            if (getOrganizationByParentId(map.get("id") + "").size() > 0) {
                k = k + 1;
                List returnListChild = getOrganizationListByParentId(map.get("id") + "");
                for (int j = 0; j < returnListChild.size(); j++) {
                    Map childmap = (HashMap) returnListChild.get(j);
                    childmap.put("name", leftStr + childmap.get("name"));
                    childmap.put("orderlist", childmap.get("orderlist"));
                    returnList.add(childmap);
                }
            }
        }
        return returnList;
    }
    
    public static void main(String[] args) throws Exception {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        ISecurityOrganizationService securityOrganizationService=factory.getBean(ISecurityOrganizationService.class);
        List<Map<String, Object>> list=securityOrganizationService.getOrganizationListByParentId("0");
        for(Map<String,Object> map:list){
            System.out.println(map.get("name"));
        }
    }
}

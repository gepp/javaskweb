package com.jdk2010.base.security.securityorganization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
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
            String leftStr = "&nbsp;&nbsp;&nbsp;&nbsp;";
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
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        ISecurityOrganizationService securityOrganizationService = (ISecurityOrganizationService) factory
                .getBean("securityOrganizationService");
        List<Map<String, Object>> list = securityOrganizationService.getOrganizationListByParentId("0");
        for (Map<String, Object> map : list) {
            System.out.println(map.get("name"));
        }
    }

    @Override
    public List<Map<String, Object>> getOrganizationList() throws Exception {
        List<Map<String, Object>> organizationList = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        SecurityUser securityUser = (SecurityUser) request.getSession().getAttribute("securityUser");
        String username = securityUser.getUsername();
        if ("system".equals(username)) {
            organizationList = getOrganizationListByParentId("0");
        } else {
            String pid=request.getSession().getAttribute("securityUserSwjgId")+"";
            organizationList = getOrganizationListByParentId(pid);
            Map<String, Object> pidMap = dalClient.queryForObject("SELECT * FROM security_organization  WHERE id="
                    + pid + "" + "  ");
            if (pidMap != null) {
                for (Map<String, Object> map : organizationList) {
                    map.put("name", "&nbsp;&nbsp;&nbsp;&nbsp;" + map.get("name"));
                }
                Map childmap = new HashMap();
                childmap.put("id", pidMap.get("id"));
                childmap.put("name", pidMap.get("name"));
                childmap.put("code", pidMap.get("code"));
                childmap.put("description",pidMap.get("description"));
                childmap.put("parent_id", pidMap.get("parent_id"));
                childmap.put("orderlist", pidMap.get("orderlist"));
                organizationList.add(0, childmap);

            }
        }

        return organizationList;
    }
}

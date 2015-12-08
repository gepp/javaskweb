package com.jdk2010.base.security.menu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jdk2010.base.security.menu.service.ISecurityMenuService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityMenuService")
public class SecurityMenuServiceImpl extends BaseServiceImpl implements ISecurityMenuService {

    @Resource
    DalClient dalClient;

    @Override
    public List<Map<String, Object>> getMenuByParentId(String pid)  {
        DbKit dbKit = new DbKit("select * from security_menu  where parent_id='" + pid + "' order by orderlist asc");
        List<Map<String, Object>> categoryList = dalClient.queryForObjectList(dbKit);

        return categoryList;
    }

    @Override
    public List<Map<String, Object>> getMenuListByParentId(String pid)  {
        List returnList = new ArrayList<Map<String, Object>>();
        List menuList = getMenuByParentId(pid);
        for (int i = 0; i < menuList.size(); i++) {
            Map map = (HashMap<String, Object>) menuList.get(i);
            returnList.add(map);
            int k = 0;
            String leftStr = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
            for (int m = 0; m < k; m++) {
                leftStr = leftStr + leftStr;
            }
            // String span="<span style=\"margin-left:"+leftStr+"px;\"></span>";
            if (getMenuByParentId(map.get("id") + "").size() > 0) {
                k = k + 1;
                List returnListChild = getMenuListByParentId(map.get("id") + "");
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

 
}

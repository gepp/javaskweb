package com.jdk2010.base.security.securityuser.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jdk2010.base.security.menu.service.ISecurityMenuService;
import com.jdk2010.base.security.securityrolemenu.model.SecurityRoleMenu;
import com.jdk2010.base.security.securityrolemenu.service.ISecurityRoleMenuService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.base.security.securityuser.service.ISecurityUserService;
import com.jdk2010.base.security.securityuserrole.model.SecurityUserRole;
import com.jdk2010.base.security.securityuserrole.service.ISecurityUserRoleService;
import com.jdk2010.base.service.BaseServiceImpl;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;

@Service("securityUserService")
public class SecurityUserServiceImpl extends BaseServiceImpl implements ISecurityUserService {
    @Resource
    DalClient dalClient;

    @Resource
    ISecurityUserRoleService securityUserRoleService;

    @Resource
    ISecurityMenuService securityMenuService;

    @Resource
    ISecurityRoleMenuService securityRoleMenuService;

    @Override
    public SecurityUser login(String username, String password) throws Exception {
        DbKit dbKit = new DbKit("select * from security_user where username=:username and userpwd=:password");
        dbKit.put("username", username);
        dbKit.put("password", password);
        SecurityUser user = dalClient.queryForObject(dbKit, SecurityUser.class);
        if (user == null) {
            return null;
        } else {
            return user;
        }

    }

    @Override
    public boolean isExistUsername(String username) {
        String sql = "select * from security_user where username='" + username + "'";
        List<Map<String, Object>> roleList = dalClient.queryForObjectList(sql);
        if (roleList.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Map<Object, Object> getUserMenuByUserId(Integer userId) {
        // 组装菜单
        Map<Object, Object> returnMenuMap = new LinkedHashMap<Object, Object>();
        List<SecurityUserRole> userRoleList = securityUserRoleService.getSecurityUserRoleByUserId(userId);
        List<Map<String, Object>> firstMenuList = securityMenuService.getMenuByParentId("0");
        Map<String, Object> userMenuMap = new HashMap<String, Object>();
        for (SecurityUserRole userRole : userRoleList) {
            List<SecurityRoleMenu> roleMenuList = securityRoleMenuService.getSecurityRoleMenuByRoleId(userRole.getId());
            for (SecurityRoleMenu roleMenu : roleMenuList) {
                userMenuMap.put(roleMenu.getMenuId() + "", roleMenu.getMenuId());
            }
        }

        Iterator<Map<String, Object>> iterator = firstMenuList.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> firstMenu = iterator.next();
            String firstId = firstMenu.get("id") + "";
            if (userMenuMap.containsKey(firstId)) {
                List<Map<String, Object>> keyValue = new ArrayList<Map<String, Object>>();
                List<Map<String, Object>> secondMenuList = securityMenuService.getMenuByParentId(firstId + "");
                for (Map<String, Object> secondMenu : secondMenuList) {
                    String secondId = secondMenu.get("id") + "";
                    if (userMenuMap.containsKey(secondId)) {
                        keyValue.add(secondMenu);
                    }
                }
                userMenuMap.remove(firstId);
                returnMenuMap.put(firstMenu, keyValue);

            }
        }
        return returnMenuMap;
    }

    @Override
    public Map<Object, Object> getAllMenu() {
        // 组装菜单
        Map<Object, Object> returnMenuMap = new LinkedHashMap<Object, Object>();
        List<Map<String, Object>> firstMenuList = securityMenuService.getMenuByParentId("0");

        Iterator<Map<String, Object>> iterator = firstMenuList.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> firstMenu = iterator.next();
            String firstId = firstMenu.get("id") + "";
            List<Map<String, Object>> keyValue = new ArrayList<Map<String, Object>>();
            List<Map<String, Object>> secondMenuList = securityMenuService.getMenuByParentId(firstId + "");
            for (Map<String, Object> secondMenu : secondMenuList) {
                String secondId = secondMenu.get("id") + "";
                keyValue.add(secondMenu);
            }
            returnMenuMap.put(firstMenu, keyValue);
        }
        return returnMenuMap;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        ISecurityUserService securityUserService = factory.getBean(ISecurityUserService.class);
        Map<Object, Object> userMenuMap = securityUserService.getAllMenu();
        for (Object key : userMenuMap.keySet()) {
            System.out.println("key:" + key);
            List<Map<String, Object>> keyValue = (List<Map<String, Object>>) userMenuMap.get(key);
            for (Map<String, Object> map : keyValue) {
                System.out.println(map.get("name"));
            }
        }
    }

    @Override
    public Map<Object, Object> getUserMenu(SecurityUser user) {
        if (user.getUsername().equals("system")) {
            return getAllMenu();
        } else {
            return getUserMenuByUserId(user.getId());
        }
    }

}

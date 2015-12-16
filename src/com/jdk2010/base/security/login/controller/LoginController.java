package com.jdk2010.base.security.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.menu.service.ISecurityMenuService;
import com.jdk2010.base.security.securityorganization.model.SecurityOrganization;
import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.security.securityrolemenu.service.ISecurityRoleMenuService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.base.security.securityuser.service.ISecurityUserService;
import com.jdk2010.base.security.securityuserrole.service.ISecurityUserRoleService;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.CookieUtil;
import com.jdk2010.framework.util.MD5Utils;

@Controller
@RequestMapping(value = "/")
public class LoginController extends BaseController {

    @Resource
    ISecurityUserService securityUserService;

    @Resource
    ISecurityMenuService securityMenuService;
    
    @Resource
    ISecurityUserRoleService securityUserRoleService;
    
    @Resource
    ISecurityRoleMenuService securityRoleMenuService;
    
    @Resource
    ISecurityOrganizationService securityOrganizationService;

    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @RequestMapping("/login")
    public String in(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = CookieUtil.getCookieValue(request, response, "username");
        String md5Password = CookieUtil.getCookieValue(request, response, "md5Password");
        if (!"".equals(username) && !"".equals(md5Password)) {
            request.setAttribute("username", username);
            request.setAttribute("md5Password", md5Password);
            return FORWARD + "autoLogin.htm";
        } else {
            return "/login";
        }

    }

    @RequestMapping("/doLogin")
    public void inAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getPara("username");
        String password = getPara("password");
        String rememberMe = getPara("rememberMe");
        String md5Password = MD5Utils.md5(password);
        SecurityUser securityUser = securityUserService.login(username, md5Password);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String flag = "T";
        String reason = "";
        if (securityUser == null) {
            flag = "F";
            reason = "用户名密码错误";

        } else {
            if ("true".equals(rememberMe)) {
                CookieUtil.addCookie(request, response, "username", username,60*60*24*7);
                CookieUtil.addCookie(request, response, "md5Password", md5Password,60*60*24*7);
            }
            setSessionAttr("securityUser", securityUser);
             
        }
        resultMap.put("flag", flag);
        resultMap.put("reason", reason);
        renderJson(resultMap);
    }

    @RequestMapping("/autoLogin")
    public String autoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = getAttrForStr("username");
        String md5Password = getAttrForStr("md5Password");
        SecurityUser securityUser = securityUserService.login(username, md5Password);
        if (securityUser == null) {
            //CookieUtil.deleteCookie(request, response, "username");
            //CookieUtil.deleteCookie(request, response, "md5Password");
            return "/login";
        } else {
            setSessionAttr("securityUser", securityUser);
           
           
            return REDIRECT + "main.htm";
        }

    }

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/main";
    }
    
    @RequestMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/main";
    }

    @RequestMapping("/loginout")
    public String out(HttpServletRequest request, HttpServletResponse response) throws Exception {
        removeSessionAttr("securityUser");
        removeSessionAttr("menuStr");
        CookieUtil.deleteCookie(request, response, "username");
        CookieUtil.deleteCookie(request, response, "md5Password");
        return REDIRECT+"/login.htm";
    }

    @RequestMapping("/top")
    public String top(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/top";
    }

    @RequestMapping("/left")
    public String left(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	SecurityUser securityUser=getSessionAttr("securityUser");
    	//组装菜单
        String menuStr="";
        String contextpath=request.getContextPath();
        Map<Object, Object>  userMenuMap=securityUserService.getUserMenu(securityUser);
        for(Object obj:userMenuMap.keySet()){
            Map<String,Object> parentMap=(Map<String,Object>)obj;
            menuStr=menuStr+"<dd><div class=\"title\"><span><img src=\""+contextpath+parentMap.get("img")+"\" /></span>"+parentMap.get("name")+"</div><ul class=\"menuson\">";
            List<Map<String, Object>> list=(List<Map<String, Object>>)userMenuMap.get(obj);
            for(int i=0;i<list.size();i++){
                Map<String,Object> secondMap=(Map<String,Object>)list.get(i);
                menuStr=menuStr+"<li><cite></cite><a href=\""+contextpath+""+secondMap.get("url")+"\" target=\"rightFrame\">"+secondMap.get("name")+"</a><i></i></li>";
            }
            menuStr=menuStr+"</ul></dd>";
        }
        setSessionAttr("userMenuMap", userMenuMap);
        setSessionAttr("menuStr", menuStr);
        return "/left";
    }

    @RequestMapping("/defaultMain")
    public String defaultMain(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/defaultMain";
    }

    @RequestMapping("/footer")
    public String footer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/footer";
    }
    
    @RequestMapping("/tech")
    public String tech(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/tech";
    }

}

package com.jdk2010.base.security.menu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.menu.model.SecurityMenu;
import com.jdk2010.base.security.menu.service.ISecurityMenuService;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.tools.Constants;

@Controller
@RequestMapping(value = "/securitymenu")
public class SecurityMenuController extends BaseController {

    @Resource
    ISecurityMenuService securityMenuService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> menuList = securityMenuService.getMenuListByParentId("0");
        setAttr("menuList", menuList);

        // Page pageList = securityMenuService.queryForPageList("select * from security_menu", getPage());
        // setAttr("pageList", pageList);
        return "/com/jdk2010/base/security/menu/menu";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/com/jdk2010/base/security/menu/menu_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SecurityMenu securityMenu = getModel(SecurityMenu.class);
        securityMenuService.save(securityMenu);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SecurityMenu securityMenu = securityMenuService.findById(id, SecurityMenu.class);
        setAttr("securityMenu", securityMenu);
        return "/com/jdk2010/base/security/menu/menu_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SecurityMenu securityMenu = getModel(SecurityMenu.class);
        securityMenuService.update(securityMenu);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        securityMenuService.deleteByIDS(ids, SecurityMenu.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SecurityMenu securityMenu = securityMenuService.findById(id, SecurityMenu.class);
        setAttr("securityMenu", securityMenu);
        return "/com/jdk2010/base/security/menu/menu_view";
    }

    @RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> menuList = securityMenuService.getMenuListByParentId("0");
        setAttr("menuList", menuList);
        String menuIds = getPara("menuIds");
        if (menuIds != null) {
            setAttr("menuIds", menuIds);
        }
        return "/com/jdk2010/base/security/menu/select";
    }

}

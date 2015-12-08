package com.jdk2010.base.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;

@Controller
@RequestMapping(value = "/")
public class TestController extends BaseController {

    @Resource
    DalClient dalClient;

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> menuList = dalClient.queryForObjectList("select * from security_user_role");
        renderJson(menuList);
    }

}

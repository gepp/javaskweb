package com.jdk2010.register.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;

@Controller
@RequestMapping(value = "/taxpayer")
public class TaxpayerController extends BaseController {

    @Resource
    DalClient dalClient;

    @Resource
    ISkqNsrxxService skqNsrxxService;

    @RequestMapping("/toImport")
    public String toImport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/register/nsrmcgx.dk";
    }

    @RequestMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        HashMap CARDINFO = (HashMap) session.getAttribute("FCARDINFO");
        if (CARDINFO == null || CARDINFO.isEmpty()) {
            request.setAttribute("errorMsg", "基础信息读取失败！");
            return "/cxtj/error";
        } else {
            HashMap EF02 = (HashMap) CARDINFO.get("EF02");
            String nsrwjbm = ((String) EF02.get("NSRWJDM"));
            SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
            request.setAttribute("nsrmc", nsrxx.getNsrmc().trim());
            request.setAttribute("CARDINFO", CARDINFO);
            setAttr("EF02", EF02);
            return "/register/nsrmcgx.dk.show";
        }

    }

}

package com.jdk2010.jqxx.skqjqxx.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.system.skqjqxh.model.SkqJqxh;
import com.jdk2010.system.skqjqxh.service.ISkqJqxhService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;

@Controller
@RequestMapping(value = "/skqjqxx")
public class SkqJqxxController extends BaseController {

    @Resource
    ISkqJqxxService skqJqxxService;

    @Resource
    ISkqJqxhService skqJqxhService;
    
    @Resource
    ISkqNsrxxService skqNsrxxService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        List<SkqJqxx> jqxxList = skqJqxxService.getJqxxListByNsrwjbm(nsrwjbm);
        setAttr("nsrwjbm",nsrwjbm);
        setAttr("list", jqxxList);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        setAttr("nsrwjbm", nsrwjbm);

        List<SkqJqxh> jqxhList = skqJqxhService.queryForList("select * from skq_jqxh", SkqJqxh.class);
        setAttr("jqxhList", jqxhList);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqJqxx skqJqxx = getModel(SkqJqxx.class);
        skqJqxxService.save(skqJqxx);

        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqJqxx skqJqxx = skqJqxxService.findById(id, SkqJqxx.class);
        setAttr("skqJqxx", skqJqxx);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqJqxx skqJqxx = getModel(SkqJqxx.class);
        skqJqxxService.update(skqJqxx);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqJqxxService.deleteByIDS(ids, SkqJqxx.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqJqxx skqJqxx = skqJqxxService.findById(id, SkqJqxx.class);
        setAttr("skqJqxx", skqJqxx);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_view";
    }
    
    @RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm=getPara("nsrwjbm");
        SkqNsrxx nsrxx=skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        List<SkqNsrszsm> list = nsrxx.getNsrszsmList();
        setAttr("list", list);
        String smbms=getPara("smbms");
        setAttr("smbms", smbms);
        return "/com/jdk2010/jqxx/skqjqxx/select";
    }

}

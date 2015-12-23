package com.jdk2010.system.skqhy.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.system.skqhy.model.SkqHy;
import com.jdk2010.system.skqhy.service.ISkqHyService;
import com.jdk2010.tools.Constants;
@Controller
@RequestMapping(value="/skqhy")
public class SkqHyController extends BaseController{

    @Resource
    ISkqHyService skqHyService;

    @RequestMapping("/list")
    public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
        DbKit dbKit=new DbKit("select * from skq_hy  where 1=1 ");
        String searchSQL="";
        String orderSQL="";
        dbKit.append(orderSQL);
        Page pageList=skqHyService.queryForPageList(dbKit, getPage(),SkqHy.class);
        setAttr("pageList", pageList);
        return "/com/jdk2010/system/skqhy/skqhy";
    }

    @RequestMapping("/add")
    public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
        return "/com/jdk2010/system/skqhy/skqhy_add";
    }
    @RequestMapping("/addaction")
    public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
        SkqHy skqHy=getModel(SkqHy.class);
        skqHyService.save(skqHy);
        ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
        renderJson(response,returnData);
    }


    @RequestMapping("/modify")
    public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String id=getPara("id");
        SkqHy skqHy=skqHyService.findById(id, SkqHy.class);
        setAttr("skqHy", skqHy);
        return "/com/jdk2010/system/skqhy/skqhy_modify";
    }
    @RequestMapping("/modifyaction")
    public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
        SkqHy skqHy=getModel(SkqHy.class);
        skqHyService.update(skqHy);
        ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/delete")
    public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String ids=getPara("ids");
        skqHyService.deleteByIDS(ids,SkqHy.class);
        ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/view")
    public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String id=getPara("id");
        SkqHy skqHy=skqHyService.findById(id, SkqHy.class);
        setAttr("skqHy", skqHy);
        return "/com/jdk2010/system/skqhy/skqhy_view";
    }
    
    @RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> list = skqHyService.queryForList("select * from skq_hy where status=1");
        setAttr("list", list);
        return "/com/jdk2010/system/skqhy/select";
    }


}

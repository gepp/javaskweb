package com.jdk2010.system.skqhymx.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.system.skqhy.model.SkqHy;
import com.jdk2010.system.skqhy.service.ISkqHyService;
import com.jdk2010.system.skqhymx.model.SkqHymx;
import com.jdk2010.system.skqhymx.service.ISkqHymxService;

@Controller
@RequestMapping(value = "/skqhymx")
public class SkqHymxController extends BaseController {

    @Resource
    ISkqHymxService skqHymxService;
    
    @Resource
    ISkqHyService skqHyService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer hyId=getParaToInt("hyId");
        SkqHy skqHy=skqHyService.findById(hyId, SkqHy.class);
        setAttr("skqHy", skqHy);
        DbKit dbKit = new DbKit("select * from skq_hymx  where  hyid='"+hyId+"' ");
        List<Map<String,Object>> mapList=skqHymxService.queryForList(dbKit);
        setAttr("mapList", mapList);
        return "/com/jdk2010/system/skqhymx/skqhymx";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String hyId=getPara("hyId");
        setAttr("hyId", hyId);
        return "/com/jdk2010/system/skqhymx/skqhymx_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer hyId=getParaToInt("hyId");
        SkqHy skqHy=skqHyService.findById(hyId, SkqHy.class);
        SkqHymx skqHymx = getModel(SkqHymx.class);
        skqHymx.setHyid(hyId);
        skqHymx.setHybm(skqHy.getHybm());
        skqHymxService.save(skqHymx);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqHymx skqHymx = skqHymxService.findById(id, SkqHymx.class);
        setAttr("skqHymx", skqHymx);
        return "/com/jdk2010/system/skqhymx/skqhymx_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqHymx skqHymx = getModel(SkqHymx.class);
        skqHymxService.update(skqHymx);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqHymxService.deleteByIDS(ids, SkqHymx.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    

}

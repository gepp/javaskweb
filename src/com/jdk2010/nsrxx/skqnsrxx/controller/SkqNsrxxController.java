package com.jdk2010.nsrxx.skqnsrxx.controller;

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
import com.jdk2010.framework.util.JsonUtil;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;

@Controller
@RequestMapping(value = "/skqnsrxx")
public class SkqNsrxxController extends BaseController {

    @Resource
    ISkqNsrxxService skqNsrxxService;

    @Resource
    ISkqNsrszsmService skqNsrszsmService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "select * from skq_nsrxx  where 1=1 ";
        DbKit dbKit = new DbKit(sql);
        String searchSQL = "";
        String orderSQL = "";
        String NSRWJBM = getPara("NSRWJBM");
        if (NSRWJBM != null && !"".equals(NSRWJBM)) {
            searchSQL = searchSQL + " and  NSRWJBM LIKE '%" + NSRWJBM + "%'";
            setAttr("NSRWJBM", NSRWJBM);
            // dbKit.append(searchSQL);
        }

        String NSRSBH = getPara("NSRSBH");
        if (NSRSBH != null && !"".equals(NSRSBH)) {
            searchSQL = searchSQL + " and  NSRSBH LIKE '%" + NSRSBH + "%'";
            setAttr("NSRSBH", NSRSBH);
            // dbKit.append(searchSQL);
        }

        String NSRMC = getPara("NSRMC");
        if (NSRMC != null && !"".equals(NSRMC)) {
            searchSQL = searchSQL + " and  NSRMC LIKE '%" + NSRMC + "%'";
            setAttr("NSRMC", NSRMC);
        }

        String SWJGBM = getPara("SWJGBM");
        if (SWJGBM != null && !"".equals(SWJGBM)) {
            searchSQL = searchSQL + " and  SWJGBM ='" + SWJGBM + "'";
            setAttr("SWJGBM", SWJGBM);
            setAttr("parentName", getPara("parentName"));
        }

        dbKit.append(orderSQL);
        dbKit.append(searchSQL);
        Page pageList = skqNsrxxService.queryForPageList(dbKit, getPage(), SkqNsrxx.class);
        setAttr("pageList", pageList);
        return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqNsrxx skqNsrxx = getModel(SkqNsrxx.class);
        skqNsrxxService.save(skqNsrxx);
        String hiddenStr = getPara("hiddenStr");
        for (int i = 0; i < hiddenStr.split("~").length; i++) {
            String jsonStr = hiddenStr.split("~")[i];
            if (StringUtil.isNotBlank(jsonStr)) {
                Map<String, Object> nsrszsmMap = JsonUtil.jsonToMap(jsonStr);
                SkqNsrszsm nsrszsm = new SkqNsrszsm();
                nsrszsm.setNsrwjbm(skqNsrxx.getNsrwjbm());
                nsrszsm.setSl(Double.parseDouble("" + nsrszsmMap.get("sl")));
                nsrszsm.setSmbm("" + nsrszsmMap.get("sl"));
                nsrszsm.setSmjc("" + nsrszsmMap.get("smjc"));
                nsrszsm.setSmmc("" + nsrszsmMap.get("smmc"));
                nsrszsm.setStatus(1);
                nsrszsm.setSzbm("" + nsrszsmMap.get("szbm"));
                skqNsrszsmService.save(nsrszsm);
            }
        }
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        List<SkqNsrszsm> nsrszsmList = skqNsrxx.getNsrszsmList();
        setAttr("nsrszsmList", nsrszsmList);
        String hiddenStr="";
        String smbms=",";
        for(int i=0;i<nsrszsmList.size();i++){
            hiddenStr=hiddenStr+"~"+JsonUtil.toJson(nsrszsmList.get(i));
            smbms=smbms+nsrszsmList.get(i).getSmbm()+",";
        }
        setAttr("hiddenStr", hiddenStr);
        setAttr("smbms", smbms);
        
        setAttr("skqNsrxx", skqNsrxx);
        return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqNsrxx skqNsrxx = getModel(SkqNsrxx.class);
        skqNsrxxService.update(skqNsrxx);
        skqNsrszsmService.deleteNsrszsmByNsrwjbm(skqNsrxx.getNsrwjbm());
        String hiddenStr = getPara("hiddenStr");
        for (int i = 0; i < hiddenStr.split("~").length; i++) {
            String jsonStr = hiddenStr.split("~")[i];
            if (StringUtil.isNotBlank(jsonStr)) {
                Map<String, Object> nsrszsmMap = JsonUtil.jsonToMap(jsonStr);
                SkqNsrszsm nsrszsm = new SkqNsrszsm();
                nsrszsm.setNsrwjbm(skqNsrxx.getNsrwjbm());
                nsrszsm.setSl(Double.parseDouble("" + nsrszsmMap.get("sl")));
                nsrszsm.setSmbm("" + nsrszsmMap.get("sl"));
                nsrszsm.setSmjc("" + nsrszsmMap.get("smjc"));
                nsrszsm.setSmmc("" + nsrszsmMap.get("smmc"));
                nsrszsm.setStatus(1);
                nsrszsm.setSzbm("" + nsrszsmMap.get("szbm"));
                skqNsrszsmService.save(nsrszsm);
            }
        }
        
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqNsrxxService.deleteByIDS(ids, SkqNsrxx.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqNsrxx skqNsrxx = skqNsrxxService.findById(id, SkqNsrxx.class);
        setAttr("skqNsrxx", skqNsrxx);
        return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_view";
    }

}

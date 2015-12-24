package com.jdk2010.cxtj.controller;

import java.util.HashMap;
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
@RequestMapping(value = "/cxtj")
public class CxtjController extends BaseController {

    @Resource
    DalClient dalClient;

    @RequestMapping("/toYhkImport")
    public String toYhkImport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/cxtj/cx.yhk";
    }

    @RequestMapping("/toYhkInfo")
    public String toYhkInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap UCARDINFO = (HashMap) request.getSession().getAttribute("UCARDINFO");
        if (UCARDINFO == null || UCARDINFO.isEmpty()) {
            request.setAttribute("errorMsg", "基础信息读取失败！");
            return "/cxtj/error";
        } else {
            request.setAttribute("CARDINFO", UCARDINFO);
            return "/cxtj/cx.yhk.show";
        }
    }

    @RequestMapping("/toSkkImport")
    public String toSkkImport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/cxtj/cx.skk";
    }

    @RequestMapping("/toSkkInfo")
    public String toSkkInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap CARDINFO = (HashMap) request.getSession().getAttribute("FCARDINFO");
        System.out.println("CARDINFO==" + CARDINFO);
        String yhswjgbmStr = (String) request.getSession().getAttribute("yhswjgbmStr");
        // System.out.println("CARDINFO==="+CARDINFO);
        if (CARDINFO == null || CARDINFO.isEmpty()) {
            request.setAttribute("errorMsg", "基础信息读取失败！");
            return "/cxtj/error";
        } else {
            request.setAttribute("CARDINFO", CARDINFO);
            return "/cxtj/cx.skk.show";
        }
    }

    @RequestMapping("/toSkkFz")
    public String toSkkFz(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/cxtj/skk.fz";
    }

    @RequestMapping("/skkFzInfo")
    public String skkFzInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jqbh = getPara("jqbh");
        String fpdm = getPara("fpdm");
        int fpqsh = getParaToInt("fpqsh");
        int fpjzh = getParaToInt("fpjzh");
        String queryInfo = "select a.NSRWJBM,a.NSRSBH,a.NSRMC,a.SWJGBM,b.SKKH,b.KQYRQ,b.KYXRQ,b.SBFS,b.MXSBBZ,b.KPJZRQ,b.DZKPXE,b.YLJKPXE,b.YLJTPXE from SKQ_NSRXX a,SKQ_JQXX b where b.JQBH='"
                + jqbh + "' and a.NSRWJBM=b.NSRWJBM and a.STATUS=1 and b.STATUS=1";
        Map<String, Object> map = dalClient.queryForObject(queryInfo);
        String querySZ = "select DISTINCT a.SMSY from SKQ_PMSZ a,SKQ_JQSZSM b where b.JQBH=" + jqbh
                + " and b.SMBM=a.SMBM";
        List<Map<String, Object>> szList = dalClient.queryForObjectList(querySZ);
        StringBuffer sb = new StringBuffer();
        for (Map<String, Object> szMap : szList) {
            String sy = szMap.get("smsy") + "";
            if (sy.length() < 2) {
                sy = "0" + sy;
            }
            sb.append(sy);
        }
        if(map!=null&&!map.isEmpty())
        {
            map.put("szsmsy", sb.toString());
            map.put("jqbh", jqbh);
            map.put("fpdm", fpdm);
            map.put("fpqsh", fpqsh);
            map.put("fpjzh", fpjzh);
            setAttr("SKK", map);
            setAttr("showFlag","F");
        }else{
            setAttr("showFlag","T");
        }
         
        return "/cxtj/skk.fz";
    }

}

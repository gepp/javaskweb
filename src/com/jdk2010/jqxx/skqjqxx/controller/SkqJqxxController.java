package com.jdk2010.jqxx.skqjqxx.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqszsm.service.ISkqJqszsmService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.system.skqjqxh.model.SkqJqxh;
import com.jdk2010.system.skqjqxh.service.ISkqJqxhService;
import com.jdk2010.tools.Constants;
import com.jdk2010.tools.Util;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.JsonUtil;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.StringUtil;

@Controller
@RequestMapping(value = "/skqjqxx")
public class SkqJqxxController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    ISkqJqxxService skqJqxxService;

    @Resource
    ISkqJqxhService skqJqxhService;

    @Resource
    ISkqNsrxxService skqNsrxxService;

    @Resource
    ISkqJqszsmService skqJqszsmService;
    
    @Resource
    DalClient dalClient;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        List<SkqJqxx> jqxxList = skqJqxxService.getJqxxListByNsrwjbm(nsrwjbm);
        setAttr("nsrwjbm", nsrwjbm);
        SkqNsrxx nsrxx=skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        setAttr("nsrsbh", nsrxx.getNsrsbh());
        setAttr("list", jqxxList);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx";
    }

    
    @RequestMapping("/listcxtjImport")
    public String listcxtjImport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxxcxtj";
    }

    
    @RequestMapping("/listcxtj")
    public String listcxtj(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DbKit dbKit = new DbKit(
                "SELECT t.*,a.swjgbm,a.nsrsbh,a.nsrmc FROM skq_jqxx  t inner JOIN skq_nsrxx a ON t.nsrwjbm=a.nsrwjbm inner JOIN security_organization b ON a.swjgbm=b.code  ");
        String searchSQL = "";
        String orderSQL = "";
        String NSRSBH = getPara("NSRSBH");
        if (NSRSBH != null && !"".equals(NSRSBH)) {
        	String nsrwjbm=dalClient.queryColumn("select nsrwjbm from skq_nsrxx where nsrsbh='"+NSRSBH+"'","nsrwjbm");
            searchSQL = searchSQL + " and  t.NSRWJBM ='"+nsrwjbm+"'";
            setAttr("NSRSBH", NSRSBH);
        }

        String JQBH = getPara("JQBH");
        if (JQBH != null && !"".equals(JQBH)) {
            searchSQL = searchSQL + " and  t.JQBH LIKE :jqbh";
            setAttr("JQBH", JQBH);
            dbKit.put("jqbh", JQBH+"%");
        }

        String SKKH = getPara("SKKH");
        if (SKKH != null && !"".equals(SKKH)) {
            searchSQL = searchSQL + " and  t.SKKH LIKE :skkh";
            setAttr("SKKH", SKKH);
            dbKit.put("skkh",SKKH+"%");
        }
        String YHKH = getPara("YHKH");
        if (YHKH != null && !"".equals(YHKH)) {
            searchSQL = searchSQL + " and  t.YHKH LIKE :yhkh";
            setAttr("YHKH", YHKH);
            dbKit.put("yhkh", YHKH+"%");
        }

        String SWJGBM = getPara("SWJGBM");
        if (SWJGBM != null && !"".equals(SWJGBM)) {
            searchSQL = searchSQL + " and   a.swjgbm='" + SWJGBM + "'";
            setAttr("SWJGBM", SWJGBM);
            setAttr("parentName", getPara("parentName"));
        }else{
            SecurityUser securityUser=getSessionAttr("securityUser");
            String username=securityUser.getUsername();
            if(!"system".equals(username)){
                searchSQL = searchSQL + " and  SWJGBM ='" + getSessionAttr("securityUserSwjgbm") + "'";
                setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
                setAttr("parentName", getSessionAttr("securityUserSwjgName"));
            }
        }

        dbKit.append(orderSQL);
        dbKit.append(searchSQL);
        Page pageList = skqJqxxService.queryForPageList(dbKit, getPage(), SkqJqxx.class);
        setAttr("pageList", pageList);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxxcxtj";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        setAttr("nsrwjbm", nsrwjbm);

        List<SkqJqxh> jqxhList = skqJqxhService.queryForList("select * from skq_jqxh", SkqJqxh.class);
        setAttr("jqxhList", jqxhList);
        String today=DateUtil.getNowTime("yyyy-MM-dd");
        String tenToday=Integer.parseInt(today.substring(0,4))+10+today.substring(4);
        setAttr("today", today);
        setAttr("tenToday", tenToday);
        setAttr("kpjzrq",Util.getNextMonthEnd().substring(0,8)+"15");
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqJqxx skqJqxx = getModel(SkqJqxx.class);
        String jqbh = StringUtil.charFront(skqJqxx.getJqbh(), 16, "0");
        String yhkh = StringUtil.charFront(skqJqxx.getYhkh(), 16, "0");
        String skkh = StringUtil.charFront(skqJqxx.getSkkh(), 16, "0");
        skqJqxx.setJqbh(jqbh);
        skqJqxx.setYhkh(yhkh);
        skqJqxx.setSkkh(skkh);
        skqJqxxService.save(skqJqxx);
        String OLD_WJBM=dalClient.queryColumn("select OLD_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and new_wjbm='"+skqJqxx.getNsrwjbm()+"'", "OLD_WJBM");
        dalClient.update("delete from skq_wjbmdy where jqbh='"+jqbh+"'");
        OLD_WJBM="0"+skqJqxx.getNsrwjbm();
    	String updateDygxSql="insert into skq_wjbmdy (JQBH,OLD_WJBM,NEW_WJBM) values('"+jqbh+"','"+OLD_WJBM+"','"+skqJqxx.getNsrwjbm()+"')";
    	dalClient.update(updateDygxSql);
        String hiddenStr = getPara("hiddenStr");
        hiddenStr=hiddenStr.replaceAll("“","\"");
        for (int i = 0; i < hiddenStr.split("~").length; i++) {
            String jsonStr = hiddenStr.split("~")[i];
            if (StringUtil.isNotBlank(jsonStr)) {
                Map<String, Object> jqszsmMap = JsonUtil.jsonToMap(jsonStr);
                SkqJqszsm szsm = new SkqJqszsm();
                szsm.setJqbh(skqJqxx.getJqbh());
                szsm.setSmbm("" + jqszsmMap.get("smbm"));
                skqJqszsmService.save(szsm);
            }
        }
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jqbh = getPara("jqbh");
        SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);

        List<SkqJqxh> jqxhList = skqJqxhService.queryForList("select * from skq_jqxh", SkqJqxh.class);
        setAttr("jqxhList", jqxhList);
        setAttr("skqJqxx", skqJqxx);
        List<SkqJqszsm> jqszsmList = skqJqxx.getJqszsmList();
        setAttr("jqszsmList", jqszsmList);
        String hiddenStr = "";
        String smbms = ",";
        for (int i = 0; i < jqszsmList.size(); i++) {
            hiddenStr = hiddenStr + "~" + JsonUtil.toJson(jqszsmList.get(i));
            smbms = smbms + jqszsmList.get(i).getSmbm() + ",";
        }
        setAttr("hiddenStr", hiddenStr);
        setAttr("smbms", smbms);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqJqxx skqJqxx = getModel(SkqJqxx.class);
        String jqbh = StringUtil.charFront(skqJqxx.getJqbh(), 16, "0");
        String yhkh = StringUtil.charFront(skqJqxx.getYhkh(), 16, "0");
        String skkh = StringUtil.charFront(skqJqxx.getSkkh(), 16, "0");
        skqJqxx.setJqbh(jqbh);
        skqJqxx.setYhkh(yhkh);
        skqJqxx.setSkkh(skkh);
        skqJqxxService.update(skqJqxx);
        skqJqxxService.deleteJqszsmByJqbh(skqJqxx.getJqbh());
        String hiddenStr = getPara("hiddenStr");
        hiddenStr=hiddenStr.replaceAll("“","\"");
        for (int i = 0; i < hiddenStr.split("~").length; i++) {
            String jsonStr = hiddenStr.split("~")[i];
            if (StringUtil.isNotBlank(jsonStr)) {
                Map<String, Object> jqszsmMap = JsonUtil.jsonToMap(jsonStr);
                SkqJqszsm szsm = new SkqJqszsm();
                szsm.setJqbh(skqJqxx.getJqbh());
                szsm.setSmbm("" + jqszsmMap.get("smbm"));
                skqJqszsmService.save(szsm);
            }
        }
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqJqxxService.deleteByIDS(ids, SkqJqxx.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jqbh = getPara("jqbh");
        SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);
        setAttr("jqxx", skqJqxx);
        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_view";
    }

    @RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        List<SkqNsrszsm> list = nsrxx.getNsrszsmList();
        setAttr("list", list);
        String smbms = getPara("smbms");
        setAttr("smbms", smbms);
        return "/com/jdk2010/jqxx/skqjqxx/select";
    }

    @RequestMapping("/checkSkkh")
    public void checkSkkh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String skkh = getPara("skqJqxx.skkh");
        skkh = StringUtil.charFront(skkh, 16, "0");
        boolean isExist = skqJqxxService.isExistsSKKH(skkh);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (isExist) {
            returnMap.put("error", "税控卡号已存在");
        } else {
            returnMap.put("ok", "该税控卡号可以使用");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", returnMap);
        renderJson(response,map);
    }

    @RequestMapping("/checkYhkh")
    public void checkYhkh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String yhkh = getPara("skqJqxx.yhkh");
        yhkh = StringUtil.charFront(yhkh, 16, "0");
        boolean isExist = skqJqxxService.isExistsYHKH(yhkh);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (isExist) {
            returnMap.put("error", "用户卡号已存在");
        } else {
            returnMap.put("ok", "该用户卡号可以使用");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", returnMap);
        renderJson(response,map);
    }

    @RequestMapping("/checkJqbh")
    public void checkJqbh(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jqbh = getPara("skqJqxx.jqbh");
        jqbh = StringUtil.charFront(jqbh, 16, "0");
        boolean isExist = skqJqxxService.isExistsJQBH(jqbh);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (isExist) {
            returnMap.put("error", "机器编号已存在");
        } else {
            returnMap.put("ok", "该机器编号可以使用");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", returnMap);
        renderJson(response,map);
    }

    @RequestMapping("/toFK")
    public String toFK(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String jqbh = getPara("jqbh");
        SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);
        setAttr("jqxx", skqJqxx);
        String nsrwjbm = skqJqxx.getNsrwjbm();
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        setAttr("nsrxx", nsrxx);
        String OLD_WJBM = dalClient.queryColumn("select OLD_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and new_wjbm='"+nsrwjbm+"'", "OLD_WJBM");
        setAttr("OLD_WJBM", OLD_WJBM);
        String smStr = "";
        for (int i = 0; i < skqJqxx.getJqszsmList().size(); i++) {
            SkqJqszsm szsm = skqJqxx.getJqszsmList().get(i);
            Integer smsy = szsm.getSmsy();
            String smsyStr = StringUtil.charFront(smsy.toString(), 2, "0");
            String sm = smsyStr + "," + szsm.getSmbm() + "," + szsm.getSl().intValue() + "," + szsm.getSmjc();
            smStr = smStr + "<input type=\"hidden\" name=\"tax" + i + "\" id=\"tax" + i + "\"  value=\"" + sm + "\" />";
        }
        int length = skqJqxx.getJqszsmList().size();
        if (length < 20) {

            for (int i = 0; i < 20 - length; i++) {
                smStr = smStr + "<input type=\"hidden\" name=\"tax" + (i + length) + "\" id=\"tax" + (i + length)
                        + "\"  value=\"\" />";
            }
        }
        setAttr("smStr", smStr);

        return "/com/jdk2010/jqxx/skqjqxx/skqjqxx.fk";
    }
    
    @RequestMapping("/getWriteFcardSt")
	public void hqmc(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String jqbh = getPara("jqbh");
		// System.out.println("keyword==" + keyword);
		SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);
        String nsrwjbm = skqJqxx.getNsrwjbm();
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        String OLD_WJBM = dalClient.queryColumn("select OLD_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and new_wjbm='"+nsrwjbm+"'", "OLD_WJBM");
        String smStr = "";
        
        String STMU = "C:/Program Files/skskjglxt/";
        String NSRBM = OLD_WJBM;
		String SKKH = skqJqxx.getSkkh();
		String JQBH = skqJqxx.getJqbh();
		String NSRMC = nsrxx.getNsrmc();
		
		String SKKQYSJ = Util.toxkrq(skqJqxx.getKqyrq());
		String SKKYXSJ = Util.toxkrq(skqJqxx.getKyxrq());
		String BSFS = skqJqxx.getSbfs();
		String jzrq = Util.toxkrq(skqJqxx.getKpjzrq());
		
		long DBZGXE = (long)(skqJqxx.getDzkpxe()*100);
		long YLJKPXE = (long)(skqJqxx.getYljkpxe()*100);
		long YLJTPXE = (long)(skqJqxx.getYljtpxe()*100);
		String NSRSBH = nsrxx.getNsrsbh();
		
		
		String smxkArr = "";
		List<SkqJqszsm> jqszsmList = skqJqxx.getJqszsmList();
		if(jqszsmList!=null&&!jqszsmList.isEmpty()){
			Iterator it = jqszsmList.iterator();
			while(it.hasNext()){
				SkqJqszsm szsm = (SkqJqszsm)it.next();
				String smsy 	= String.valueOf(szsm.getSmsy());
				if(smsy.length()<2){
					smsy = "0"+smsy;
				}
				smxkArr = smxkArr+smsy;
			}
		}
		
		String MXSB = skqJqxx.getMxsbbz();
		String SWJG = nsrxx.getSwjgbm();
		if(SWJG.length()>8){
			SWJG=SWJG.substring(3);
		}
		String inputfile = STMU+JQBH+"/SKKXK_"+JQBH+".txt";
		String skkfk = NSRBM+"^"+SKKH+"^"+JQBH+"^"+NSRMC+"^"+SKKQYSJ+"^"+jzrq+"^"+SKKYXSJ+"^"+BSFS+"^"+DBZGXE+"^"+YLJKPXE+"^"+YLJTPXE+"^"+smxkArr+"^"+MXSB+"^"+SWJG+"^"+NSRSBH;
		
        
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		returnData.put("skkfk", skkfk);
		renderJson(response,returnData);
	}

}

package com.jdk2010.jzaz.skqjzaz.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jzaz.skqjzaz.model.SkqJzaz;
import com.jdk2010.jzaz.skqjzaz.service.ISkqJzazService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.tools.Constants;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.StringUtil;
@Controller
@RequestMapping(value="/skqjzaz")
public class SkqJzazController extends BaseController{
	
	@Resource
	ISkqJzazService skqJzazService;
	@Resource
	ISkqNsrxxService skqNsrxxService;
	
	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_init";
	}
	
	@RequestMapping("/hqmc")
	public void hqmc(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String keyword = getPara("keyword").trim();
		// System.out.println("keyword==" + keyword);
		List<Map<String, Object>> list = skqJzazService
				.queryForList("select NSRSBH,NSRMC from skq_nsrxx where NSRSBH like '%"
						+ keyword + "%'");

		String str = "";
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Map<String, Object> hm = (Map<String, Object>) it.next();
			str = str + "<div onselect=\"this.text.value = '"
					+ (String) hm.get("nsrsbh") + "'\"><b>"
					+ (String) hm.get("nsrmc") + "</b></div>";
		}
		//System.out.println("str=============="+str);
		renderText(response,str);
	}
	
	@RequestMapping("/checkNsrsbh")
	public void checkNsrsbh(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nsrsbh = getPara("nsrsbh");
		String nsrwjbm = skqNsrxxService.getNsrwjbmByNsrsbh(nsrsbh);
		if(nsrwjbm==null||"".equals(nsrwjbm)){
			ReturnData returnData = new ReturnData(Constants.ERROR, "查询失败");
			renderJson(response,returnData);
		}
		else{
			ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
			returnData.put("nsrwjbm", nsrwjbm);
			renderJson(response,returnData);
		}		
	}
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		String xmmc = getPara("xmmc");
		String sqlStr = "";
		if(!StringUtil.isBlank(xmmc)){
			sqlStr = " and xmmc like '%"+xmmc+"%'";
		}
		
		List<Map<String, Object>> list = skqJzazService.queryForList("select * from SKQ_JZAZ where YFWJBM='"+ nsrwjbm + "'" + sqlStr + "  order by CJSJ desc");

		setAttr("list", list);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("xmmc", xmmc);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		long dqlsh = skqJzazService.getJzazLsh()+1;
		String lsh = String.valueOf(dqlsh);
		for(int i=lsh.length();i<4;i++){
			lsh = "0"+lsh;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowtime = sdf.format(new Date());
		String xmdm = "F"+nowtime+lsh;
		
		
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("xmdm", xmdm);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
 		SecurityUser user = getSessionAttr("securityUser");
 		String nsrwjbm = getPara("nsrwjbm");
 		SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
 		String nsrmc = skqNsrxx.getNsrmc();
 		
 		skqJzaz.setYfwjbm(nsrwjbm);
 		skqJzaz.setYfmc(nsrmc);
 		skqJzaz.setZgswjg(user.getOrganizationCode());
 		skqJzaz.setCjz(user.getUsername());
 		skqJzaz.setCjsj(new Date());
 		
  		skqJzazService.save(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzaz skqJzaz=skqJzazService.findById(id, SkqJzaz.class);
		
		setAttr("skqJzaz", skqJzaz);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
 		String nsrwjbm = getPara("nsrwjbm");
 		//获取开票金额
		double kpje = skqJzazService.getJzazKpje(String.valueOf(skqJzaz.getId()));
		double gck = skqJzaz.getGck();
		double ykje = skqJzaz.getYkje();
		
		double ce = gck-ykje-kpje;
		if(ce>0){
			skqJzaz.setXmzt(0);
		}
		else{
			skqJzaz.setXmzt(1);
		}
		SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
 		String nsrmc = skqNsrxx.getNsrmc();
 		skqJzaz.setYfmc(nsrmc);
 		
 		
  		skqJzazService.update(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJzazService.deleteByIDS(ids,SkqJzaz.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzaz skqJzaz=skqJzazService.findById(id, SkqJzaz.class);
					 setAttr("skqJzaz", skqJzaz);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_view";
	}
	
	
	@RequestMapping("/fblist")
	public String  fbList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		String xmmc = getPara("xmmc");
		String parentid = getPara("parentid");
		String sqlStr = "";
		if(!StringUtil.isBlank(xmmc)){
			sqlStr = " and xmmc like '%"+xmmc+"%'";
		}
		
		List<Map<String, Object>> list = skqJzazService.queryForList("select * from SKQ_JZAZ where PARENTID='"+ parentid + "'" + sqlStr + "  order by CJSJ desc");

		setAttr("list", list);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("xmmc", xmmc);
		setAttr("parentid", parentid);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_fb";
	}
	
	@RequestMapping("/fbadd")
	public String  fbadd(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		String parentid = getPara("parentid");
		
		SkqJzaz skqJzazZb=skqJzazService.findById(parentid, SkqJzaz.class);
		
		long dqlsh = skqJzazService.getJzazFbLsh(parentid)+1;
		String lsh = String.valueOf(dqlsh);
		for(int i=lsh.length();i<4;i++){
			lsh = "0"+lsh;
		}
		String xmdm = skqJzazZb.getXmdm()+"-"+lsh;
		
		//剩余开票金额
		double syje = skqJzazService.getJzazSyje("",parentid,skqJzazZb.getGck());
		
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("xmdm", xmdm);
		setAttr("parentid", parentid);
		setAttr("syje", syje);
		setAttr("skqJzazZb", skqJzazZb);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_fb_add";
	}
	@RequestMapping("/fbaddaction")
	public void  fbaddaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
 		SecurityUser user = getSessionAttr("securityUser");
 		String parentXmmc = getPara("parentXmmc");
 		String xmmc = parentXmmc+"-"+skqJzaz.getXmmc();
 		
 		skqJzaz.setXmmc(xmmc);
 		skqJzaz.setZgswjg(user.getOrganizationCode());
 		skqJzaz.setCjz(user.getUsername());
 		skqJzaz.setCjsj(new Date());
 		
  		skqJzazService.save(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/fbmodify")
	public String  fbmodify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		String nsrwjbm = getPara("nsrwjbm");
		SkqJzaz skqJzaz=skqJzazService.findById(id, SkqJzaz.class);
		String parentid = String.valueOf(skqJzaz.getParentid());
		SkqJzaz skqJzazZb=skqJzazService.findById(parentid, SkqJzaz.class);
		
		String xmmc = skqJzaz.getXmmc();
		String[] xmmcArr = xmmc.split("-");
		String parentXmmc = "";
		for(int i=0;i<(xmmcArr.length-1);i++){
			if("".equals(parentXmmc)){
				parentXmmc = xmmcArr[i];
			}
			else{
				parentXmmc = parentXmmc+"-"+xmmcArr[i];
			}
		}
		xmmc = xmmcArr[xmmcArr.length-1];
		skqJzaz.setXmmc(xmmc);
		
		double syje = skqJzazService.getJzazSyje(id,parentid,skqJzazZb.getGck());
		
		setAttr("skqJzaz", skqJzaz);
		setAttr("parentXmmc", parentXmmc);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("syje", syje);
		setAttr("skqJzazZb", skqJzazZb);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_fb_modify";
	}
	@RequestMapping("/fbmodifyaction")
	public void  fbmodifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
 		String nsrwjbm = getPara("nsrwjbm");
 		String parentXmmc = getPara("parentXmmc");
 		String xmmc = parentXmmc+"-"+skqJzaz.getXmmc();
 		skqJzaz.setXmmc(xmmc);
 		//获取开票金额
		double kpje = skqJzazService.getJzazKpje(String.valueOf(skqJzaz.getId()));
		double gck = skqJzaz.getGck();
		double ykje = skqJzaz.getYkje();
		
		double ce = gck-ykje-kpje;
		if(ce>0){
			skqJzaz.setXmzt(0);
		}
		else{
			skqJzaz.setXmzt(1);
		}
 		
  		skqJzazService.update(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
}

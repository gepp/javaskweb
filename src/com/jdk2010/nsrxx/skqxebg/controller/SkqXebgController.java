package com.jdk2010.nsrxx.skqxebg.controller;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.nsrxx.skqxebg.model.SkqXebg;
import com.jdk2010.nsrxx.skqxebg.service.ISkqXebgService;
import com.jdk2010.tools.Constants;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqxebg")
public class SkqXebgController extends BaseController{
	
	@Resource
	ISkqXebgService skqXebgService;
	@Resource
	ISkqNsrxxService skqNsrxxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		SecurityUser user = getSessionAttr("securityUser");
		String username = user.getUsername();
		String sqlStr = "";
		String swjgbm = user.getOrganizationCode();
		if(!"system".equals(username)){
			sqlStr = " and a.NSRWJBM in(select NSRWJBM from SKQ_NSRXX where STATUS=1 and SWJGBM ='"+swjgbm+"')";
		}
		String sql = "select a.*,b.NSRMC,b.NSRSBH from SKQ_XEBG a left outer join SKQ_NSRXX b on a.NSRWJBM=b.NSRWJBM where (CLBZ=0 or CLBZ is null) "+sqlStr+" order by a.CLBZ asc,a.SQSJ desc";
		
		List<Map<String, Object>> list = skqXebgService.queryForList(sql);
 
		
		 setAttr("list", list);
		 return "/com/jdk2010/nsrxx/skqxebg/skqxebg";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqXebg skqXebg=getModel(SkqXebg.class);
  		skqXebgService.save(skqXebg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqXebg skqXebg=skqXebgService.findById(id, SkqXebg.class);
		
		String nsrwjbm = skqXebg.getNsrwjbm();
		SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
		
		skqXebg.setNsrsbh(skqNsrxx.getNsrsbh());
		skqXebg.setNsrmc(skqNsrxx.getNsrmc());
		setAttr("skqXebg", skqXebg);
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqXebg skqXebg=getModel(SkqXebg.class);
 		SecurityUser user = getSessionAttr("securityUser");
 		int clbz = skqXebg.getClbz();
 		int xzbs = 0;
 		if(clbz==2){
 			xzbs = 1;
 		}
 		
 		skqXebg.setXzbs(xzbs);
 		skqXebg.setClz(user.getUsername());
 		skqXebg.setClsj(new Date());
 		
  		skqXebgService.update(skqXebg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqXebgService.deleteByIDS(ids,SkqXebg.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqXebg skqXebg=skqXebgService.findById(id, SkqXebg.class);
					 setAttr("skqXebg", skqXebg);
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_view";
	}
	
}

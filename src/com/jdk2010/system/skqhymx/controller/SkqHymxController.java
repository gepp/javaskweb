package com.jdk2010.system.skqhymx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.system.skqhymx.model.SkqHymx;
import com.jdk2010.system.skqhymx.service.ISkqHymxService;
@Controller
@RequestMapping(value="/skqhymx")
public class SkqHymxController extends BaseController{
	
	@Resource
	ISkqHymxService skqHymxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_hymx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqHymxService.queryForPageList(dbKit, getPage(),SkqHymx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/system/skqhymx/skqhymx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/system/skqhymx/skqhymx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHymx skqHymx=getModel(SkqHymx.class);
  		skqHymxService.save(skqHymx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHymx skqHymx=skqHymxService.findById(id, SkqHymx.class);
					 setAttr("skqHymx", skqHymx);
		return "/com/jdk2010/system/skqhymx/skqhymx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHymx skqHymx=getModel(SkqHymx.class);
  		skqHymxService.update(skqHymx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqHymxService.deleteByIDS(ids,SkqHymx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHymx skqHymx=skqHymxService.findById(id, SkqHymx.class);
					 setAttr("skqHymx", skqHymx);
		return "/com/jdk2010/system/skqhymx/skqhymx_view";
	}
	
}

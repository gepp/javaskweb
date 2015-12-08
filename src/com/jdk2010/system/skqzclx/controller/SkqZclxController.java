package com.jdk2010.system.skqzclx.controller;
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
import com.jdk2010.system.skqzclx.model.SkqZclx;
import com.jdk2010.system.skqzclx.service.ISkqZclxService;
@Controller
@RequestMapping(value="/skqzclx")
public class SkqZclxController extends BaseController{
	
	@Resource
	ISkqZclxService skqZclxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_zclx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqZclxService.queryForPageList(dbKit, getPage(),SkqZclx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/system/skqzclx/skqzclx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/system/skqzclx/skqzclx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqZclx skqZclx=getModel(SkqZclx.class);
  		skqZclxService.save(skqZclx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqZclx skqZclx=skqZclxService.findById(id, SkqZclx.class);
					 setAttr("skqZclx", skqZclx);
		return "/com/jdk2010/system/skqzclx/skqzclx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqZclx skqZclx=getModel(SkqZclx.class);
  		skqZclxService.update(skqZclx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqZclxService.deleteByIDS(ids,SkqZclx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqZclx skqZclx=skqZclxService.findById(id, SkqZclx.class);
					 setAttr("skqZclx", skqZclx);
		return "/com/jdk2010/system/skqzclx/skqzclx_view";
	}
	
}

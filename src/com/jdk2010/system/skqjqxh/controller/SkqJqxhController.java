package com.jdk2010.system.skqjqxh.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.system.skqjqxh.model.SkqJqxh;
import com.jdk2010.system.skqjqxh.service.ISkqJqxhService;
import com.jdk2010.tools.Constants;
@Controller
@RequestMapping(value="/skqjqxh")
public class SkqJqxhController extends BaseController{
	
	@Resource
	ISkqJqxhService skqJqxhService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jqxh  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJqxhService.queryForPageList(dbKit, getPage(),SkqJqxh.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/system/skqjqxh/skqjqxh";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/system/skqjqxh/skqjqxh_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqxh skqJqxh=getModel(SkqJqxh.class);
  		skqJqxhService.save(skqJqxh);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqxh skqJqxh=skqJqxhService.findById(id, SkqJqxh.class);
					 setAttr("skqJqxh", skqJqxh);
		return "/com/jdk2010/system/skqjqxh/skqjqxh_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqxh skqJqxh=getModel(SkqJqxh.class);
  		skqJqxhService.update(skqJqxh);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJqxhService.deleteByIDS(ids,SkqJqxh.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqxh skqJqxh=skqJqxhService.findById(id, SkqJqxh.class);
					 setAttr("skqJqxh", skqJqxh);
		return "/com/jdk2010/system/skqjqxh/skqjqxh_view";
	}
	
}

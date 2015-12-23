package com.jdk2010.system.skqfp.controller;
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
import com.jdk2010.system.skqfp.model.SkqFp;
import com.jdk2010.system.skqfp.service.ISkqFpService;
import com.jdk2010.tools.Constants;
@Controller
@RequestMapping(value="/skqfp")
public class SkqFpController extends BaseController{
	
	@Resource
	ISkqFpService skqFpService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_fp  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqFpService.queryForPageList(dbKit, getPage(),SkqFp.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/system/skqfp/skqfp";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/system/skqfp/skqfp_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFp skqFp=getModel(SkqFp.class);
  		skqFpService.save(skqFp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFp skqFp=skqFpService.findById(id, SkqFp.class);
					 setAttr("skqFp", skqFp);
		return "/com/jdk2010/system/skqfp/skqfp_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFp skqFp=getModel(SkqFp.class);
  		skqFpService.update(skqFp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqFpService.deleteByIDS(ids,SkqFp.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFp skqFp=skqFpService.findById(id, SkqFp.class);
					 setAttr("skqFp", skqFp);
		return "/com/jdk2010/system/skqfp/skqfp_view";
	}
	 @RequestMapping("/select")
	    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        List<Map<String, Object>> fpList =skqFpService.queryForList("select * from skq_fp where status=1");
	        setAttr("fpList", fpList);
	        return "/com/jdk2010/system/skqfp/select";
	    }

}

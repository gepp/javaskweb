package com.jdk2010.jqxx.skqjqszsm.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqszsm.service.ISkqJqszsmService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjqszsm")
public class SkqJqszsmController extends BaseController{
	
	@Resource
	ISkqJqszsmService skqJqszsmService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jqszsm  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJqszsmService.queryForPageList(dbKit, getPage(),SkqJqszsm.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/jqxx/skqjqszsm/skqjqszsm";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/jqxx/skqjqszsm/skqjqszsm_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqszsm skqJqszsm=getModel(SkqJqszsm.class);
  		skqJqszsmService.save(skqJqszsm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqszsm skqJqszsm=skqJqszsmService.findById(id, SkqJqszsm.class);
					 setAttr("skqJqszsm", skqJqszsm);
		return "/com/jdk2010/jqxx/skqjqszsm/skqjqszsm_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqszsm skqJqszsm=getModel(SkqJqszsm.class);
  		skqJqszsmService.update(skqJqszsm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJqszsmService.deleteByIDS(ids,SkqJqszsm.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqszsm skqJqszsm=skqJqszsmService.findById(id, SkqJqszsm.class);
					 setAttr("skqJqszsm", skqJqszsm);
		return "/com/jdk2010/jqxx/skqjqszsm/skqjqszsm_view";
	}
	
}

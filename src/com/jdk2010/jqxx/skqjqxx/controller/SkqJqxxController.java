package com.jdk2010.jqxx.skqjqxx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjqxx")
public class SkqJqxxController extends BaseController{
	
	@Resource
	ISkqJqxxService skqJqxxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jqxx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJqxxService.queryForPageList(dbKit, getPage(),SkqJqxx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/jqxx/skqjqxx/skqjqxx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqxx skqJqxx=getModel(SkqJqxx.class);
  		skqJqxxService.save(skqJqxx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqxx skqJqxx=skqJqxxService.findById(id, SkqJqxx.class);
					 setAttr("skqJqxx", skqJqxx);
		return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJqxx skqJqxx=getModel(SkqJqxx.class);
  		skqJqxxService.update(skqJqxx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJqxxService.deleteByIDS(ids,SkqJqxx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJqxx skqJqxx=skqJqxxService.findById(id, SkqJqxx.class);
					 setAttr("skqJqxx", skqJqxx);
		return "/com/jdk2010/jqxx/skqjqxx/skqjqxx_view";
	}
	
}

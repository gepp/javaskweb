package com.jdk2010.sbsj.skqjksjkz.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqjksjkz.model.SkqJksjkz;
import com.jdk2010.sbsj.skqjksjkz.service.ISkqJksjkzService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjksjkz")
public class SkqJksjkzController extends BaseController{
	
	@Resource
	ISkqJksjkzService skqJksjkzService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jksjkz  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJksjkzService.queryForPageList(dbKit, getPage(),SkqJksjkz.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqjksjkz/skqjksjkz";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqjksjkz/skqjksjkz_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJksjkz skqJksjkz=getModel(SkqJksjkz.class);
  		skqJksjkzService.save(skqJksjkz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJksjkz skqJksjkz=skqJksjkzService.findById(id, SkqJksjkz.class);
					 setAttr("skqJksjkz", skqJksjkz);
		return "/com/jdk2010/sbsj/skqjksjkz/skqjksjkz_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJksjkz skqJksjkz=getModel(SkqJksjkz.class);
  		skqJksjkzService.update(skqJksjkz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJksjkzService.deleteByIDS(ids,SkqJksjkz.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJksjkz skqJksjkz=skqJksjkzService.findById(id, SkqJksjkz.class);
					 setAttr("skqJksjkz", skqJksjkz);
		return "/com/jdk2010/sbsj/skqjksjkz/skqjksjkz_view";
	}
	
}

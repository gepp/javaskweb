package com.jdk2010.sbsj.skqskjs.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqskjs.model.SkqSkjs;
import com.jdk2010.sbsj.skqskjs.service.ISkqSkjsService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqskjs")
public class SkqSkjsController extends BaseController{
	
	@Resource
	ISkqSkjsService skqSkjsService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_skjs  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqSkjsService.queryForPageList(dbKit, getPage(),SkqSkjs.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqskjs/skqskjs";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqskjs/skqskjs_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSkjs skqSkjs=getModel(SkqSkjs.class);
  		skqSkjsService.save(skqSkjs);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSkjs skqSkjs=skqSkjsService.findById(id, SkqSkjs.class);
					 setAttr("skqSkjs", skqSkjs);
		return "/com/jdk2010/sbsj/skqskjs/skqskjs_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSkjs skqSkjs=getModel(SkqSkjs.class);
  		skqSkjsService.update(skqSkjs);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqSkjsService.deleteByIDS(ids,SkqSkjs.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSkjs skqSkjs=skqSkjsService.findById(id, SkqSkjs.class);
					 setAttr("skqSkjs", skqSkjs);
		return "/com/jdk2010/sbsj/skqskjs/skqskjs_view";
	}
	
}

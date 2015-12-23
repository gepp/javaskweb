package com.jdk2010.nsrxx.skqdhde.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.nsrxx.skqdhde.model.SkqDhde;
import com.jdk2010.nsrxx.skqdhde.service.ISkqDhdeService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqdhde")
public class SkqDhdeController extends BaseController{
	
	@Resource
	ISkqDhdeService skqDhdeService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_dhde  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqDhdeService.queryForPageList(dbKit, getPage(),SkqDhde.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/nsrxx/skqdhde/skqdhde";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqdhde/skqdhde_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqDhde skqDhde=getModel(SkqDhde.class);
  		skqDhdeService.save(skqDhde);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqDhde skqDhde=skqDhdeService.findById(id, SkqDhde.class);
					 setAttr("skqDhde", skqDhde);
		return "/com/jdk2010/nsrxx/skqdhde/skqdhde_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqDhde skqDhde=getModel(SkqDhde.class);
  		skqDhdeService.update(skqDhde);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqDhdeService.deleteByIDS(ids,SkqDhde.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqDhde skqDhde=skqDhdeService.findById(id, SkqDhde.class);
					 setAttr("skqDhde", skqDhde);
		return "/com/jdk2010/nsrxx/skqdhde/skqdhde_view";
	}
	
}

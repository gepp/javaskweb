package com.jdk2010.sbsj.skqsbhdhjg.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqsbhdhjg.model.SkqSbhdhjg;
import com.jdk2010.sbsj.skqsbhdhjg.service.ISkqSbhdhjgService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqsbhdhjg")
public class SkqSbhdhjgController extends BaseController{
	
	@Resource
	ISkqSbhdhjgService skqSbhdhjgService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_sbhdhjg  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqSbhdhjgService.queryForPageList(dbKit, getPage(),SkqSbhdhjg.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqsbhdhjg/skqsbhdhjg";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqsbhdhjg/skqsbhdhjg_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbhdhjg skqSbhdhjg=getModel(SkqSbhdhjg.class);
  		skqSbhdhjgService.save(skqSbhdhjg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbhdhjg skqSbhdhjg=skqSbhdhjgService.findById(id, SkqSbhdhjg.class);
					 setAttr("skqSbhdhjg", skqSbhdhjg);
		return "/com/jdk2010/sbsj/skqsbhdhjg/skqsbhdhjg_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbhdhjg skqSbhdhjg=getModel(SkqSbhdhjg.class);
  		skqSbhdhjgService.update(skqSbhdhjg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqSbhdhjgService.deleteByIDS(ids,SkqSbhdhjg.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbhdhjg skqSbhdhjg=skqSbhdhjgService.findById(id, SkqSbhdhjg.class);
					 setAttr("skqSbhdhjg", skqSbhdhjg);
		return "/com/jdk2010/sbsj/skqsbhdhjg/skqsbhdhjg_view";
	}
	
}

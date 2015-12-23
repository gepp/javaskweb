package com.jdk2010.sbsj.skqhzsjmx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqhzsjmx.model.SkqHzsjmx;
import com.jdk2010.sbsj.skqhzsjmx.service.ISkqHzsjmxService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqhzsjmx")
public class SkqHzsjmxController extends BaseController{
	
	@Resource
	ISkqHzsjmxService skqHzsjmxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_hzsjmx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqHzsjmxService.queryForPageList(dbKit, getPage(),SkqHzsjmx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqhzsjmx/skqhzsjmx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqhzsjmx/skqhzsjmx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHzsjmx skqHzsjmx=getModel(SkqHzsjmx.class);
  		skqHzsjmxService.save(skqHzsjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHzsjmx skqHzsjmx=skqHzsjmxService.findById(id, SkqHzsjmx.class);
					 setAttr("skqHzsjmx", skqHzsjmx);
		return "/com/jdk2010/sbsj/skqhzsjmx/skqhzsjmx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHzsjmx skqHzsjmx=getModel(SkqHzsjmx.class);
  		skqHzsjmxService.update(skqHzsjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqHzsjmxService.deleteByIDS(ids,SkqHzsjmx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHzsjmx skqHzsjmx=skqHzsjmxService.findById(id, SkqHzsjmx.class);
					 setAttr("skqHzsjmx", skqHzsjmx);
		return "/com/jdk2010/sbsj/skqhzsjmx/skqhzsjmx_view";
	}
	
}

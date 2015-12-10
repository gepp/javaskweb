package com.jdk2010.invoice.skqfpjmx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;
import com.jdk2010.invoice.skqfpjmx.service.ISkqFpjmxService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqfpjmx")
public class SkqFpjmxController extends BaseController{
	
	@Resource
	ISkqFpjmxService skqFpjmxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_fpjmx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqFpjmxService.queryForPageList(dbKit, getPage(),SkqFpjmx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpjmx skqFpjmx=getModel(SkqFpjmx.class);
  		skqFpjmxService.save(skqFpjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpjmx skqFpjmx=skqFpjmxService.findById(id, SkqFpjmx.class);
					 setAttr("skqFpjmx", skqFpjmx);
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpjmx skqFpjmx=getModel(SkqFpjmx.class);
  		skqFpjmxService.update(skqFpjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqFpjmxService.deleteByIDS(ids,SkqFpjmx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpjmx skqFpjmx=skqFpjmxService.findById(id, SkqFpjmx.class);
					 setAttr("skqFpjmx", skqFpjmx);
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_view";
	}
	
}

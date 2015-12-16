package com.jdk2010.invoice.skqfpkjxm.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.invoice.skqfpkjxm.model.SkqFpkjxm;
import com.jdk2010.invoice.skqfpkjxm.service.ISkqFpkjxmService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqfpkjxm")
public class SkqFpkjxmController extends BaseController{
	
	@Resource
	ISkqFpkjxmService skqFpkjxmService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_fpkjxm  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqFpkjxmService.queryForPageList(dbKit, getPage(),SkqFpkjxm.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/invoice/skqfpkjxm/skqfpkjxm";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/invoice/skqfpkjxm/skqfpkjxm_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkjxm skqFpkjxm=getModel(SkqFpkjxm.class);
  		skqFpkjxmService.save(skqFpkjxm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkjxm skqFpkjxm=skqFpkjxmService.findById(id, SkqFpkjxm.class);
					 setAttr("skqFpkjxm", skqFpkjxm);
		return "/com/jdk2010/invoice/skqfpkjxm/skqfpkjxm_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkjxm skqFpkjxm=getModel(SkqFpkjxm.class);
  		skqFpkjxmService.update(skqFpkjxm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqFpkjxmService.deleteByIDS(ids,SkqFpkjxm.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkjxm skqFpkjxm=skqFpkjxmService.findById(id, SkqFpkjxm.class);
					 setAttr("skqFpkjxm", skqFpkjxm);
		return "/com/jdk2010/invoice/skqfpkjxm/skqfpkjxm_view";
	}
	
}

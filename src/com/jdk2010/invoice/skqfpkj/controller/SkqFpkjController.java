package com.jdk2010.invoice.skqfpkj.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.invoice.skqfpkj.model.SkqFpkj;
import com.jdk2010.invoice.skqfpkj.service.ISkqFpkjService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqfpkj")
public class SkqFpkjController extends BaseController{
	
	@Resource
	ISkqFpkjService skqFpkjService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_fpkj  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqFpkjService.queryForPageList(dbKit, getPage(),SkqFpkj.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/invoice/skqfpkj/skqfpkj";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkj skqFpkj=getModel(SkqFpkj.class);
  		skqFpkjService.save(skqFpkj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkj skqFpkj=skqFpkjService.findById(id, SkqFpkj.class);
					 setAttr("skqFpkj", skqFpkj);
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkj skqFpkj=getModel(SkqFpkj.class);
  		skqFpkjService.update(skqFpkj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqFpkjService.deleteByIDS(ids,SkqFpkj.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkj skqFpkj=skqFpkjService.findById(id, SkqFpkj.class);
					 setAttr("skqFpkj", skqFpkj);
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_view";
	}
	
}

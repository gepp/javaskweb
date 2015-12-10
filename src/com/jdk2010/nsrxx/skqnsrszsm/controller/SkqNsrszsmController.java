package com.jdk2010.nsrxx.skqnsrszsm.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqnsrszsm")
public class SkqNsrszsmController extends BaseController{
	
	@Resource
	ISkqNsrszsmService skqNsrszsmService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_nsrszsm  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqNsrszsmService.queryForPageList(dbKit, getPage(),SkqNsrszsm.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/nsrxx/skqnsrszsm/skqnsrszsm";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqnsrszsm/skqnsrszsm_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqNsrszsm skqNsrszsm=getModel(SkqNsrszsm.class);
  		skqNsrszsmService.save(skqNsrszsm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqNsrszsm skqNsrszsm=skqNsrszsmService.findById(id, SkqNsrszsm.class);
					 setAttr("skqNsrszsm", skqNsrszsm);
		return "/com/jdk2010/nsrxx/skqnsrszsm/skqnsrszsm_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqNsrszsm skqNsrszsm=getModel(SkqNsrszsm.class);
  		skqNsrszsmService.update(skqNsrszsm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqNsrszsmService.deleteByIDS(ids,SkqNsrszsm.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqNsrszsm skqNsrszsm=skqNsrszsmService.findById(id, SkqNsrszsm.class);
					 setAttr("skqNsrszsm", skqNsrszsm);
		return "/com/jdk2010/nsrxx/skqnsrszsm/skqnsrszsm_view";
	}
	
}

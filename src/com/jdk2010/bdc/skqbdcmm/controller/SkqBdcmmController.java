package com.jdk2010.bdc.skqbdcmm.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdcmm.model.SkqBdcmm;
import com.jdk2010.bdc.skqbdcmm.service.ISkqBdcmmService;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.tools.Constants;
@Controller
@RequestMapping(value="/skqbdcmm")
public class SkqBdcmmController extends BaseController{
	
	@Resource
	ISkqBdcmmService skqBdcmmService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_bdcmm  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqBdcmmService.queryForPageList(dbKit, getPage(),SkqBdcmm.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/bdc/skqbdcmm/skqbdcmm";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/bdc/skqbdcmm/skqbdcmm_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdcmm skqBdcmm=getModel(SkqBdcmm.class);
  		skqBdcmmService.save(skqBdcmm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdcmm skqBdcmm=skqBdcmmService.findById(id, SkqBdcmm.class);
					 setAttr("skqBdcmm", skqBdcmm);
		return "/com/jdk2010/bdc/skqbdcmm/skqbdcmm_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdcmm skqBdcmm=getModel(SkqBdcmm.class);
  		skqBdcmmService.update(skqBdcmm);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqBdcmmService.deleteByIDS(ids,SkqBdcmm.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdcmm skqBdcmm=skqBdcmmService.findById(id, SkqBdcmm.class);
					 setAttr("skqBdcmm", skqBdcmm);
		return "/com/jdk2010/bdc/skqbdcmm/skqbdcmm_view";
	}
	
}

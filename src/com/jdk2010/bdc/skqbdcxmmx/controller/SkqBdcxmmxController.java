package com.jdk2010.bdc.skqbdcxmmx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdcxmmx.model.SkqBdcxmmx;
import com.jdk2010.bdc.skqbdcxmmx.service.ISkqBdcxmmxService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqbdcxmmx")
public class SkqBdcxmmxController extends BaseController{
	
	@Resource
	ISkqBdcxmmxService skqBdcxmmxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_bdcxmmx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqBdcxmmxService.queryForPageList(dbKit, getPage(),SkqBdcxmmx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdcxmmx skqBdcxmmx=getModel(SkqBdcxmmx.class);
  		skqBdcxmmxService.save(skqBdcxmmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdcxmmx skqBdcxmmx=skqBdcxmmxService.findById(id, SkqBdcxmmx.class);
					 setAttr("skqBdcxmmx", skqBdcxmmx);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdcxmmx skqBdcxmmx=getModel(SkqBdcxmmx.class);
  		skqBdcxmmxService.update(skqBdcxmmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqBdcxmmxService.deleteByIDS(ids,SkqBdcxmmx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdcxmmx skqBdcxmmx=skqBdcxmmxService.findById(id, SkqBdcxmmx.class);
					 setAttr("skqBdcxmmx", skqBdcxmmx);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_view";
	}
	
}

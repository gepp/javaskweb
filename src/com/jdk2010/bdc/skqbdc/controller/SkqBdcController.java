package com.jdk2010.bdc.skqbdc.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdc.service.ISkqBdcService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqbdc")
public class SkqBdcController extends BaseController{
	
	@Resource
	ISkqBdcService skqBdcService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_bdc  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqBdcService.queryForPageList(dbKit, getPage(),SkqBdc.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/bdc/skqbdc/skqbdc";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/bdc/skqbdc/skqbdc_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdc skqBdc=getModel(SkqBdc.class);
  		skqBdcService.save(skqBdc);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdc skqBdc=skqBdcService.findById(id, SkqBdc.class);
					 setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdc/skqbdc_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdc skqBdc=getModel(SkqBdc.class);
  		skqBdcService.update(skqBdc);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqBdcService.deleteByIDS(ids,SkqBdc.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdc skqBdc=skqBdcService.findById(id, SkqBdc.class);
					 setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdc/skqbdc_view";
	}
	
}

package com.jdk2010.bdc.skqbdckp.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdckp.model.SkqBdckp;
import com.jdk2010.bdc.skqbdckp.service.ISkqBdckpService;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.tools.Constants;
@Controller
@RequestMapping(value="/skqbdckp")
public class SkqBdckpController extends BaseController{
	
	@Resource
	ISkqBdckpService skqBdckpService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_bdckp  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqBdckpService.queryForPageList(dbKit, getPage(),SkqBdckp.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/bdc/skqbdckp/skqbdckp";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/bdc/skqbdckp/skqbdckp_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdckp skqBdckp=getModel(SkqBdckp.class);
  		skqBdckpService.save(skqBdckp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdckp skqBdckp=skqBdckpService.findById(id, SkqBdckp.class);
					 setAttr("skqBdckp", skqBdckp);
		return "/com/jdk2010/bdc/skqbdckp/skqbdckp_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdckp skqBdckp=getModel(SkqBdckp.class);
  		skqBdckpService.update(skqBdckp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqBdckpService.deleteByIDS(ids,SkqBdckp.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdckp skqBdckp=skqBdckpService.findById(id, SkqBdckp.class);
					 setAttr("skqBdckp", skqBdckp);
		return "/com/jdk2010/bdc/skqbdckp/skqbdckp_view";
	}
	
}

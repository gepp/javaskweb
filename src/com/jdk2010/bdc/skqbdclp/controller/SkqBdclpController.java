package com.jdk2010.bdc.skqbdclp.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdclp.model.SkqBdclp;
import com.jdk2010.bdc.skqbdclp.service.ISkqBdclpService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqbdclp")
public class SkqBdclpController extends BaseController{
	
	@Resource
	ISkqBdclpService skqBdclpService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_bdclp  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqBdclpService.queryForPageList(dbKit, getPage(),SkqBdclp.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/bdc/skqbdclp/skqbdclp";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/bdc/skqbdclp/skqbdclp_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdclp skqBdclp=getModel(SkqBdclp.class);
  		skqBdclpService.save(skqBdclp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdclp skqBdclp=skqBdclpService.findById(id, SkqBdclp.class);
					 setAttr("skqBdclp", skqBdclp);
		return "/com/jdk2010/bdc/skqbdclp/skqbdclp_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqBdclp skqBdclp=getModel(SkqBdclp.class);
  		skqBdclpService.update(skqBdclp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqBdclpService.deleteByIDS(ids,SkqBdclp.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqBdclp skqBdclp=skqBdclpService.findById(id, SkqBdclp.class);
					 setAttr("skqBdclp", skqBdclp);
		return "/com/jdk2010/bdc/skqbdclp/skqbdclp_view";
	}
	
}

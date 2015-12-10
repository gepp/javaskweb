package com.jdk2010.nsrxx.skqxebg.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.nsrxx.skqxebg.model.SkqXebg;
import com.jdk2010.nsrxx.skqxebg.service.ISkqXebgService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqxebg")
public class SkqXebgController extends BaseController{
	
	@Resource
	ISkqXebgService skqXebgService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_xebg  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqXebgService.queryForPageList(dbKit, getPage(),SkqXebg.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/nsrxx/skqxebg/skqxebg";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqXebg skqXebg=getModel(SkqXebg.class);
  		skqXebgService.save(skqXebg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqXebg skqXebg=skqXebgService.findById(id, SkqXebg.class);
					 setAttr("skqXebg", skqXebg);
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqXebg skqXebg=getModel(SkqXebg.class);
  		skqXebgService.update(skqXebg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqXebgService.deleteByIDS(ids,SkqXebg.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqXebg skqXebg=skqXebgService.findById(id, SkqXebg.class);
					 setAttr("skqXebg", skqXebg);
		return "/com/jdk2010/nsrxx/skqxebg/skqxebg_view";
	}
	
}

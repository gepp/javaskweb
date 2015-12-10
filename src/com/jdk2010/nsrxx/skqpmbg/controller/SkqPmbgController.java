package com.jdk2010.nsrxx.skqpmbg.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.nsrxx.skqpmbg.model.SkqPmbg;
import com.jdk2010.nsrxx.skqpmbg.service.ISkqPmbgService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqpmbg")
public class SkqPmbgController extends BaseController{
	
	@Resource
	ISkqPmbgService skqPmbgService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_pmbg  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqPmbgService.queryForPageList(dbKit, getPage(),SkqPmbg.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/nsrxx/skqpmbg/skqpmbg";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqpmbg/skqpmbg_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqPmbg skqPmbg=getModel(SkqPmbg.class);
  		skqPmbgService.save(skqPmbg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqPmbg skqPmbg=skqPmbgService.findById(id, SkqPmbg.class);
					 setAttr("skqPmbg", skqPmbg);
		return "/com/jdk2010/nsrxx/skqpmbg/skqpmbg_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqPmbg skqPmbg=getModel(SkqPmbg.class);
  		skqPmbgService.update(skqPmbg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqPmbgService.deleteByIDS(ids,SkqPmbg.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqPmbg skqPmbg=skqPmbgService.findById(id, SkqPmbg.class);
					 setAttr("skqPmbg", skqPmbg);
		return "/com/jdk2010/nsrxx/skqpmbg/skqpmbg_view";
	}
	
}

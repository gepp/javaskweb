package com.jdk2010.sbsj.skqhzsj.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqhzsj.model.SkqHzsj;
import com.jdk2010.sbsj.skqhzsj.service.ISkqHzsjService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqhzsj")
public class SkqHzsjController extends BaseController{
	
	@Resource
	ISkqHzsjService skqHzsjService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_hzsj  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqHzsjService.queryForPageList(dbKit, getPage(),SkqHzsj.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqhzsj/skqhzsj";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqhzsj/skqhzsj_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHzsj skqHzsj=getModel(SkqHzsj.class);
  		skqHzsjService.save(skqHzsj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHzsj skqHzsj=skqHzsjService.findById(id, SkqHzsj.class);
					 setAttr("skqHzsj", skqHzsj);
		return "/com/jdk2010/sbsj/skqhzsj/skqhzsj_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqHzsj skqHzsj=getModel(SkqHzsj.class);
  		skqHzsjService.update(skqHzsj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqHzsjService.deleteByIDS(ids,SkqHzsj.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqHzsj skqHzsj=skqHzsjService.findById(id, SkqHzsj.class);
					 setAttr("skqHzsj", skqHzsj);
		return "/com/jdk2010/sbsj/skqhzsj/skqhzsj_view";
	}
	
}

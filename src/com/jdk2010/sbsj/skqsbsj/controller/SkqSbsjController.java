package com.jdk2010.sbsj.skqsbsj.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqsbsj.model.SkqSbsj;
import com.jdk2010.sbsj.skqsbsj.service.ISkqSbsjService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqsbsj")
public class SkqSbsjController extends BaseController{
	
	@Resource
	ISkqSbsjService skqSbsjService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_sbsj  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqSbsjService.queryForPageList(dbKit, getPage(),SkqSbsj.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqsbsj/skqsbsj";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbsj skqSbsj=getModel(SkqSbsj.class);
  		skqSbsjService.save(skqSbsj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbsj skqSbsj=skqSbsjService.findById(id, SkqSbsj.class);
					 setAttr("skqSbsj", skqSbsj);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbsj skqSbsj=getModel(SkqSbsj.class);
  		skqSbsjService.update(skqSbsj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqSbsjService.deleteByIDS(ids,SkqSbsj.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbsj skqSbsj=skqSbsjService.findById(id, SkqSbsj.class);
					 setAttr("skqSbsj", skqSbsj);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_view";
	}
	
}

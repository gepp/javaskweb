package com.jdk2010.sbsj.skqwdhxh.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqwdhxh.model.SkqWdhxh;
import com.jdk2010.sbsj.skqwdhxh.service.ISkqWdhxhService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqwdhxh")
public class SkqWdhxhController extends BaseController{
	
	@Resource
	ISkqWdhxhService skqWdhxhService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_wdhxh  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqWdhxhService.queryForPageList(dbKit, getPage(),SkqWdhxh.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqwdhxh/skqwdhxh";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqwdhxh/skqwdhxh_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqWdhxh skqWdhxh=getModel(SkqWdhxh.class);
  		skqWdhxhService.save(skqWdhxh);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqWdhxh skqWdhxh=skqWdhxhService.findById(id, SkqWdhxh.class);
					 setAttr("skqWdhxh", skqWdhxh);
		return "/com/jdk2010/sbsj/skqwdhxh/skqwdhxh_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqWdhxh skqWdhxh=getModel(SkqWdhxh.class);
  		skqWdhxhService.update(skqWdhxh);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqWdhxhService.deleteByIDS(ids,SkqWdhxh.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqWdhxh skqWdhxh=skqWdhxhService.findById(id, SkqWdhxh.class);
					 setAttr("skqWdhxh", skqWdhxh);
		return "/com/jdk2010/sbsj/skqwdhxh/skqwdhxh_view";
	}
	
}

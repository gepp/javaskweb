package com.jdk2010.sbsj.skqjsgz.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqjsgz.model.SkqJsgz;
import com.jdk2010.sbsj.skqjsgz.service.ISkqJsgzService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjsgz")
public class SkqJsgzController extends BaseController{
	
	@Resource
	ISkqJsgzService skqJsgzService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jsgz  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJsgzService.queryForPageList(dbKit, getPage(),SkqJsgz.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqjsgz/skqjsgz";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqjsgz/skqjsgz_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJsgz skqJsgz=getModel(SkqJsgz.class);
  		skqJsgzService.save(skqJsgz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJsgz skqJsgz=skqJsgzService.findById(id, SkqJsgz.class);
					 setAttr("skqJsgz", skqJsgz);
		return "/com/jdk2010/sbsj/skqjsgz/skqjsgz_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJsgz skqJsgz=getModel(SkqJsgz.class);
  		skqJsgzService.update(skqJsgz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJsgzService.deleteByIDS(ids,SkqJsgz.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJsgz skqJsgz=skqJsgzService.findById(id, SkqJsgz.class);
					 setAttr("skqJsgz", skqJsgz);
		return "/com/jdk2010/sbsj/skqjsgz/skqjsgz_view";
	}
	
}

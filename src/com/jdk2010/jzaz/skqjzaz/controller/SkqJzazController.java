package com.jdk2010.jzaz.skqjzaz.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jzaz.skqjzaz.model.SkqJzaz;
import com.jdk2010.jzaz.skqjzaz.service.ISkqJzazService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjzaz")
public class SkqJzazController extends BaseController{
	
	@Resource
	ISkqJzazService skqJzazService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jzaz  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJzazService.queryForPageList(dbKit, getPage(),SkqJzaz.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/jzaz/skqjzaz/skqjzaz";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
  		skqJzazService.save(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzaz skqJzaz=skqJzazService.findById(id, SkqJzaz.class);
					 setAttr("skqJzaz", skqJzaz);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzaz skqJzaz=getModel(SkqJzaz.class);
  		skqJzazService.update(skqJzaz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJzazService.deleteByIDS(ids,SkqJzaz.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzaz skqJzaz=skqJzazService.findById(id, SkqJzaz.class);
					 setAttr("skqJzaz", skqJzaz);
		return "/com/jdk2010/jzaz/skqjzaz/skqjzaz_view";
	}
	
}

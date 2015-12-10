package com.jdk2010.sbsj.skqsbsjmx.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqsbsjmx.model.SkqSbsjmx;
import com.jdk2010.sbsj.skqsbsjmx.service.ISkqSbsjmxService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqsbsjmx")
public class SkqSbsjmxController extends BaseController{
	
	@Resource
	ISkqSbsjmxService skqSbsjmxService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_sbsjmx  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqSbsjmxService.queryForPageList(dbKit, getPage(),SkqSbsjmx.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqsbsjmx/skqsbsjmx";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqsbsjmx/skqsbsjmx_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbsjmx skqSbsjmx=getModel(SkqSbsjmx.class);
  		skqSbsjmxService.save(skqSbsjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbsjmx skqSbsjmx=skqSbsjmxService.findById(id, SkqSbsjmx.class);
					 setAttr("skqSbsjmx", skqSbsjmx);
		return "/com/jdk2010/sbsj/skqsbsjmx/skqsbsjmx_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbsjmx skqSbsjmx=getModel(SkqSbsjmx.class);
  		skqSbsjmxService.update(skqSbsjmx);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqSbsjmxService.deleteByIDS(ids,SkqSbsjmx.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbsjmx skqSbsjmx=skqSbsjmxService.findById(id, SkqSbsjmx.class);
					 setAttr("skqSbsjmx", skqSbsjmx);
		return "/com/jdk2010/sbsj/skqsbsjmx/skqsbsjmx_view";
	}
	
}

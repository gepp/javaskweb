package com.jdk2010.jzaz.skqjzazkp.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.jzaz.skqjzazkp.model.SkqJzazkp;
import com.jdk2010.jzaz.skqjzazkp.service.ISkqJzazkpService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqjzazkp")
public class SkqJzazkpController extends BaseController{
	
	@Resource
	ISkqJzazkpService skqJzazkpService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_jzazkp  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqJzazkpService.queryForPageList(dbKit, getPage(),SkqJzazkp.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/jzaz/skqjzazkp/skqjzazkp";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/jzaz/skqjzazkp/skqjzazkp_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzazkp skqJzazkp=getModel(SkqJzazkp.class);
  		skqJzazkpService.save(skqJzazkp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzazkp skqJzazkp=skqJzazkpService.findById(id, SkqJzazkp.class);
					 setAttr("skqJzazkp", skqJzazkp);
		return "/com/jdk2010/jzaz/skqjzazkp/skqjzazkp_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqJzazkp skqJzazkp=getModel(SkqJzazkp.class);
  		skqJzazkpService.update(skqJzazkp);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqJzazkpService.deleteByIDS(ids,SkqJzazkp.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqJzazkp skqJzazkp=skqJzazkpService.findById(id, SkqJzazkp.class);
					 setAttr("skqJzazkp", skqJzazkp);
		return "/com/jdk2010/jzaz/skqjzazkp/skqjzazkp_view";
	}
	
}

package com.jdk2010.sbsj.skqsbczzshjg.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.sbsj.skqsbczzshjg.model.SkqSbczzshjg;
import com.jdk2010.sbsj.skqsbczzshjg.service.ISkqSbczzshjgService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqsbczzshjg")
public class SkqSbczzshjgController extends BaseController{
	
	@Resource
	ISkqSbczzshjgService skqSbczzshjgService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_sbczzshjg  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqSbczzshjgService.queryForPageList(dbKit, getPage(),SkqSbczzshjg.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/sbsj/skqsbczzshjg/skqsbczzshjg";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/sbsj/skqsbczzshjg/skqsbczzshjg_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbczzshjg skqSbczzshjg=getModel(SkqSbczzshjg.class);
  		skqSbczzshjgService.save(skqSbczzshjg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbczzshjg skqSbczzshjg=skqSbczzshjgService.findById(id, SkqSbczzshjg.class);
					 setAttr("skqSbczzshjg", skqSbczzshjg);
		return "/com/jdk2010/sbsj/skqsbczzshjg/skqsbczzshjg_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqSbczzshjg skqSbczzshjg=getModel(SkqSbczzshjg.class);
  		skqSbczzshjgService.update(skqSbczzshjg);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqSbczzshjgService.deleteByIDS(ids,SkqSbczzshjg.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqSbczzshjg skqSbczzshjg=skqSbczzshjgService.findById(id, SkqSbczzshjg.class);
					 setAttr("skqSbczzshjg", skqSbczzshjg);
		return "/com/jdk2010/sbsj/skqsbczzshjg/skqsbczzshjg_view";
	}
	
}

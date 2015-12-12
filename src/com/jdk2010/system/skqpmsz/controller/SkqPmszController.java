package com.jdk2010.system.skqpmsz.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.system.skqpmsz.model.SkqPmsz;
import com.jdk2010.system.skqpmsz.service.ISkqPmszService;
@Controller
@RequestMapping(value="/skqpmsz")
public class SkqPmszController extends BaseController{
	
	@Resource
	ISkqPmszService skqPmszService;
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select * from skq_pmsz  where 1=1 ");
		 		String searchSQL="";
		String orderSQL="";
			    		    			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     			     		     	dbKit.append(orderSQL);
		 Page pageList=skqPmszService.queryForPageList(dbKit, getPage(),SkqPmsz.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/system/skqpmsz/skqpmsz";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/system/skqpmsz/skqpmsz_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqPmsz skqPmsz=getModel(SkqPmsz.class);
  		skqPmszService.save(skqPmsz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqPmsz skqPmsz=skqPmszService.findById(id, SkqPmsz.class);
					 setAttr("skqPmsz", skqPmsz);
		return "/com/jdk2010/system/skqpmsz/skqpmsz_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqPmsz skqPmsz=getModel(SkqPmsz.class);
  		skqPmszService.update(skqPmsz);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqPmszService.deleteByIDS(ids,SkqPmsz.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqPmsz skqPmsz=skqPmszService.findById(id, SkqPmsz.class);
					 setAttr("skqPmsz", skqPmsz);
		return "/com/jdk2010/system/skqpmsz/skqpmsz_view";
	}
	
	@RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> list = skqPmszService.queryForList("select * from skq_pmsz where status=1");
        setAttr("list", list);
        String smbms=getPara("smbms");
        setAttr("smbms", smbms);
        return "/com/jdk2010/system/skqpmsz/select";
    }
	@RequestMapping("/selectJqszsm")
    public String selectJqszsm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nsrwjbm=getPara("nsrwjbm");
        List<Map<String, Object>> list = skqPmszService.queryForList("select * from skq_pmsz where smbm in (select smbm from skq_nsrszsm where nsrwjbm='"+nsrwjbm+"')");
        setAttr("list", list);
        String smbms=getPara("smbms");
        setAttr("smbms", smbms);
        return "/com/jdk2010/jqxx/skqjqszsm/select";
    }
}

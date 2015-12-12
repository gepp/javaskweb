package com.jdk2010.bdc.skqbdczxm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jdk2010.bdc.skqbdczxm.model.SkqBdczxm;
import com.jdk2010.bdc.skqbdczxm.service.ISkqBdczxmService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;

@Controller
@RequestMapping(value = "/skqbdczxm")
public class SkqBdczxmController extends BaseController {

	@Resource
	ISkqBdczxmService skqBdczxmService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		
		DbKit dbKit = new DbKit("select * from skq_bdczxm  where 1=1 ");
		String searchSQL = "";
		String orderSQL = "";
		dbKit.append(orderSQL);
		Page pageList = skqBdczxmService.queryForPageList(dbKit, getPage(),
				SkqBdczxm.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdczxm skqBdczxm = getModel(SkqBdczxm.class);
		skqBdczxmService.save(skqBdczxm);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqBdczxm skqBdczxm = skqBdczxmService.findById(id, SkqBdczxm.class);
		setAttr("skqBdczxm", skqBdczxm);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdczxm skqBdczxm = getModel(SkqBdczxm.class);
		skqBdczxmService.update(skqBdczxm);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqBdczxmService.deleteByIDS(ids, SkqBdczxm.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqBdczxm skqBdczxm = skqBdczxmService.findById(id, SkqBdczxm.class);
		setAttr("skqBdczxm", skqBdczxm);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm_view";
	}

}

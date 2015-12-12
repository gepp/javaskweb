package com.jdk2010.invoice.skqfpj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;

@Controller
@RequestMapping(value = "/skqfpj")
public class SkqFpjController extends BaseController {

	@Resource
	ISkqFpjService skqFpjService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DbKit dbKit = new DbKit("select * from skq_fpj  where 1=1 ");
		String searchSQL = "";
		String NSRWJBM = getPara("NSRWJBM");
		if (NSRWJBM != null && !"".equals(NSRWJBM)) {
			searchSQL = searchSQL + " and  NSRWJBM LIKE '%" + NSRWJBM + "%'";
			setAttr("NSRWJBM", NSRWJBM);
		}

		String SWJGBM = getPara("SWJGBM");
		if (SWJGBM != null && !"".equals(SWJGBM)) {
			searchSQL = searchSQL + " and  nsrwjbm ='" + SWJGBM + "'";
			setAttr("SWJGBM", SWJGBM);
		}

		String startTime = getPara("startTime");
		if (startTime != null && !"".equals(startTime)) {
			searchSQL = searchSQL + " and  startTime>'" + startTime
					+ " 00:00:00'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  endTime<'" + endTime + " 23:59:59'";
			setAttr("endTime", endTime);
		}

		dbKit.append(searchSQL);
		Page pageList = skqFpjService.queryForPageList(dbKit, getPage(),
				SkqFpj.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/invoice/skqfpj/skqfpj";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/invoice/skqfpj/skqfpj_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqFpj skqFpj = getModel(SkqFpj.class);
		skqFpjService.save(skqFpj);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqFpj skqFpj = skqFpjService.findById(id, SkqFpj.class);
		setAttr("skqFpj", skqFpj);
		return "/com/jdk2010/invoice/skqfpj/skqfpj_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqFpj skqFpj = getModel(SkqFpj.class);
		skqFpjService.update(skqFpj);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqFpjService.deleteByIDS(ids, SkqFpj.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqFpj skqFpj = skqFpjService.findById(id, SkqFpj.class);
		setAttr("skqFpj", skqFpj);
		return "/com/jdk2010/invoice/skqfpj/skqfpj_view";
	}

}

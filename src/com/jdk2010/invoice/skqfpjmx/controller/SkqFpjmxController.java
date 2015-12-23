package com.jdk2010.invoice.skqfpjmx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;
import com.jdk2010.invoice.skqfpjmx.service.ISkqFpjmxService;
import com.jdk2010.tools.Constants;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;

@Controller
@RequestMapping(value = "/skqfpjmx")
public class SkqFpjmxController extends BaseController {

	@Resource
	ISkqFpjmxService skqFpjmxService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DbKit dbKit = new DbKit("select * from skq_fpjmx   t inner JOIN skq_nsrxx a ON t.nsrwjbm=a.nsrwjbm inner JOIN security_organization b ON a.swjgbm=b.code  ");
		String searchSQL = "";
		String NSRWJBM = getPara("NSRWJBM");
		if (NSRWJBM != null && !"".equals(NSRWJBM)) {
			searchSQL = searchSQL + " and  NSRWJBM LIKE '%" + NSRWJBM + "%'";
			setAttr("NSRWJBM", NSRWJBM);
		}

		String JQBH = getPara("JQBH");
		if (JQBH != null && !"".equals(JQBH)) {
			searchSQL = searchSQL + " and  JQBH ='" + JQBH + "'";
			setAttr("JQBH", JQBH);
		}

		String startTime = getPara("startTime");
		if (startTime != null && !"".equals(startTime)) {
			searchSQL = searchSQL + " and  FPLGRQ>='" + startTime
					+ " 00:00:00'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  FPLGRQ<='" + endTime + " 23:59:59'";
			setAttr("endTime", endTime);
		}

		String SWJGBM = getPara("SWJGBM");
		if (SWJGBM != null && !"".equals(SWJGBM)) {
			searchSQL = searchSQL
					+ " and   a.swjgbm='"+SWJGBM+"'";
			setAttr("SWJGBM", SWJGBM);
			setAttr("parentName", getPara("parentName"));
		}

		dbKit.append(searchSQL);
		Page pageList = skqFpjmxService.queryForPageList(dbKit, getPage(),
				SkqFpjmx.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqFpjmx skqFpjmx = getModel(SkqFpjmx.class);
		skqFpjmxService.save(skqFpjmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqFpjmx skqFpjmx = skqFpjmxService.findById(id, SkqFpjmx.class);
		setAttr("skqFpjmx", skqFpjmx);
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqFpjmx skqFpjmx = getModel(SkqFpjmx.class);
		skqFpjmxService.update(skqFpjmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqFpjmxService.deleteByIDS(ids, SkqFpjmx.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqFpjmx skqFpjmx = skqFpjmxService.findById(id, SkqFpjmx.class);
		setAttr("skqFpjmx", skqFpjmx);
		return "/com/jdk2010/invoice/skqfpjmx/skqfpjmx_view";
	}

}

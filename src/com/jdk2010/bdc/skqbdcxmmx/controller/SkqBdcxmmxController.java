package com.jdk2010.bdc.skqbdcxmmx.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdc.service.ISkqBdcService;
import com.jdk2010.bdc.skqbdcxmmx.model.SkqBdcxmmx;
import com.jdk2010.bdc.skqbdcxmmx.service.ISkqBdcxmmxService;
import com.jdk2010.bdc.skqbdczxm.model.SkqBdczxm;
import com.jdk2010.bdc.skqbdczxm.service.ISkqBdczxmService;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.tools.Constants;

@Controller
@RequestMapping(value = "/skqbdcxmmx")
public class SkqBdcxmmxController extends BaseController {

	@Resource
	ISkqBdcxmmxService skqBdcxmmxService;
	@Resource
	ISkqBdczxmService skqBdczxmService;
	@Resource
	ISkqBdcService skqBdcService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String bdcid = getPara("bdcid");
		String bdczxmid = getPara("bdczxmid");
		String nsrwjbm = getPara("nsrwjbm");
		String xmmc = getPara("xmmc");
		String sqlStr = "";
		if (!StringUtil.isBlank(xmmc)) {
			sqlStr = " and a.xmmc like '%" + xmmc + "%'";
		}
		List<Map<String, Object>> list = skqBdcxmmxService
				.queryForList("select a.*,(a.BZXPTZZTS+a.FBZXPTZZTS+a.FPTZZTS+a.BSTS+a.SPTS+a.XZLTS+a.QTTS) as zts,(select count(id) from skq_bdclp where parentid=a.id) as lrts from skq_bdcxmmx a  where a.parentid='"
						+ bdczxmid + "' " + sqlStr + " order by a.cjsj desc");
		
		SkqBdc skqBdc = skqBdcService.loadBdc(bdcid);
		String bdcXmmc = skqBdc.getXmmc();
		SkqBdczxm skqBdczxm = skqBdczxmService.loadBdczxm(bdczxmid);
		String bdcZxmmc = skqBdczxm.getXmmc();
		String zxmmc = "";
		if(bdcXmmc.equals(bdcZxmmc)){
			zxmmc = bdcXmmc;
		}
		else{
			zxmmc = bdcXmmc+bdcZxmmc;
		}
		
		setAttr("list", list);
		setAttr("zxmmc", zxmmc);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("bdcid", bdcid);
		setAttr("bdczxmid", bdczxmid);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdcxmmx skqBdcxmmx = getModel(SkqBdcxmmx.class);
		skqBdcxmmxService.save(skqBdcxmmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqBdcxmmx skqBdcxmmx = skqBdcxmmxService
				.findById(id, SkqBdcxmmx.class);
		setAttr("skqBdcxmmx", skqBdcxmmx);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdcxmmx skqBdcxmmx = getModel(SkqBdcxmmx.class);
		skqBdcxmmxService.update(skqBdcxmmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqBdcxmmxService.deleteByIDS(ids, SkqBdcxmmx.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqBdcxmmx skqBdcxmmx = skqBdcxmmxService
				.findById(id, SkqBdcxmmx.class);
		setAttr("skqBdcxmmx", skqBdcxmmx);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_view";
	}

}

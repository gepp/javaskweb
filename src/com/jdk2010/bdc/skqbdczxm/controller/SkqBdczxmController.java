package com.jdk2010.bdc.skqbdczxm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdc.service.ISkqBdcService;
import com.jdk2010.bdc.skqbdczxm.model.SkqBdczxm;
import com.jdk2010.bdc.skqbdczxm.service.ISkqBdczxmService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.tools.Constants;

@Controller
@RequestMapping(value = "/skqbdczxm")
public class SkqBdczxmController extends BaseController {

	@Resource
	ISkqBdczxmService skqBdczxmService;
	@Resource
	ISkqBdcService skqBdcService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		String bdcid = getPara("bdcid");
		String xmmc = getPara("xmmc");
		String sqlStr = "";
		if(!StringUtil.isBlank(xmmc)){
			sqlStr = " and xmmc like '%"+xmmc+"%'";
		}
		List<Map<String, Object>> list = skqBdczxmService.queryForList("select * from skq_bdczxm  where parentid='"+bdcid+"' "+sqlStr+" order by cjsj desc");
		
		SkqBdc skqBdc = skqBdcService.loadBdc(bdcid);
		
		setAttr("list", list);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("bdcid", bdcid);
		setAttr("xmmc", xmmc);
		setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		String bdcid = getPara("bdcid");
		
		SkqBdc skqBdc = skqBdcService.loadBdc(bdcid);
		
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("bdcid", bdcid);
		setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String bdcXmmc = getPara("bdcXmmc");
		SkqBdczxm skqBdczxm = getModel(SkqBdczxm.class);
		String xmmc = skqBdczxm.getXmmc();
		if(StringUtil.isBlank(xmmc)){
			xmmc = bdcXmmc;
		}
		skqBdczxm.setXmmc(xmmc);
		
		SecurityUser user = getSessionAttr("securityUser");
		skqBdczxm.setZgswjg(user.getOrganizationCode());
		skqBdczxm.setCjz(user.getUsername());
		skqBdczxm.setCjsj(new Date());
		
		skqBdczxmService.save(skqBdczxm);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqBdczxm skqBdczxm = skqBdczxmService.findById(id, SkqBdczxm.class);
		
		SkqBdc skqBdc = skqBdcService.loadBdc(String.valueOf(skqBdczxm.getParentid()));
		
		setAttr("skqBdczxm", skqBdczxm);
		setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdczxm/skqbdczxm_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String bdcXmmc = getPara("bdcXmmc");
		SkqBdczxm skqBdczxm = getModel(SkqBdczxm.class);
		String xmmc = skqBdczxm.getXmmc();
		if(StringUtil.isBlank(xmmc)){
			xmmc = bdcXmmc;
		}
		skqBdczxm.setXmmc(xmmc);
		skqBdczxm.setCjsj(new Date());
		skqBdczxmService.update(skqBdczxm);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqBdczxmService.deleteByIDS(ids, SkqBdczxm.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
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

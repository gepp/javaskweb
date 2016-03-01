package com.jdk2010.bdc.skqbdcxmmx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.securityuser.model.SecurityUser;
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
		String nsrwjbm = getPara("nsrwjbm");
		String bdcid = getPara("bdcid");
		String bdczxmid = getPara("bdczxmid");
		
		long dqlsh = skqBdcxmmxService.getBdcxmmxLsh()+1;
		String lsh = String.valueOf(dqlsh);
		for(int i=lsh.length();i<4;i++){
			lsh = "0"+lsh;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowtime = sdf.format(new Date());
		String xmbm = "F"+nowtime+lsh;
		
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
		
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("bdcid", bdcid);
		setAttr("bdczxmid", bdczxmid);
		setAttr("xmbm", xmbm);
		setAttr("zxmmc", zxmmc);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdcxmmx skqBdcxmmx = getModel(SkqBdcxmmx.class);
		String zxmmc = getPara("zxmmc");
		String bdczxmid = getPara("bdczxmid");
		skqBdcxmmx.setParentid(Integer.parseInt(bdczxmid));
		String xmmc = skqBdcxmmx.getXmmc();
		zxmmc = zxmmc+xmmc;
		skqBdcxmmx.setZxmmc(zxmmc);
		
		SecurityUser user = getSessionAttr("securityUser");
		skqBdcxmmx.setCjz(user.getUsername());
		skqBdcxmmx.setCjsj(new Date());
		
		skqBdcxmmxService.save(skqBdcxmmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqBdcxmmx skqBdcxmmx = skqBdcxmmxService.findById(id, SkqBdcxmmx.class);
		int bdczxmid =  skqBdcxmmx.getParentid();
		SkqBdczxm skqBdczxm = skqBdczxmService.loadBdczxm(String.valueOf(bdczxmid));
		int bdcid = skqBdczxm.getParentid();
		
		SkqBdc skqBdc = skqBdcService.loadBdc(String.valueOf(bdcid));
		String bdcXmmc = skqBdc.getXmmc();
		String bdcZxmmc = skqBdczxm.getXmmc();
		String zxmmc = "";
		if(bdcXmmc.equals(bdcZxmmc)){
			zxmmc = bdcXmmc;
		}
		else{
			zxmmc = bdcXmmc+bdcZxmmc;
		}
		
		setAttr("skqBdcxmmx", skqBdcxmmx);
		setAttr("bdcid", bdcid);
		setAttr("bdczxmid", bdczxmid);
		setAttr("zxmmc", zxmmc);
		return "/com/jdk2010/bdc/skqbdcxmmx/skqbdcxmmx_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdcxmmx skqBdcxmmx = getModel(SkqBdcxmmx.class);
		String zxmmc = getPara("zxmmc");
		String bdczxmid = getPara("bdczxmid");
		skqBdcxmmx.setParentid(Integer.parseInt(bdczxmid));
		String xmmc = skqBdcxmmx.getXmmc();
		zxmmc = zxmmc+xmmc;
		skqBdcxmmx.setZxmmc(zxmmc);
		skqBdcxmmxService.update(skqBdcxmmx);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		//判断是否有录入楼牌信息
		String delIds = ids.substring(0, ids.length()-1);
		long num = skqBdcxmmxService.getBdcLpCount(delIds);
		if(num>0){
			ReturnData returnData = new ReturnData(Constants.ERROR, "存在楼牌信息不允许删除");
			renderJson(response,returnData);
		}
		else{
			skqBdcxmmxService.deleteByIDS(ids, SkqBdcxmmx.class);
			ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
			renderJson(response,returnData);
		}
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

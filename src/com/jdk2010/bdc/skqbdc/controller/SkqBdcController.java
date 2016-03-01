package com.jdk2010.bdc.skqbdc.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdc.service.ISkqBdcService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.tools.Constants;

@Controller
@RequestMapping(value = "/skqbdc")
public class SkqBdcController extends BaseController {

	@Resource
	ISkqBdcService skqBdcService;

	@Resource
	ISkqNsrxxService skqNsrxxService;

	@RequestMapping("/init")
	public String init(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/com/jdk2010/bdc/skqbdc/skqbdc_init";
	}

	@RequestMapping("/hqmc")
	public void hqmc(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String keyword = getPara("keyword").trim();
		// System.out.println("keyword==" + keyword);
		List<Map<String, Object>> list = skqBdcService
				.queryForList("select NSRSBH,NSRMC from skq_nsrxx where NSRSBH like '%"
						+ keyword + "%'");

		String str = "";
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Map<String, Object> hm = (Map<String, Object>) it.next();
			str = str + "<div onselect=\"this.text.value = '"
					+ (String) hm.get("nsrsbh") + "'\"><b>"
					+ (String) hm.get("nsrmc") + "</b></div>";
		}
		//System.out.println("str=============="+str);
		renderText(response,str);
	}
	
	@RequestMapping("/checkNsrsbh")
	public void checkNsrsbh(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String nsrsbh = getPara("nsrsbh");
		String nsrwjbm = skqNsrxxService.getNsrwjbmByNsrsbh(nsrsbh);
		if(nsrwjbm==null||"".equals(nsrwjbm)){
			ReturnData returnData = new ReturnData(Constants.ERROR, "查询失败");
			renderJson(response,returnData);
		}
		else{
			ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
			returnData.put("nsrwjbm", nsrwjbm);
			renderJson(response,returnData);
		}		
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nsrsbh = getPara("nsrsbh");
		String nsrwjbm = getPara("nsrwjbm");
		String xmmc = getPara("xmmc");
		String sqlStr = "";
		if(!StringUtil.isBlank(xmmc)){
			sqlStr = " and xmmc like '%"+xmmc+"%'";
		}
		if (!StringUtil.isBlank(nsrsbh)) {
			nsrwjbm = skqNsrxxService.getNsrwjbmByNsrsbh(nsrsbh);
		}
		List<Map<String, Object>> list = skqBdcService.queryForList("select * from skq_bdc  where status=1 and nsrwjbm='"+nsrwjbm+"' "+sqlStr+" order by cjsj desc");

		setAttr("list", list);
		setAttr("nsrwjbm", nsrwjbm);
		setAttr("xmmc", xmmc);
		return "/com/jdk2010/bdc/skqbdc/skqbdc";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		
		setAttr("nsrwjbm", nsrwjbm);
		return "/com/jdk2010/bdc/skqbdc/skqbdc_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdc skqBdc = getModel(SkqBdc.class);
		SecurityUser user = getSessionAttr("securityUser");
		
		skqBdc.setSwjgbm(user.getOrganizationCode());
		skqBdc.setCjz(user.getUsername());
		skqBdc.setCjsj(new Date());
		skqBdc.setStatus(1);
		skqBdcService.save(skqBdc);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqBdc skqBdc = skqBdcService.findById(id, SkqBdc.class);
		setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdc/skqbdc_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqBdc skqBdc = getModel(SkqBdc.class);
		skqBdc.setCjsj(new Date());
		skqBdcService.update(skqBdc);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqBdcService.deleteByIDS(ids, SkqBdc.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response,returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqBdc skqBdc = skqBdcService.findById(id, SkqBdc.class);
		setAttr("skqBdc", skqBdc);
		return "/com/jdk2010/bdc/skqbdc/skqbdc_view";
	}

}

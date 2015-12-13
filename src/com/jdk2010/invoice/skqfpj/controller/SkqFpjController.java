package com.jdk2010.invoice.skqfpj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.util.Constants;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;
import com.jdk2010.invoice.skqfpjmx.service.ISkqFpjmxService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;

@Controller
@RequestMapping(value = "/skqfpj")
public class SkqFpjController extends BaseController {

	@Resource
	ISkqFpjService skqFpjService;

	@Resource
	ISkqFpjmxService skqFpjmxService;

	@Resource
	ISkqNsrxxService skqNsrxxService;

	@Resource
	ISkqJqxxService skqJqxxService;

	@Resource
	DalClient dalClient;

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
		String nsrwjbm=getPara("nsrwjbm");
		String jqbh=getPara("jqbh");
		SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
		SkqJqxx jqxx = skqJqxxService.getJqxxByJqbh(jqbh);
		setAttr("nsrxx", nsrxx);
		setAttr("jqxx", jqxx);
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

	@RequestMapping("/toFpgm")
	public String toFpgm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/invoice/invoice";
	}

	@RequestMapping("/info")
	public String info(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HashMap CARDINFO = (HashMap) getSessionAttr("UCARDINFO");
		if (CARDINFO == null || CARDINFO.isEmpty()) {
			request.setAttribute("errorMsg", "基础信息读取失败！");
			return "/cxtj/error";
		} else {
			HashMap kxx = (HashMap) CARDINFO.get("EF02");
			HashMap EF06 = (HashMap) CARDINFO.get("EF06");
			String jqbh = (String) EF06.get("JQBH");
			ArrayList cardInvoice = (ArrayList) CARDINFO.get("EF05");
			String card_nsrwjbm = (String) kxx.get("NSRWJDM");
			SkqJqxx jqxx = dalClient.queryForObject(
					"select * from skq_jqxx where nsrwjbm='" + card_nsrwjbm
					+ "' and jqbh='" + jqbh + "'", SkqJqxx.class);
			if (jqxx == null) {
				request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为："
						+ card_nsrwjbm + ",机器编号为：" + jqxx);
				return "/cxtj/error";
			} else {
				if (jqxx.getStatus() != 1) {
					request.setAttribute("errorMsg", "机器已经注销！");
					return "/cxtj/error";
				}
				setSessionAttr("cardInvoice", cardInvoice);
				return FORWARD + "/skqfpj/fpList.htm?jqbh=" + jqbh
						+ "&nsrwjbm=" + card_nsrwjbm;

			}

		}

	}

	@RequestMapping("/testInvoice")
	public String testInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap UCARDINFO = new HashMap();
		HashMap EF02 = new HashMap();
		HashMap EF06 = new HashMap();

		ArrayList EF05 =new ArrayList();
		HashMap map1=new HashMap();
		map1.put("QSH","1");
		map1.put("JZH","200");
		map1.put("FPDM","132000000001");
		map1.put("JS", "1");
		EF05.add(map1);
		EF06.put("JQBH", "123456");
		EF02.put("NSRWJDM", "3204820824324234");

		UCARDINFO.put("EF02", EF02);
		UCARDINFO.put("EF06", EF06);
		UCARDINFO.put("EF05", EF05);
		setSessionAttr("UCARDINFO", UCARDINFO);
		return FORWARD + "/skqfpj/info.htm";
	}

	@RequestMapping("/fpList")
	public String fpList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String jqbh = request.getParameter("jqbh");
		String nsrwjbm = request.getParameter("nsrwjbm");
		SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
		SkqJqxx jqxx = skqJqxxService.getJqxxByJqbh(jqbh);
		setAttr("nsrxx", nsrxx);
		setAttr("jqxx", jqxx);
		List<SkqFpjmx> alFp = skqFpjService.selectFpxf(nsrwjbm);
		setAttr("alFp", alFp);
		return "/invoice/invoice.list";
	}






}

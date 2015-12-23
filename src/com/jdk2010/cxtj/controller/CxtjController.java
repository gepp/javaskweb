package com.jdk2010.cxtj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.framework.controller.BaseController;

@Controller
@RequestMapping(value = "/cxtj")
public class CxtjController extends BaseController {

	@RequestMapping("/toYhkImport")
	public String toYhkImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/cxtj/cx.yhk";
	}

	@RequestMapping("/toYhkInfo")
	public String toYhkInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap UCARDINFO = (HashMap) request.getSession().getAttribute(
				"UCARDINFO");
		if (UCARDINFO == null || UCARDINFO.isEmpty()) {
			request.setAttribute("errorMsg", "基础信息读取失败！");
			return "/cxtj/error";
		} else {
			request.setAttribute("CARDINFO", UCARDINFO);
			return "/cxtj/cx.yhk.show";
		}
	}

	@RequestMapping("/toSkkImport")
	public String toSkkImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/cxtj/cx.skk";
	}

	@RequestMapping("/toSkkInfo")
	public String toSkkInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap CARDINFO = (HashMap) request.getSession().getAttribute(
				"FCARDINFO");
		System.out.println("CARDINFO==" + CARDINFO);
		String yhswjgbmStr = (String) request.getSession().getAttribute(
				"yhswjgbmStr");
		// System.out.println("CARDINFO==="+CARDINFO);
		if (CARDINFO == null || CARDINFO.isEmpty()) {
			request.setAttribute("errorMsg", "基础信息读取失败！");
			return "/cxtj/error";
		} else {
			request.setAttribute("CARDINFO", CARDINFO);
			return "/cxtj/cx.skk.show";
		}
	}
	
	@RequestMapping("/toSkkFz")
	public String toSkkFz(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/cxtj/skk.fz";
	}
	
	@RequestMapping("/toSkkFzTop")
	public String toSkkFzTop(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/cxtj/skk.fz.top";
	}
	
	@RequestMapping("/toSkkFzList")
	public String toSkkFzList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/cxtj/skk.fz.list";
	}
	
}

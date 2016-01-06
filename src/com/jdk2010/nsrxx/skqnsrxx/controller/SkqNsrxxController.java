package com.jdk2010.nsrxx.skqnsrxx.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.JsonUtil;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrszsm.service.ISkqNsrszsmService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.tools.Constants;
import com.jdk2010.tools.ExcelUtil;

@Controller
@RequestMapping(value = "/skqnsrxx")
public class SkqNsrxxController extends BaseController {

	@Resource
	ISkqNsrxxService skqNsrxxService;

	@Resource
	ISkqNsrszsmService skqNsrszsmService;

	@Resource
	DalClient dalClient;

	@Resource
	ISecurityOrganizationService securityOrganizationService;

	@RequestMapping("/listImport")
	public String listImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String sql = "select t.*,a.name as organizationName from skq_nsrxx t left join security_organization a on t.swjgbm=a.code where 1=1  ";
		DbKit dbKit = new DbKit(sql);
		String searchSQL = "";
		String orderSQL = "";

		String NSRSBH = getPara("NSRSBH");
		if (NSRSBH != null && !"".equals(NSRSBH)) {
			searchSQL = searchSQL + " and  t.NSRSBH like :nsrsbh";
			setAttr("NSRSBH", NSRSBH);
			dbKit.put("nsrsbh", NSRSBH + "%");
		}

		String NSRMC = getPara("NSRMC");

		if (NSRMC != null && !"".equals(NSRMC)) {
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				NSRMC = new String(NSRMC.getBytes("iso8859-1"), "utf-8");
			}
			searchSQL = searchSQL + " and  t.NSRMC like :nsrmc";
			setAttr("NSRMC", NSRMC);
			dbKit.put("nsrmc", "%" + NSRMC + "%");
		}
		String SWJGBM = getPara("SWJGBM");
		if (SWJGBM != null && !"".equals(SWJGBM)) {
			Long pid = dalClient.queryColumn(
					"select id from security_organization where code='"
							+ SWJGBM + "'", "id");
			searchSQL = searchSQL
					+ " and  t.SWJGBM in ("
					+ securityOrganizationService
							.getOrganizationListStrByParentId(pid + "") + ")";
			setAttr("SWJGBM", SWJGBM);
			String parentName = getPara("parentName");
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				parentName = new String(parentName.getBytes("iso8859-1"),
						"utf-8");
			}
			setAttr("parentName", parentName);

		}

		else {
			SecurityUser securityUser = getSessionAttr("securityUser");
			String username = securityUser.getUsername();
			if (!"system".equals(username)) {
				searchSQL = searchSQL + " and  t.SWJGBM ='"
						+ getSessionAttr("securityUserSwjgbm") + "'";
				setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
				setAttr("parentName", getSessionAttr("securityUserSwjgName"));
			}
		}

		dbKit.append(orderSQL);
		dbKit.append(searchSQL);
		Page pageList = skqNsrxxService.queryForPageList(dbKit, getPage(),
				SkqNsrxx.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx";
	}

	@RequestMapping("/listHandler")
	public String listHandler(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx";
	}

	@RequestMapping("/listcxtjImport")
	public String listcxtjImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxxcxtj";
	}

	@RequestMapping("/listcxtj")
	public String listcxtj(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sql = "select t.*,a.name as organizationName from skq_nsrxx t left join security_organization a on t.swjgbm=a.code where 1=1 ";
		DbKit dbKit = new DbKit(sql);
		String searchSQL = "";
		String orderSQL = "";

		String NSRSBH = getPara("NSRSBH");
		if (NSRSBH != null && !"".equals(NSRSBH)) {
			searchSQL = searchSQL + " and  t.NSRSBH like :nsrsbh";
			setAttr("NSRSBH", NSRSBH);
			dbKit.put("nsrsbh", NSRSBH + "%");
		}

		String NSRMC = getPara("NSRMC");
		if (NSRMC != null && !"".equals(NSRMC)) {
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				NSRMC = new String(NSRMC.getBytes("iso8859-1"), "utf-8");
			}
			searchSQL = searchSQL + " and  t.NSRMC like :nsrmc";
			setAttr("NSRMC", NSRMC);
			dbKit.put("nsrmc", "%" + NSRMC + "%");
		}

		String SWJGBM = getPara("SWJGBM");
		if (SWJGBM != null && !"".equals(SWJGBM)) {
			Long pid = dalClient.queryColumn(
					"select id from security_organization where code='"
							+ SWJGBM + "'", "id");
			searchSQL = searchSQL
					+ " and  t.SWJGBM in ("
					+ securityOrganizationService
							.getOrganizationListStrByParentId(pid + "") + ")";
			setAttr("SWJGBM", SWJGBM);
			String parentName = getPara("parentName");
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				parentName = new String(parentName.getBytes("iso8859-1"),
						"utf-8");
			}
			setAttr("parentName", parentName);

		} else {
			SecurityUser securityUser = getSessionAttr("securityUser");
			String username = securityUser.getUsername();
			if (!"system".equals(username)) {
				searchSQL = searchSQL + " and  t.SWJGBM ='"
						+ getSessionAttr("securityUserSwjgbm") + "'";
				setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
				setAttr("parentName", getSessionAttr("securityUserSwjgName"));
			}

		}

		dbKit.append(orderSQL);
		dbKit.append(searchSQL);
		Page pageList = skqNsrxxService.queryForPageList(dbKit, getPage(),
				SkqNsrxx.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxxcxtj";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqNsrxx skqNsrxx = getModel(SkqNsrxx.class);
		String nsrsbh = skqNsrxx.getNsrsbh();
		String nsrwjbm = "0" + DateUtil.getNowTime("yyyyMMddHHmmss");
		skqNsrxx.setNsrwjbm(nsrwjbm);
		skqNsrxxService.save(skqNsrxx);
		String hiddenStr = getPara("hiddenStr");
		for (int i = 0; i < hiddenStr.split("~").length; i++) {
			String jsonStr = hiddenStr.split("~")[i];
			if (StringUtil.isNotBlank(jsonStr)) {
				jsonStr = jsonStr.replaceAll("“", "\"");
				Map<String, Object> nsrszsmMap = JsonUtil.jsonToMap(jsonStr);
				SkqNsrszsm nsrszsm = new SkqNsrszsm();
				nsrszsm.setNsrwjbm(skqNsrxx.getNsrwjbm());
				nsrszsm.setSl(Double.parseDouble("" + nsrszsmMap.get("sl")));
				nsrszsm.setSmbm("" + nsrszsmMap.get("smbm"));
				nsrszsm.setSmjc("" + nsrszsmMap.get("smjc"));
				nsrszsm.setSmmc("" + nsrszsmMap.get("smmc"));
				nsrszsm.setStatus(1);
				nsrszsm.setSzbm("" + nsrszsmMap.get("szbm"));
				skqNsrszsmService.save(nsrszsm);
			}
		}
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
		List<SkqNsrszsm> nsrszsmList = skqNsrxx.getNsrszsmList();
		setAttr("nsrszsmList", nsrszsmList);
		String hiddenStr = "";
		String smbms = ",";
		for (int i = 0; i < nsrszsmList.size(); i++) {
			hiddenStr = hiddenStr + "~" + JsonUtil.toJson(nsrszsmList.get(i));
			smbms = smbms + nsrszsmList.get(i).getSmbm() + ",";
		}
		setAttr("hiddenStr", hiddenStr);
		setAttr("smbms", smbms);

		setAttr("skqNsrxx", skqNsrxx);
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqNsrxx skqNsrxx = getModel(SkqNsrxx.class);
		String swjgbm = getPara("skqNsrxx.swjgbm");
		skqNsrxx.setSwjgbm(swjgbm);
		skqNsrxxService.update(skqNsrxx);
		skqNsrszsmService.deleteNsrszsmByNsrwjbm(skqNsrxx.getNsrwjbm());
		String hiddenStr = getPara("hiddenStr");
		for (int i = 0; i < hiddenStr.split("~").length; i++) {
			String jsonStr = hiddenStr.split("~")[i];
			if (StringUtil.isNotBlank(jsonStr)) {
				jsonStr = jsonStr.replaceAll("“", "\"");
				Map<String, Object> nsrszsmMap = JsonUtil.jsonToMap(jsonStr);
				SkqNsrszsm nsrszsm = new SkqNsrszsm();
				nsrszsm.setNsrwjbm(skqNsrxx.getNsrwjbm());
				nsrszsm.setSl(Double.parseDouble("" + nsrszsmMap.get("sl")));
				nsrszsm.setSmbm("" + nsrszsmMap.get("smbm"));
				nsrszsm.setSmjc("" + nsrszsmMap.get("smjc"));
				nsrszsm.setSmmc("" + nsrszsmMap.get("smmc"));
				nsrszsm.setStatus(1);
				nsrszsm.setSzbm("" + nsrszsmMap.get("szbm"));
				skqNsrszsmService.save(nsrszsm);
			}
		}

		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqNsrxxService.deleteByIDS(ids, SkqNsrxx.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		SkqNsrxx skqNsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
		List<SkqNsrszsm> nsrszsmList = skqNsrxx.getNsrszsmList();
		setAttr("nsrszsmList", nsrszsmList);
		String hiddenStr = "";
		String smbms = ",";
		for (int i = 0; i < nsrszsmList.size(); i++) {
			hiddenStr = hiddenStr + "~" + JsonUtil.toJson(nsrszsmList.get(i));
			smbms = smbms + nsrszsmList.get(i).getSmbm() + ",";
		}
		setAttr("hiddenStr", hiddenStr);
		setAttr("smbms", smbms);
		setAttr("skqNsrxx", skqNsrxx);
		String sql = "select a.*,b.FPMC from SKQ_FPJMX a left outer join SKQ_FP b on a.FPBM=b.FPBM where a.NSRWJBM='"
				+ nsrwjbm + "' order by FPXFZT ASC,FPLGRQ DESC";
		List<Map<String, Object>> alFpjmx = skqNsrxxService.queryForList(sql);
		setAttr("alFpjmx", alFpjmx);
		return "/com/jdk2010/nsrxx/skqnsrxx/skqnsrxx_view";
	}

	@RequestMapping("/check")
	public void check(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nsrsbh = getPara("skqNsrxx.nsrsbh");
		boolean isExist = skqNsrxxService.isExistsNsrwjbm(nsrsbh);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (isExist) {
			returnMap.put("error", "纳税人识别号已存在");
		} else {
			returnMap.put("ok", "纳税人识别号可以使用");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", returnMap);
		renderJson(response, map);
	}

	@RequestMapping("/deleteNsrxx")
	public void deleteNsrxx(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nsrwjbm = getPara("nsrwjbm");
		dalClient.update("delete from skq_nsrxx where nsrwjbm='" + nsrwjbm
				+ "'");
		dalClient.update("delete from skq_nsrszsm where nsrwjbm='" + nsrwjbm
				+ "'");
		dalClient
				.update("delete from skq_jqxx where nsrwjbm='" + nsrwjbm + "'");
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sql = "select t.*,a.name as organizationName from skq_nsrxx t left join security_organization a on t.swjgbm=a.code where 1=1 ";
		DbKit dbKit = new DbKit(sql);
		String searchSQL = "";
		String orderSQL = "";

		String NSRSBH = getPara("NSRSBH");
		if (NSRSBH != null && !"".equals(NSRSBH)) {
			searchSQL = searchSQL + " and  t.NSRSBH like :nsrsbh";
			setAttr("NSRSBH", NSRSBH);
			dbKit.put("nsrsbh", NSRSBH + "%");
		}

		String NSRMC = getPara("NSRMC");
		if (NSRMC != null && !"".equals(NSRMC)) {
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				NSRMC = new String(NSRMC.getBytes("iso8859-1"), "utf-8");
			}
			searchSQL = searchSQL + " and  t.NSRMC like :nsrmc";
			setAttr("NSRMC", NSRMC);
			dbKit.put("nsrmc", "%" + NSRMC + "%");
		}

		String SWJGBM = getPara("SWJGBM");
		if (SWJGBM != null && !"".equals(SWJGBM)) {
			Long pid = dalClient.queryColumn(
					"select id from security_organization where code='"
							+ SWJGBM + "'", "id");
			searchSQL = searchSQL
					+ " and  t.SWJGBM in ("
					+ securityOrganizationService
							.getOrganizationListStrByParentId(pid + "") + ")";
			setAttr("SWJGBM", SWJGBM);
			String parentName = getPara("parentName");
			if(parentName!=null){
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				parentName = new String(parentName.getBytes("iso8859-1"),
						"utf-8");
			}
			}
			setAttr("parentName", parentName);

		} else {
			SecurityUser securityUser = getSessionAttr("securityUser");
			String username = securityUser.getUsername();
			if (!"system".equals(username)) {
				searchSQL = searchSQL + " and  t.SWJGBM ='"
						+ getSessionAttr("securityUserSwjgbm") + "'";
				setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
				setAttr("parentName", getSessionAttr("securityUserSwjgName"));
			}

		}

		dbKit.append(orderSQL);
		dbKit.append(searchSQL);
		List<SkqNsrxx> pageList = skqNsrxxService.queryForList(dbKit,
				SkqNsrxx.class);
		List<Map<String, Object>> list = createExcelRecord(pageList);
		String columnNames[] = { "纳税人微机编码", "纳税人识别号", "纳税人名称", "税务机关" };// 列名
		String keys[] = { "nsrwjbm", "nsrsbh", "nsrmc", "swjgmc"};// map中的key
		String fileName="纳税户信息";
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	private List<Map<String, Object>> createExcelRecord(List<SkqNsrxx> nsrxxList) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		for (SkqNsrxx nsrxx : nsrxxList) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("nsrwjbm", nsrxx.getNsrwjbm());
			mapValue.put("nsrsbh", nsrxx.getNsrsbh());
			mapValue.put("nsrmc", nsrxx.getNsrmc());
			mapValue.put("swjgmc", nsrxx.getOrganizationName());
			listmap.add(mapValue);
		}
		return listmap;
	}

}

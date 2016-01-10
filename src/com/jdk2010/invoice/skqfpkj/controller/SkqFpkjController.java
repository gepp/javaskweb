package com.jdk2010.invoice.skqfpkj.controller;
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
import com.jdk2010.invoice.skqfpkj.model.SkqFpkj;
import com.jdk2010.invoice.skqfpkj.service.ISkqFpkjService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.tools.Constants;
import com.jdk2010.tools.ExcelUtil;
import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.DbKit;
@Controller
@RequestMapping(value="/skqfpkj")
public class SkqFpkjController extends BaseController{
	
	@Resource
	ISkqFpkjService skqFpkjService;
	
	@Resource
	DalClient dalClient;
	
	@Resource
	ISecurityOrganizationService securityOrganizationService;
	
	@RequestMapping("/listImport")
	public String  listImport(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 
		 return "/com/jdk2010/invoice/skqfpkj/skqfpkj";
	}
	
	@RequestMapping("/list")
	public String  list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select t.*,a.nsrsbh,a.nsrmc from skq_fpkj t inner join skq_nsrxx a on t.nsrwjbm=a.nsrwjbm  where t.status=1 ");
		 String searchSQL="";
		String orderSQL="";
		String NSRSBH = getPara("NSRSBH");
        if (NSRSBH != null && !"".equals(NSRSBH)) {
        	String nsrwjbm=dalClient.queryColumn("select nsrwjbm from skq_nsrxx where nsrsbh='"+NSRSBH+"'","nsrwjbm");
            searchSQL = searchSQL + " and  t.NSRWJBM ='"+nsrwjbm+"'";
            setAttr("NSRSBH", NSRSBH);
        }
        
        String NSRMC = getPara("NSRMC");

		if (NSRMC != null && !"".equals(NSRMC)) {
			if (getRequest().getMethod().equalsIgnoreCase("get")) {
				NSRMC = new String(NSRMC.getBytes("iso8859-1"), "utf-8");
			}
			searchSQL = searchSQL + " and  a.NSRMC like :nsrmc";
			setAttr("NSRMC", NSRMC);
			dbKit.put("nsrmc", "%" + NSRMC + "%");
		}

		

		String startTime = getPara("startTime");
		if (startTime != null && !"".equals(startTime)) {
			searchSQL = searchSQL + " and  t.KPRQ>='" + startTime
					+ " 00:00:00'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  t.KPRQ<='" + endTime + " 23:59:59'";
			setAttr("endTime", endTime);
		}

		String SWJGBM = getPara("SWJGBM");
		 if (SWJGBM != null && !"".equals(SWJGBM)) {
			 Long pid=dalClient.queryColumn("select id from security_organization where code='"+SWJGBM+"'","id");
	            searchSQL = searchSQL + " and  a.SWJGBM in (" +securityOrganizationService.getOrganizationListStrByParentId(pid+"")+ ")";
	            setAttr("SWJGBM", SWJGBM);
	            String parentName=getPara("parentName");
	            if(getRequest().getMethod().equalsIgnoreCase("get")){
	            	parentName=new String(parentName.getBytes("iso8859-1"),"utf-8");
	           }
	            setAttr("parentName", parentName);
	            
	        }

		dbKit.append(searchSQL);
		
		dbKit.append(orderSQL);
		 Page pageList=skqFpkjService.queryForPageList(dbKit, getPage(),SkqFpkj.class);
		 setAttr("pageList", pageList);
		 return "/com/jdk2010/invoice/skqfpkj/skqfpkj";
	}

	@RequestMapping("/add")
	public String  add(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_add";
	}
	@RequestMapping("/addaction")
	public void  addaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkj skqFpkj=getModel(SkqFpkj.class);
  		skqFpkjService.save(skqFpkj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	
	@RequestMapping("/modify")
	public String  modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkj skqFpkj=skqFpkjService.findById(id, SkqFpkj.class);
					 setAttr("skqFpkj", skqFpkj);
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_modify";
	}
	@RequestMapping("/modifyaction")
	public void  modifyaction(HttpServletRequest request,HttpServletResponse response) throws Exception {
 		SkqFpkj skqFpkj=getModel(SkqFpkj.class);
  		skqFpkjService.update(skqFpkj);
 		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/delete")
	public void  delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String ids=getPara("ids");
		skqFpkjService.deleteByIDS(ids,SkqFpkj.class);
		ReturnData returnData=new ReturnData(Constants.SUCCESS,"操作成功");
		renderJson(response,returnData);
	}
	
	@RequestMapping("/view")
	public String  view(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id=getPara("id");
		SkqFpkj skqFpkj=skqFpkjService.findById(id, SkqFpkj.class);
					 setAttr("skqFpkj", skqFpkj);
		return "/com/jdk2010/invoice/skqfpkj/skqfpkj_view";
	}
	
	
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 DbKit dbKit=new DbKit("select t.*,a.nsrsbh,a.nsrmc from skq_fpkj t inner join skq_nsrxx a on t.nsrwjbm=a.nsrwjbm  where t.status=1 ");
		 
		String searchSQL = "";
		String orderSQL = "";

 		String NSRSBH = getPara("NSRSBH");
        if (NSRSBH != null && !"".equals(NSRSBH)) {
        	String nsrwjbm=dalClient.queryColumn("select nsrwjbm from skq_nsrxx where nsrsbh='"+NSRSBH+"'","nsrwjbm");
            searchSQL = searchSQL + " and  t.NSRWJBM ='"+nsrwjbm+"'";
            setAttr("NSRSBH", NSRSBH);
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
					+ " and  a.SWJGBM in ("
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
				searchSQL = searchSQL + " and  a.SWJGBM ='"
						+ getSessionAttr("securityUserSwjgbm") + "'";
				setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
				setAttr("parentName", getSessionAttr("securityUserSwjgName"));
			}

		}
		
		
		String startTime = getPara("startTime");
		if (startTime != null && !"".equals(startTime)) {
			searchSQL = searchSQL + " and  KPRQ>='" + startTime
					+ " 00:00:00'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  KPRQ<='" + endTime + " 23:59:59'";
			setAttr("endTime", endTime);
		}
		
		

		dbKit.append(orderSQL);
		dbKit.append(searchSQL);
		List<SkqFpkj> pageList = skqFpkjService.queryForList(dbKit,
				SkqFpkj.class);
		List<Map<String, Object>> list = createExcelRecord(pageList);
		String columnNames[] = { "纳税人识别号", "纳税人名称", "机器编号","开票日期","开票类型","发票代码","发票号码","开票金额","原发票号码","付款单位"};// 列名
		String keys[] = { "nsrsbh", "nsrmc", "jqbh","kprq","kplx","fpdm","fphm","kpje","yfphm","fkdw"};// map中的key
		String fileName="发票开具信息";
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

	private List<Map<String, Object>> createExcelRecord(List<SkqFpkj> nsrxxList) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		for (SkqFpkj fpkj : nsrxxList) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
 			mapValue.put("nsrsbh", fpkj.getNsrsbh());
			mapValue.put("nsrmc", fpkj.getNsrmc());
			mapValue.put("jqbh", fpkj.getJqbh());
			Integer kplx=fpkj.getKplx();
			String kplxStr="";
			if(kplx==1){
				kplxStr="正常票";
			}else if(kplx==2){
				kplxStr="退票";
			}
			else if(kplx==3){
				kplxStr="费票";
			}
			mapValue.put("kplx", kplxStr);
			mapValue.put("fpdm", fpkj.getFpdm());
			mapValue.put("fphm", fpkj.getFphm());
			mapValue.put("kpje", fpkj.getHjzje());
			mapValue.put("yfphm", fpkj.getYfphm());
			mapValue.put("fkdw", fpkj.getFkdw());
			mapValue.put("kprq", DateUtil.formatDateTime(fpkj.getKprq(),"yyyy-MM-dd"));
			
			listmap.add(mapValue);
		}
		return listmap;
	}
	
}

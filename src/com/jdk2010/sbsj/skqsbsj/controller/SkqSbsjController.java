package com.jdk2010.sbsj.skqsbsj.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.securityorganization.service.ISecurityOrganizationService;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.sbsj.skqhzsj.model.SkqHzsj;
import com.jdk2010.sbsj.skqsbsj.model.SkqSbsj;
import com.jdk2010.sbsj.skqsbsj.service.ISkqSbsjService;
import com.jdk2010.system.skqpmsz.service.ISkqPmszService;
import com.jdk2010.tools.Constants;
import com.jdk2010.tools.ExcelUtil;
import com.jdk2010.tools.Util;

@Controller
@RequestMapping(value = "/skqsbsj")
public class SkqSbsjController extends BaseController {

	@Resource
	ISkqSbsjService skqSbsjService;

	@Resource
	ISkqNsrxxService skqNsrxxService;

	@Resource
	ISkqJqxxService skqJqxxService;

	@Resource
	DalClient dalClient;

	@Resource
	ISkqPmszService skqPmszService;

	@Resource
	ISecurityOrganizationService securityOrganizationService;

	@RequestMapping("/listImport")
	public String listImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DbKit dbKit = new DbKit(
				"select t.*,a.nsrsbh,a.nsrmc from skq_sbsj  t inner JOIN skq_nsrxx a ON t.nsrwjbm=a.nsrwjbm inner JOIN security_organization b ON a.swjgbm=b.code  ");
		String searchSQL = "";
		String NSRSBH = getPara("NSRSBH");
		if (NSRSBH != null && !"".equals(NSRSBH)) {
			String nsrwjbm = dalClient.queryColumn(
					"select nsrwjbm from skq_nsrxx where nsrsbh='" + NSRSBH
							+ "'", "nsrwjbm");
			searchSQL = searchSQL + " and  t.NSRWJBM ='" + nsrwjbm + "'";
			setAttr("NSRSBH", NSRSBH);
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
		else{
		    SecurityUser securityUser=getSessionAttr("securityUser");
            String username=securityUser.getUsername();
            if(!"system".equals(username)){
                searchSQL = searchSQL + " and  SWJGBM ='" + getSessionAttr("securityUserSwjgbm") + "'";
                setAttr("SWJGBM", getSessionAttr("securityUserSwjgbm"));
                setAttr("parentName", getSessionAttr("securityUserSwjgName"));
            }
        }

		String JQBH = getPara("JQBH");
		if (JQBH != null && !"".equals(JQBH)) {
			searchSQL = searchSQL + " and  t.JQBH =:jqbh";
			setAttr("JQBH", JQBH);
			dbKit.put("jqbh", JQBH);
		}

		String startTime = getPara("startTime");
		if (startTime != null && !"".equals(startTime)) {
			searchSQL = searchSQL + " and  t.SSKSSJ>='" + startTime
					+ " 00:00:00'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  t.SSJZSJ<='" + endTime
					+ " 23:59:59'";
			setAttr("endTime", endTime);
		}
		dbKit.append(searchSQL);
		Page pageList = skqSbsjService.queryForPageList(dbKit, getPage(),
				SkqSbsj.class);
		setAttr("pageList", pageList);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_add";
	}

	@RequestMapping("/addaction")
	public void addaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqSbsj skqSbsj = getModel(SkqSbsj.class);
		skqSbsjService.save(skqSbsj);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = getPara("id");
		SkqSbsj skqSbsj = skqSbsjService.findById(id, SkqSbsj.class);
		setAttr("skqSbsj", skqSbsj);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_modify";
	}

	@RequestMapping("/modifyaction")
	public void modifyaction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SkqSbsj skqSbsj = getModel(SkqSbsj.class);
		skqSbsjService.update(skqSbsj);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = getPara("ids");
		skqSbsjService.deleteByIDS(ids, SkqSbsj.class);
		ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
		renderJson(response, returnData);
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = getPara("id");
		SkqSbsj skqSbsj = skqSbsjService.findById(id, SkqSbsj.class);
		setAttr("skqSbsj", skqSbsj);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_view";
	}

	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/sbsj/sbsj";
	}

	@RequestMapping("/toZrysb")
	public String toZrysb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/sbsj/sbsj";
	}

	@RequestMapping("/toJdsb")
	public String toJdsb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/sbsj/jdsb";
	}

	@RequestMapping("/toJkhc")
	public String toJkhc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/sbsj/jkhc";
	}

	@RequestMapping("/jdsbsjdk")
	public String jdsbsjdk(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String nsrwjbm = "";
		String kpjzrq = "";
		HashMap sbinfo = new HashMap();
		DecimalFormat dg = new DecimalFormat("0.00");
		HashMap cardInfo = new HashMap();
		String sccs = getPara("sccs");
		if("001".equals(sccs)){
			cardInfo = (HashMap) session.getAttribute("UCARDINFO");
		}
		else{
			HashMap EF06 = new HashMap();
			HashMap EF02 = new HashMap();
			HashMap EF04 = new HashMap();
			String JQBH_DSF = getPara("jqbh");
			String dkxx = new String(getPara("dkxx").getBytes("iso8859-1"),"utf-8");
			EF06.put("JQBH", JQBH_DSF);			
			
			String[] dkxx_arr = dkxx.split("\\^");
			System.out.println("dkxx_arr=="+dkxx_arr);
			System.out.println("dkxx=="+dkxx);
			System.out.println("startdate=="+dkxx_arr[4]);
			System.out.println("enddate=="+dkxx_arr[5]);
			EF02.put("NSRWJDM", dkxx_arr[0]);
			sbinfo.put("NSRWJDM", dkxx_arr[0]);
			sbinfo.put("fiscalno", dkxx_arr[1]);
			sbinfo.put("SKSKJJQBH", dkxx_arr[2]);
			sbinfo.put("NSRMC", dkxx_arr[3]);
			sbinfo.put("startdate", dkxx_arr[4]);
			sbinfo.put("enddate", dkxx_arr[5]);
			sbinfo.put("normalcnt", dkxx_arr[6]);
			sbinfo.put("backcnt", dkxx_arr[7]);
			sbinfo.put("deposecnt", dkxx_arr[8]);
			sbinfo.put("normalsum1", String.valueOf(Double.parseDouble(dkxx_arr[9])*100));
			sbinfo.put("normalsum2", String.valueOf(Double.parseDouble(dkxx_arr[10])*100));
			sbinfo.put("normalsum3", String.valueOf(Double.parseDouble(dkxx_arr[11])*100));
			sbinfo.put("normalsum4", String.valueOf(Double.parseDouble(dkxx_arr[12])*100));
			sbinfo.put("normalsum5", String.valueOf(Double.parseDouble(dkxx_arr[13])*100));
			sbinfo.put("normalsum6", String.valueOf(Double.parseDouble(dkxx_arr[14])*100));
			sbinfo.put("backsum1", String.valueOf(Double.parseDouble(dkxx_arr[15])*100));
			sbinfo.put("backsum2", String.valueOf(Double.parseDouble(dkxx_arr[16])*100));
			sbinfo.put("backsum3", String.valueOf(Double.parseDouble(dkxx_arr[17])*100));
			sbinfo.put("backsum4", String.valueOf(Double.parseDouble(dkxx_arr[18])*100));
			sbinfo.put("backsum5", String.valueOf(Double.parseDouble(dkxx_arr[19])*100));
			sbinfo.put("backsum6", String.valueOf(Double.parseDouble(dkxx_arr[20])*100));
			sbinfo.put("mac", dkxx_arr[21]);
			
			//String sql = "update SKQ_JQXX set MAC='"+dkxx_arr[21]+"' where JQBH='"+JQBH_DSF+"'";
			//dalClient.update(sql);
			
			session.setAttribute("mac_st", dkxx_arr[21]);
			
			String sql = "select SMSY from SKQ_PMSZ where SMBM in(select SMBM from SKQ_JQSZSM where JQBH='"+JQBH_DSF+"')";
			List<Map<String,Object>> list = dalClient.queryForObjectList(sql);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					Map<String,Object> map = list.get(i);
					String smsy = (Integer)map.get("SMSY")+"";
					
					int num = i+1;
					sbinfo.put("index"+num, smsy);
				}
			}
			
			//EF04.put("sbinfo", sbinfo);
			
			cardInfo.put("EF04", sbinfo);
			cardInfo.put("EF06", EF06);
			cardInfo.put("EF02", EF02);
			
			session.setAttribute("UCARDINFO", cardInfo);
		}
		if (cardInfo == null || cardInfo.isEmpty()) {
			request.setAttribute("errorMsg", "卡基本信息读取失败，请检查！");
			return "/cxtj/error";
		} else {
			SkqNsrxx nsrxx = null;
			HashMap kxx = (HashMap) cardInfo.get("EF02");
			HashMap EF01 = (HashMap) cardInfo.get("EF01");
			HashMap EF06 = (HashMap) cardInfo.get("EF06");
			String jqbh = (String) EF06.get("JQBH");
			String card_nsrwjbm = (String) kxx.get("NSRWJDM");
			String new_wjbm = dalClient.queryColumn(
					"select NEW_WJBM from skq_wjbmdy where jqbh='" + jqbh
							+ "' and old_wjbm='" + card_nsrwjbm + "'",
					"NEW_WJBM");

			SkqJqxx jqxx = dalClient.queryForObject(
					"select * from skq_jqxx where nsrwjbm='" + new_wjbm
							+ "' and jqbh='" + jqbh + "'", SkqJqxx.class);
			if (jqxx == null) {
				request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为："
						+ card_nsrwjbm + ",机器编号为：" + jqxx);
				return "/cxtj/error";
			} else {
				nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(new_wjbm);
				int status = nsrxx.getStatus();
				if (status != 1) {
					request.setAttribute("errorMsg", "纳税户已注销！");
					return "/cxtj/error";
				} else {
					sbinfo = (HashMap) cardInfo.get("EF04");
					if (sbinfo == null || sbinfo.isEmpty()) {
						request.setAttribute("errorMsg", "无申报，请先在机器上申报！");
						return "/cxtj/error";
					} else {
						String startdate = (String) sbinfo.get("startdate");
						String enddate = (String) sbinfo.get("enddate");

						startdate = startdate.substring(0, 4) + '-'
								+ startdate.substring(4, 6) + '-'
								+ startdate.substring(6, 8);
						enddate = enddate.substring(0, 4) + '-'
								+ enddate.substring(4, 6) + '-'
								+ enddate.substring(6, 8);
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						String sbsjsql = "select * from skq_sbsj "
								+ " where SSKSSJ='" + startdate
								+ "' and SSJZSJ='" + enddate + "' and JQBH='"
								+ jqbh + "'";
						int size = dalClient.queryForObjectList(sbsjsql).size();
						if (size != 0) {
							request.setAttribute("errorMsg", "申报数据已存在，不能重复申报！");
							return "/cxtj/error";
						} else {
							// 保存申报数据
							double normalsum1 = Double
									.parseDouble((String) sbinfo
											.get("normalsum1"));
							normalsum1 = Double.parseDouble(dg
									.format(normalsum1 / 100));

							double normalsum2 = Double
									.parseDouble((String) sbinfo
											.get("normalsum2"));
							normalsum2 = Double.parseDouble(dg
									.format(normalsum2 / 100));

							double normalsum3 = Double
									.parseDouble((String) sbinfo
											.get("normalsum3"));
							normalsum3 = Double.parseDouble(dg
									.format(normalsum3 / 100));

							double normalsum4 = Double
									.parseDouble((String) sbinfo
											.get("normalsum4"));
							normalsum4 = Double.parseDouble(dg
									.format(normalsum4 / 100));

							double normalsum5 = Double
									.parseDouble((String) sbinfo
											.get("normalsum5"));
							normalsum5 = Double.parseDouble(dg
									.format(normalsum5 / 100));

							double normalsum6 = Double
									.parseDouble((String) sbinfo
											.get("normalsum6"));
							normalsum6 = Double.parseDouble(dg
									.format(normalsum6 / 100));

							double backsum1 = Double
									.parseDouble((String) sbinfo
											.get("backsum1"));
							backsum1 = Double.parseDouble(dg
									.format(backsum1 / 100));

							double backsum2 = Double
									.parseDouble((String) sbinfo
											.get("backsum2"));
							backsum2 = Double.parseDouble(dg
									.format(backsum2 / 100));

							double backsum3 = Double
									.parseDouble((String) sbinfo
											.get("backsum3"));
							backsum3 = Double.parseDouble(dg
									.format(backsum3 / 100));

							double backsum4 = Double
									.parseDouble((String) sbinfo
											.get("backsum4"));
							backsum4 = Double.parseDouble(dg
									.format(backsum4 / 100));

							double backsum5 = Double
									.parseDouble((String) sbinfo
											.get("backsum5"));
							backsum5 = Double.parseDouble(dg
									.format(backsum5 / 100));

							double backsum6 = Double
									.parseDouble((String) sbinfo
											.get("backsum6"));
							backsum6 = Double.parseDouble(dg
									.format(backsum6 / 100));

							double normalsum = Double.parseDouble(dg
									.format(normalsum1 + normalsum2
											+ normalsum3 + normalsum4
											+ normalsum5 + normalsum6));

							double backsum = Double.parseDouble(dg
									.format(backsum1 + backsum2 + backsum3
											+ backsum4 + backsum5 + backsum6));
							SkqSbsj sbsj = new SkqSbsj();
							sbsj.setNsrwjbm(new_wjbm);
							sbsj.setJqbh(jqbh);
							sbsj.setZcpfs(Integer.parseInt((String) sbinfo
									.get("normalcnt")));
							sbsj.setTpfs(Integer.parseInt((String) sbinfo
									.get("backcnt")));
							sbsj.setFpfs(Integer.parseInt((String) sbinfo
									.get("deposecnt")));
							sbsj.setSskssj(DateUtil.parse(startdate,
									"yyyy-MM-dd"));
							sbsj.setSsjzsj(DateUtil
									.parse(enddate, "yyyy-MM-dd"));
							sbsj.setZcpzje(normalsum);
							sbsj.setTpzje(backsum);
							sbsj.setSbrq(new Date());
							sbsj.setSblx(2);
							int sid = skqSbsjService.save(sbsj);
							if (sid != 0) {
								ArrayList sbzbxx = new ArrayList();
								if (normalsum1 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index1"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum1);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum2 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index2"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum2);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum3 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index3"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum3);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum4 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index4"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum4);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum5 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index5"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum5);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum6 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index6"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum6);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (backsum1 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index1"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum1 * -1);
									hm.put("kplx", 2);

									sbzbxx.add(hm);
								}
								if (backsum2 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index2"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum2 * -1);
									hm.put("kplx", 2);

									sbzbxx.add(hm);
								}
								if (backsum3 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index3"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum3 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum4 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index4"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum4 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum5 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index5"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum5 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum6 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index6"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum6 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								SkqSbsj skqSbsj = skqSbsjService.findById(sid,
										SkqSbsj.class);
								if (sbzbxx != null && !sbzbxx.isEmpty()) {
									for (int i = 0; i < sbzbxx.size(); i++) {
										HashMap hm = (HashMap) sbzbxx.get(i);
										String sql = "insert into SKQ_SBSJMX(PARENTID,SMBM,JE,KPLX) values("
												+ (Integer) hm.get("parentid")
												+ ",'"
												+ (String) hm.get("smbm")
												+ "',"
												+ (Double) hm.get("je")
												+ ","
												+ (Integer) hm.get("kplx")
												+ ")";
										dalClient.update(sql);
									}
								}
								HashMap hmSb = new HashMap();
								setAttr("nsrxx", nsrxx);
								setAttr("sbsj", sbsj);
								request.setAttribute("hmSb", hmSb);
								return "/sbsj/jdsb.sbxx";

							} else {
								request.setAttribute("errorMsg", "申报数据保存失败！");
								return "/cxtj/error";
							}
						}

					}
				}
			}
		}
	}

	@RequestMapping("/sbsjdk")
	public String sbsjdk(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sccs = getPara("sccs");
		HttpSession session = request.getSession();
		String nsrwjbm = "";
		String kpjzrq = "";
		HashMap sbinfo = new HashMap();
		DecimalFormat dg = new DecimalFormat("0.00");
		HashMap cardInfo = new HashMap();
		if("001".equals(sccs)){
			cardInfo = (HashMap) session.getAttribute("UCARDINFO");
		}
		else{
			HashMap EF06 = new HashMap();
			HashMap EF02 = new HashMap();
			HashMap EF04 = new HashMap();
			String JQBH_DSF = getPara("jqbh");
			String dkxx = new String(getPara("dkxx").getBytes("iso8859-1"),"utf-8");
			EF06.put("JQBH", JQBH_DSF);			
			
			String[] dkxx_arr = dkxx.split("\\^");
			System.out.println("dkxx_arr=="+dkxx_arr);
			System.out.println("dkxx=="+dkxx);
			System.out.println("startdate=="+dkxx_arr[4]);
			System.out.println("enddate=="+dkxx_arr[5]);
			EF02.put("NSRWJDM", dkxx_arr[0]);
			sbinfo.put("NSRWJDM", dkxx_arr[0]);
			sbinfo.put("fiscalno", dkxx_arr[1]);
			sbinfo.put("SKSKJJQBH", dkxx_arr[2]);
			sbinfo.put("NSRMC", dkxx_arr[3]);
			sbinfo.put("startdate", dkxx_arr[4]);
			sbinfo.put("enddate", dkxx_arr[5]);
			sbinfo.put("normalcnt", dkxx_arr[6]);
			sbinfo.put("backcnt", dkxx_arr[7]);
			sbinfo.put("deposecnt", dkxx_arr[8]);
			sbinfo.put("normalsum1", String.valueOf(Double.parseDouble(dkxx_arr[9])*100));
			sbinfo.put("normalsum2", String.valueOf(Double.parseDouble(dkxx_arr[10])*100));
			sbinfo.put("normalsum3", String.valueOf(Double.parseDouble(dkxx_arr[11])*100));
			sbinfo.put("normalsum4", String.valueOf(Double.parseDouble(dkxx_arr[12])*100));
			sbinfo.put("normalsum5", String.valueOf(Double.parseDouble(dkxx_arr[13])*100));
			sbinfo.put("normalsum6", String.valueOf(Double.parseDouble(dkxx_arr[14])*100));
			sbinfo.put("backsum1", String.valueOf(Double.parseDouble(dkxx_arr[15])*100));
			sbinfo.put("backsum2", String.valueOf(Double.parseDouble(dkxx_arr[16])*100));
			sbinfo.put("backsum3", String.valueOf(Double.parseDouble(dkxx_arr[17])*100));
			sbinfo.put("backsum4", String.valueOf(Double.parseDouble(dkxx_arr[18])*100));
			sbinfo.put("backsum5", String.valueOf(Double.parseDouble(dkxx_arr[19])*100));
			sbinfo.put("backsum6", String.valueOf(Double.parseDouble(dkxx_arr[20])*100));
			sbinfo.put("mac", dkxx_arr[21]);
			
			//String sql = "update SKQ_JQXX set MAC='"+dkxx_arr[21]+"' where JQBH='"+JQBH_DSF+"'";
			//dalClient.update(sql);
			
			session.setAttribute("mac_st", dkxx_arr[21]);
			
			String sql = "select SMSY from SKQ_PMSZ where SMBM in(select SMBM from SKQ_JQSZSM where JQBH='"+JQBH_DSF+"')";
			List<Map<String,Object>> list = dalClient.queryForObjectList(sql);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					Map<String,Object> map = list.get(i);
					String smsy = (Integer)map.get("SMSY")+"";
					
					int num = i+1;
					sbinfo.put("index"+num, smsy);
				}
			}
			
			//EF04.put("sbinfo", sbinfo);
			
			cardInfo.put("EF04", sbinfo);
			cardInfo.put("EF06", EF06);
			cardInfo.put("EF02", EF02);
			
			session.setAttribute("UCARDINFO", cardInfo);
		}
		if (cardInfo == null || cardInfo.isEmpty()) {
			request.setAttribute("errorMsg", "卡基本信息读取失败，请检查！");
			return "/cxtj/error";
		} else {
			SkqNsrxx nsrxx = null;
			HashMap kxx = (HashMap) cardInfo.get("EF02");
			HashMap EF01 = (HashMap) cardInfo.get("EF01");
			HashMap EF06 = (HashMap) cardInfo.get("EF06");
			String jqbh = (String) EF06.get("JQBH");
			String card_nsrwjbm = (String) kxx.get("NSRWJDM");
			String new_wjbm = dalClient.queryColumn(
					"select NEW_WJBM from skq_wjbmdy where jqbh='" + jqbh
							+ "' and old_wjbm='" + card_nsrwjbm + "'",
					"NEW_WJBM");

			SkqJqxx jqxx = dalClient.queryForObject(
					"select * from skq_jqxx where nsrwjbm='" + new_wjbm
							+ "' and jqbh='" + jqbh + "'", SkqJqxx.class);
			if (jqxx == null) {
				request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为："
						+ card_nsrwjbm + ",机器编号为：" + jqxx);
				return "/cxtj/error";
			} else {
				nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(new_wjbm);
				int status = nsrxx.getStatus();
				if (status != 1) {
					request.setAttribute("errorMsg", "纳税户已注销！");
					return "/cxtj/error";
				} else {
					sbinfo = (HashMap) cardInfo.get("EF04");

					if (sbinfo == null || sbinfo.isEmpty()) {
						request.setAttribute("errorMsg", "无申报，请先在机器上申报！");
						return "/cxtj/error";
					} else {
						String startdate = (String) sbinfo.get("startdate");
						String enddate = (String) sbinfo.get("enddate");
						startdate = startdate.substring(0, 4) + '-'
								+ startdate.substring(4, 6) + '-'
								+ startdate.substring(6, 8);
						enddate = enddate.substring(0, 4) + '-'
								+ enddate.substring(4, 6) + '-'
								+ enddate.substring(6, 8);

						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						String date1 = sdf.format(Util.getLastMonthDay(Util
								.switchStringToDate(enddate)));

						if (!date1.equals(enddate)) {
							request.setAttribute("errorMsg",
									"申报截止时间不是月末，请使用阶段申报！");
							return "/cxtj/error";
						}

						String sbsjsql = "select * from skq_sbsj "
								+ " where SSKSSJ='" + startdate
								+ "' and SSJZSJ='" + enddate + "' and JQBH='"
								+ jqbh + "'";
						int size = dalClient.queryForObjectList(sbsjsql).size();
						if (size != 0) {
							request.setAttribute("errorMsg", "申报数据已存在，不能重复申报！");
							return "/cxtj/error";
						} else {
							// 保存申报数据
							double normalsum1 = Double
									.parseDouble((String) sbinfo
											.get("normalsum1"));
							normalsum1 = Double.parseDouble(dg
									.format(normalsum1 / 100));

							double normalsum2 = Double
									.parseDouble((String) sbinfo
											.get("normalsum2"));
							normalsum2 = Double.parseDouble(dg
									.format(normalsum2 / 100));

							double normalsum3 = Double
									.parseDouble((String) sbinfo
											.get("normalsum3"));
							normalsum3 = Double.parseDouble(dg
									.format(normalsum3 / 100));

							double normalsum4 = Double
									.parseDouble((String) sbinfo
											.get("normalsum4"));
							normalsum4 = Double.parseDouble(dg
									.format(normalsum4 / 100));

							double normalsum5 = Double
									.parseDouble((String) sbinfo
											.get("normalsum5"));
							normalsum5 = Double.parseDouble(dg
									.format(normalsum5 / 100));

							double normalsum6 = Double
									.parseDouble((String) sbinfo
											.get("normalsum6"));
							normalsum6 = Double.parseDouble(dg
									.format(normalsum6 / 100));

							double backsum1 = Double
									.parseDouble((String) sbinfo
											.get("backsum1"));
							backsum1 = Double.parseDouble(dg
									.format(backsum1 / 100));

							double backsum2 = Double
									.parseDouble((String) sbinfo
											.get("backsum2"));
							backsum2 = Double.parseDouble(dg
									.format(backsum2 / 100));

							double backsum3 = Double
									.parseDouble((String) sbinfo
											.get("backsum3"));
							backsum3 = Double.parseDouble(dg
									.format(backsum3 / 100));

							double backsum4 = Double
									.parseDouble((String) sbinfo
											.get("backsum4"));
							backsum4 = Double.parseDouble(dg
									.format(backsum4 / 100));

							double backsum5 = Double
									.parseDouble((String) sbinfo
											.get("backsum5"));
							backsum5 = Double.parseDouble(dg
									.format(backsum5 / 100));

							double backsum6 = Double
									.parseDouble((String) sbinfo
											.get("backsum6"));
							backsum6 = Double.parseDouble(dg
									.format(backsum6 / 100));

							double normalsum = Double.parseDouble(dg
									.format(normalsum1 + normalsum2
											+ normalsum3 + normalsum4
											+ normalsum5 + normalsum6));

							double backsum = Double.parseDouble(dg
									.format(backsum1 + backsum2 + backsum3
											+ backsum4 + backsum5 + backsum6));
							SkqSbsj sbsj = new SkqSbsj();
							sbsj.setNsrwjbm(new_wjbm);
							sbsj.setJqbh(jqbh);
							sbsj.setZcpfs(Integer.parseInt((String) sbinfo
									.get("normalcnt")));
							sbsj.setTpfs(Integer.parseInt((String) sbinfo
									.get("backcnt")));
							sbsj.setFpfs(Integer.parseInt((String) sbinfo
									.get("deposecnt")));
							sbsj.setSskssj(DateUtil.parse(startdate,
									"yyyy-MM-dd"));
							sbsj.setSsjzsj(DateUtil
									.parse(enddate, "yyyy-MM-dd"));
							sbsj.setZcpzje(normalsum);
							sbsj.setTpzje(backsum);
							sbsj.setSbrq(new Date());
							sbsj.setSblx(1);
							int sid = skqSbsjService.save(sbsj);
							if (sid != 0) {
								ArrayList sbzbxx = new ArrayList();
								if (normalsum1 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index1"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum1);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum2 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index2"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum2);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum3 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index3"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum3);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum4 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index4"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum4);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum5 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index5"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum5);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (normalsum6 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index6"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", normalsum6);
									hm.put("kplx", 1);
									sbzbxx.add(hm);
								}
								if (backsum1 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index1"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum1 * -1);
									hm.put("kplx", 2);

									sbzbxx.add(hm);
								}
								if (backsum2 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index2"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum2 * -1);
									hm.put("kplx", 2);

									sbzbxx.add(hm);
								}
								if (backsum3 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index3"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum3 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum4 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index4"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum4 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum5 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index5"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum5 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								if (backsum6 > 0) {
									int smsy = Integer.parseInt((String) sbinfo
											.get("index6"));
									String smbm = skqPmszService.getPmszBySmsy(
											smsy + "").getSmbm();
									HashMap hm = new HashMap();
									hm.put("parentid", sid);
									hm.put("smbm", smbm);
									hm.put("je", backsum6 * -1);
									hm.put("kplx", 2);
									sbzbxx.add(hm);
								}
								SkqSbsj skqSbsj = skqSbsjService.findById(sid,
										SkqSbsj.class);

								if (sbzbxx != null && !sbzbxx.isEmpty()) {
									for (int i = 0; i < sbzbxx.size(); i++) {
										HashMap hm = (HashMap) sbzbxx.get(i);
										String sql = "insert into SKQ_SBSJMX(PARENTID,SMBM,JE,KPLX) values("
												+ (Integer) hm.get("parentid")
												+ ",'"
												+ (String) hm.get("smbm")
												+ "',"
												+ (Double) hm.get("je")
												+ ","
												+ (Integer) hm.get("kplx")
												+ ")";
										dalClient.update(sql);
									}
								}

								// 查询本月已申报机器数量
								String sqlCount = "select count(ID) as num from SKQ_SBSJ where NSRWJBM='"
										+ new_wjbm
										+ "' and SSKSSJ>='"
										+ startdate
										+ "' and SSJZSJ<='"
										+ enddate + "' and SBLX=1";
								Long ysbjqsl = dalClient.queryColumn(sqlCount,
										"num");
								int sbflag = 1;
								int jqsl = nsrxx.getJqxxList().size();
								String jqmsg = "";
								if ((jqsl - ysbjqsl) > 0) {
									sbflag = 0;
									jqmsg = "您共有 " + jqsl + " 台机器，已申报  "
											+ ysbjqsl + "台，还有 "
											+ (jqsl - ysbjqsl) + " 台未申报";
								} else {
									jqmsg = "您共有 " + jqsl + " 台机器，已全部申报";
								}
								List alJdsb = new ArrayList();
								// 上月第一天
								String previousMonthFirst = Util
										.getPreviousMonthFirst();
								// 上月最后一天
								String previousMonthEnd = Util
										.getPreviousMonthEnd();
								String sql2 = "select * from SKQ_SBSJ where NSRWJBM='"
										+ new_wjbm
										+ "' and SSKSSJ>='"
										+ previousMonthFirst
										+ "' and SSJZSJ<='"
										+ previousMonthEnd + "' and SBLX=2";
								alJdsb = dalClient.queryForObjectList(sql2,
										SkqSbsj.class);
								HashMap hmSb = new HashMap();

								setAttr("nsrxx", nsrxx);
								setAttr("sbsj", sbsj);
								setAttr("alJdsb", alJdsb);
								setAttr("jqmsg", jqmsg);
								setAttr("sbflag", sbflag);
								return "/sbsj/sbsj.sbxx";
							} else {
								request.setAttribute("errorMsg", "申报数据保存失败！");
								return "/cxtj/error";
							}
						}

					}
				}
			}
		}
	}

	@RequestMapping("/jkhcdk")
	public String jkhcdk(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		dalClient.update("delete from skq_jqszsm where jynr is null");
		String sccs = getPara("sccs");
		HttpSession session = request.getSession();
		HashMap CARDINFO = new HashMap();
		String mac_st = "";
		if("001".equals(sccs)){
			CARDINFO = (HashMap) session.getAttribute("UCARDINFO");
		}
		else{
			String old_wjbm = getPara("old_wjbm");
			String jqbh = getPara("jqbh");
			String skkh = getPara("skkh");
			String dkxx = new String(getPara("dkxx").getBytes("iso8859-1"),"utf-8");
			
			String[] dkxx_arr = dkxx.split("\\^");
			mac_st = dkxx_arr[21];
			
			HashMap EF06 = new HashMap();
			EF06.put("JQBH", jqbh);
			EF06.put("SKKH", skkh);
			HashMap EF02 = new HashMap();
			EF02.put("NSRWJDM", old_wjbm);
			
			CARDINFO.put("EF06", EF06);
			CARDINFO.put("EF02", EF02);
			CARDINFO.put("EF01", new HashMap());
			CARDINFO.put("EF04", new HashMap());
		}
		 
		if (CARDINFO == null || CARDINFO.isEmpty()) {
			request.setAttribute("errorMsg", "卡信息读取失败！");
			return "/cxtj/error";
		}
		else {
			HashMap kxx = (HashMap) CARDINFO.get("EF02");
			HashMap EF01 = (HashMap) CARDINFO.get("EF01");
			HashMap EF06 = (HashMap) CARDINFO.get("EF06");
			String jqbh = (String) EF06.get("JQBH");
			String card_nsrwjbm = (String) kxx.get("NSRWJDM");
			String new_wjbm = dalClient.queryColumn(
					"select NEW_WJBM from skq_wjbmdy where jqbh='" + jqbh
							+ "' and old_wjbm='" + card_nsrwjbm + "'",
					"NEW_WJBM");

			SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(new_wjbm);
			int status = nsrxx.getStatus();
			String swjgbm = nsrxx.getSwjgbm();
			HashMap EF02 = (HashMap) CARDINFO.get("EF02");
			HashMap EF04 = (HashMap) CARDINFO.get("EF04");
			String old_nsrwjbm = (String) EF02.get("NSRWJDM");
			String kpjzrq = (String) EF01.get("KPJZRQ");
			String skkh = (String) EF06.get("SKKH");
			SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);
			if (status != 1) {
				request.setAttribute("errorMsg", "纳税户已注销！");
				return "/cxtj/error";
			}else if(skqJqxx.getJqszsmList().size()==0) {
				request.setAttribute("errorMsg", "机器对应税种税目为空，请去机器设置添加相关税种税目！");
				return "/cxtj/error";
			}
			
			else {
				HashMap hmJkhc = new HashMap();
				
				if("001".equals(sccs)){
					hmJkhc.put("old_nsrwjbm", old_nsrwjbm);
					hmJkhc.put("jqxx", skqJqxx);
					hmJkhc.put("nsrxx", nsrxx);
					hmJkhc.put("QYRQ", (String) EF02.get("QYRQ"));
					hmJkhc.put("YXRQ", (String) EF02.get("YXRQ"));
					hmJkhc.put("MXSBBZ", (String) EF01.get("MXSBBZ"));
					hmJkhc.put("JQLX", (String) EF02.get("JQLX"));
					hmJkhc.put("JQSL", (String) EF02.get("JQSL"));
					hmJkhc.put("LXBS", (String) EF02.get("LXBS"));
					hmJkhc.put("YYBB", (String) EF02.get("YYBB"));
					hmJkhc.put("FCI", (String) EF02.get("FCI"));
					hmJkhc.put("MAC", (String) EF04.get("mac"));
					hmJkhc.put("kpjzrq", kpjzrq);
				}
				else{
					kpjzrq = Util.toxkrq(skqJqxx.getKpjzrq());
					hmJkhc.put("old_nsrwjbm",old_nsrwjbm);
					hmJkhc.put("jqxx", skqJqxx);
					hmJkhc.put("nsrxx", nsrxx);
					
					hmJkhc.put("QYRQ", Util.toxkrq(skqJqxx.getKqyrq()));
					hmJkhc.put("YXRQ", Util.toxkrq(skqJqxx.getKyxrq()));
					hmJkhc.put("MXSBBZ", skqJqxx.getMxsbbz());
					hmJkhc.put("JQLX", skqJqxx.getJqxhbm());
					hmJkhc.put("JQSL", "1");
					hmJkhc.put("LXBS", "");
					hmJkhc.put("YYBB", "");
					hmJkhc.put("FCI", "");
					hmJkhc.put("MAC", mac_st);
					hmJkhc.put("kpjzrq", kpjzrq);
				}
				
				String smStr = "";
				String smStrSt = "";
				for (int i = 0; i < skqJqxx.getJqszsmList().size(); i++) {
					SkqJqszsm szsm = skqJqxx.getJqszsmList().get(i);
					Integer smsy = szsm.getSmsy();
					String smsyStr = StringUtil.charFront(smsy.toString(), 2,
							"0");
					String smjc=szsm.getSmjc();
					if(!StringUtil.isBlank(smjc)){
						if(smjc.length()>10){
							smjc=smjc.substring(0,10);
						}
					}
					
					String sm = smsyStr + "," + szsm.getSmbm() + ","
							+ szsm.getSl().intValue() + "," + smjc;
					smStr = smStr + "<input type=\"hidden\" name=\"tax" + i
							+ "\" id=\"tax" + i + "\"  value=\"" + sm + "\" />";
					
					smStrSt = smStrSt+smsyStr;
				}
				int length = skqJqxx.getJqszsmList().size();
				if (length < 20) {

					for (int i = 0; i < 20 - length; i++) {
						smStr = smStr + "<input type=\"hidden\" name=\"tax"
								+ (i + length) + "\" id=\"tax" + (i + length)
								+ "\"  value=\"\" />";
					}
				}
				setAttr("smStr", smStr);
				String sbsjSql = "select id from skq_sbsj "
						+ " where (XZZT=0 or XZZT is null) and JQBH='" + jqbh
						+ "'";
				Long sid = dalClient.queryColumn(sbsjSql, "id");
				int sblx = 1;
				if (sid !=null) {
					SkqSbsj sbsj = skqSbsjService.findById(sid, SkqSbsj.class);
					sblx = sbsj.getSblx();
				}
				String xckpjzrq = "";
				if (sblx == 1) {
					xckpjzrq = Util.hqjkhcrq();
				} else {
					xckpjzrq = Util.getNDayAfterOneDate(Util.tobzrq(kpjzrq), 1);
				}
				hmJkhc.put("xckpjzrq", xckpjzrq);
				request.setAttribute("hmJkhc", hmJkhc);
				request.setAttribute("smxkArr1", smStrSt);
				request.setAttribute("NSRSBH", nsrxx.getNsrsbh());

				return "/sbsj/jkhc.hc";

			}
		}

	}

	@RequestMapping("/updateKpxe")
	public String updateKpxe(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String kpjzrq = request.getParameter("kpjzrq");
		String jqbh = request.getParameter("jqbh");
		double dzkpxe = Double.parseDouble(request.getParameter("dzkpxe"));
		double yljkpxe = Double.parseDouble(request.getParameter("yljkpxe"));
		double yljtpxe = Double.parseDouble(request.getParameter("yljtpxe"));
		String mac = request.getParameter("mac");
		kpjzrq = Util.tobzrq(kpjzrq);
		SkqJqxx jqxx = skqJqxxService.getJqxxByJqbh(jqbh);
		jqxx.setKpjzrq(DateUtil.parse(kpjzrq, "yyyy-MM-dd"));
		jqxx.setDzkpxe(dzkpxe);
		jqxx.setYljkpxe(yljkpxe);
		jqxx.setYljtpxe(yljtpxe);
		String sql = "update SKQ_JQXX set KPJZRQ='" + kpjzrq + "',DZKPXE="
				+ dzkpxe + ",YLJKPXE=" + yljkpxe + ",YLJTPXE=" + yljtpxe
				+ " where JQBH='" + jqbh + "'  and STATUS=1";
		dalClient.update(sql);
		String sbsjsql = "select id from skq_sbsj "
				+ " where (XZZT=0 or XZZT is null) and JQBH='" + jqbh + "'";
		Long sid = dalClient.queryColumn(sbsjsql, "id");
		if(sid!=null){
			if (sid != 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
				SkqSbsj sbsj = skqSbsjService.findById(sid, SkqSbsj.class);
				sbsj.setKpjzsj(DateUtil.parse(kpjzrq, "yyyy-MM-dd"));
				sbsj.setDzkpxe(dzkpxe);
				sbsj.setYljkpxe(yljkpxe);
				sbsj.setYljtpxe(yljtpxe);
				sbsj.setCjrq(new Date());
				sbsj.setXzzt(1);
				sbsj.setXzrq(new Date());
				sbsj.setMac(mac);
				dalClient.update(sbsj);
			}
		}

		return "/sbsj/sbsj";
	}

	@RequestMapping("/toSbsjDetail")
	public String toSbsjDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long id = getParaToLong("id");
		String sql = "select a.JE as je,a.SMBM as smbm,a.KPLX as kplx,b.SL as sl,b.SMMC as smmc from SKQ_SBSJMX a left outer join SKQ_PMSZ b on a.SMBM=b.SMBM where a.PARENTID = "
				+ id;
		List<Map<String, Object>> detailList = dalClient
				.queryForObjectList(sql);
		setAttr("detailList", detailList);
		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_detail";
	}

	@RequestMapping("/sbhzsj")
	public String sbhzsj(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 上月第一天
		String previousMonthFirst = Util.getPreviousMonthFirst();
		// 上月最后一天
		String previousMonthEnd = Util.getPreviousMonthEnd();

		String nsrwjbm = getPara("nsrwjbm");
		String sql = "select * from SKQ_SBSJ where NSRWJBM='" + nsrwjbm
				+ "' and SSKSSJ>='" + previousMonthFirst + "' and SSKSSJ<='"
				+ previousMonthEnd + "'";
		List<SkqSbsj> allSbsj = dalClient
				.queryForObjectList(sql, SkqSbsj.class);

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String premonth = dateformat.format(c.getTime());
		int year = Integer.parseInt(premonth.substring(0, 4));
		int month = Integer.parseInt(premonth.substring(5, 7));
		if (allSbsj != null && !allSbsj.isEmpty()) {
			Iterator it = allSbsj.iterator();
			int zcpfs = 0;
			int tpfs = 0;
			int fpfs = 0;
			double zcpzje = 0;
			double tpzje = 0;
			String sidStr = "";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (it.hasNext()) {
				SkqSbsj sbsj1 = (SkqSbsj) it.next();

				zcpfs = zcpfs + sbsj1.getZcpfs();
				tpfs = tpfs + sbsj1.getTpfs();
				fpfs = fpfs + sbsj1.getFpfs();
				zcpzje = zcpzje + sbsj1.getZcpzje();
				tpzje = tpzje + sbsj1.getTpzje();

				if ("".equals(sidStr)) {
					sidStr = sidStr + sbsj1.getId();
				} else {
					sidStr = sidStr + "," + sbsj1.getId();
				}
			}
			if ("".equals(sidStr)) {
				sidStr = "0";
			}
			
			String sql_child = "select sum(a.JE) as JE,a.SMBM,b.SL,b.SMMC from SKQ_SBSJMX a left outer join SKQ_PMSZ b on a.SMBM=b.SMBM where a.PARENTID in("
					+ sidStr + ") group by a.SMBM,b.SL,b.SMMC"; 
			List<Map<String,Object>> alSbsjzb =dalClient.queryForObjectList(sql_child);
			
			SkqHzsj skqHzsj=new SkqHzsj();
			
			skqHzsj.setNsrwjbm(nsrwjbm);
			skqHzsj.setZcpfs(zcpfs);
			skqHzsj.setTpfs(tpfs);
			skqHzsj.setFpfs(fpfs);
			skqHzsj.setZcpzje(zcpzje);
			skqHzsj.setTpzje(tpzje);
			skqHzsj.setYear(year);
			skqHzsj.setMonth(month);
			skqHzsj.setHzrq(new Date());
			String queryIdSql = "select id from skq_hzsj"+ " where NSRWJBM='" + nsrwjbm + "' and YEAR=" + year
					+ " and MONTH=" + month;
			Long sid = dalClient.queryColumn(queryIdSql,"id");
			if (sid!=null) {
				request.setAttribute("errorMsg", "汇总数据已生成！");
				return "/cxtj/error";
			} else {
				Integer resultId=dalClient.save(skqHzsj);
				if (resultId != -1) {
					if (alSbsjzb != null && !alSbsjzb.isEmpty()) {
						Iterator it1 = alSbsjzb.iterator();
						while (it1.hasNext()) {
							HashMap hm = (HashMap) it1.next();
							String sql1 = "insert into SKQ_HZSJMX(PARENTID,SMBM,KPJE,DKJE,YHDYYE,FLAG) values("
									+ resultId
									+ ",'"
									+ (String) hm.get("smbm")
									+ "',"
									+ (BigDecimal) hm.get("je")
									+ ","
									+ 0
									+ ","
									+ (BigDecimal) hm.get("yhde") + ","+0+")";
							dalClient.update(sql1);
						}
					}
					

					SkqHzsj sbhz =dalClient.findById(resultId,SkqHzsj.class);
					SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
					setAttr("nsrxx", nsrxx);
					setAttr("sbhz", sbhz);
					setAttr("alSbsjzb", alSbsjzb);
					return "/sbsj/sbsj.hzxx";
				} else {
					request.setAttribute("errorMsg", "汇总数据生成失败！");
					return "/cxtj/error";
				}
			}
		}

		return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_detail";
	}
	
	
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DbKit dbKit = new DbKit(
				"select t.*,a.nsrsbh,a.nsrmc from skq_sbsj  t inner JOIN skq_nsrxx a ON t.nsrwjbm=a.nsrwjbm inner JOIN security_organization b ON a.swjgbm=b.code  ");
 		String searchSQL = "";
		String orderSQL = "";

		String NSRSBH = getPara("NSRSBH");
        if (NSRSBH != null && !"".equals(NSRSBH)) {
        	String nsrwjbm=dalClient.queryColumn("select nsrwjbm from skq_nsrxx where nsrsbh='"+NSRSBH+"'","nsrwjbm");
            searchSQL = searchSQL + " and  t.NSRWJBM ='"+nsrwjbm+"'";
            setAttr("NSRSBH", NSRSBH);
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
			searchSQL = searchSQL + " and  SSKSSJ>='" + startTime+"'";
			setAttr("startTime", startTime);
		}

		String endTime = getPara("endTime");
		if (endTime != null && !"".equals(endTime)) {
			searchSQL = searchSQL + " and  SSJZSJ<='" + endTime+"'";
			setAttr("endTime", endTime);
		}
		
		dbKit.append(orderSQL);
		dbKit.append(searchSQL);
		List<SkqSbsj> pageList = skqSbsjService.queryForList(dbKit,
				SkqSbsj.class);
		List<Map<String, Object>> list = createExcelRecord(pageList);
		String columnNames[] = { "纳税人识别号", "纳税人名称", "机器编码","开始时间","截止时间","正常票份数","退票份数","废票份数","正常票总金额","退票总金额" };// 列名
		String keys[] = {"nsrsbh", "nsrmc", "jqbh","sskssj","ssjzsj","zcpfs","tpfs","fpfs","zcpzje","tpzje"};// map中的key
		String fileName="申报数据报表";
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

	private List<Map<String, Object>> createExcelRecord(List<SkqSbsj> nsrxxList) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		for (SkqSbsj sbsj : nsrxxList) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
 			mapValue.put("nsrsbh", sbsj.getNsrsbh());
			mapValue.put("nsrmc", sbsj.getNsrmc());
			mapValue.put("jqbh",sbsj.getJqbh());
			mapValue.put("sskssj",DateUtil.formatDateTime(sbsj.getSskssj(),"yyyy-MM-dd"));
			mapValue.put("ssjzsj",DateUtil.formatDateTime(sbsj.getSsjzsj(),"yyyy-MM-dd"));
			mapValue.put("zcpfs",sbsj.getZcpfs());
			mapValue.put("tpfs",sbsj.getTpfs());
			mapValue.put("zcpzje",sbsj.getZcpzje());
			mapValue.put("tpzje",sbsj.getTpzje());
			listmap.add(mapValue);
		}
		return listmap;
	}

}

package com.jdk2010.sbsj.skqsbsj.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.jdk2010.sbsj.skqsbsj.model.SkqSbsj;
import com.jdk2010.sbsj.skqsbsj.service.ISkqSbsjService;
import com.jdk2010.system.skqpmsz.service.ISkqPmszService;
import com.jdk2010.tools.Constants;
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

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DbKit dbKit = new DbKit(
                "select t.* from skq_sbsj  t left JOIN skq_nsrxx a ON t.nsrwjbm=a.nsrwjbm left JOIN security_organization b ON a.swjgbm=b.code  ");
        String searchSQL = "";
        String NSRWJBM = getPara("NSRWJBM");
        if (NSRWJBM != null && !"".equals(NSRWJBM)) {
            searchSQL = searchSQL + " and  t.NSRWJBM LIKE '%:NSRWJBM%'";
            setAttr("NSRWJBM", NSRWJBM);
            dbKit.put("NSRWJBM", NSRWJBM);
        }

        String SWJGBM = getPara("SWJGBM");
        if (SWJGBM != null && !"".equals(SWJGBM)) {
            searchSQL = searchSQL + " and   a.swjgbm='" + SWJGBM + "'";
            setAttr("SWJGBM", SWJGBM);
            setAttr("parentName", getPara("parentName"));
        }

        String JQBH = getPara("JQBH");
        if (JQBH != null && !"".equals(JQBH)) {
            searchSQL = searchSQL + " and  t.JQBH =':JQBH'";
            setAttr("JQBH", JQBH);
            dbKit.put("JQBH", JQBH);
        }

        String startTime = getPara("startTime");
        if (startTime != null && !"".equals(startTime)) {
            searchSQL = searchSQL + " and  t.SSKSSJ>='" + startTime + " 00:00:00'";
            setAttr("startTime", startTime);
        }

        String endTime = getPara("endTime");
        if (endTime != null && !"".equals(endTime)) {
            searchSQL = searchSQL + " and  t.SSJZSJ<='" + endTime + " 23:59:59'";
            setAttr("endTime", endTime);
        }
        dbKit.append(searchSQL);
        Page pageList = skqSbsjService.queryForPageList(dbKit, getPage(), SkqSbsj.class);
        setAttr("pageList", pageList);
        return "/com/jdk2010/sbsj/skqsbsj/skqsbsj";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_add";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqSbsj skqSbsj = getModel(SkqSbsj.class);
        skqSbsjService.save(skqSbsj);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqSbsj skqSbsj = skqSbsjService.findById(id, SkqSbsj.class);
        setAttr("skqSbsj", skqSbsj);
        return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqSbsj skqSbsj = getModel(SkqSbsj.class);
        skqSbsjService.update(skqSbsj);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqSbsjService.deleteByIDS(ids, SkqSbsj.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqSbsj skqSbsj = skqSbsjService.findById(id, SkqSbsj.class);
        setAttr("skqSbsj", skqSbsj);
        return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_view";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/sbsj/sbsj";
    }

    @RequestMapping("/toZrysb")
    public String toZrysb(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/sbsj/sbsj";
    }
    
    @RequestMapping("/toJdsb")
    public String toJdsb(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/sbsj/jdsb";
    }
    
    @RequestMapping("/toJkhc")
    public String toJkhc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/sbsj/jkhc";
    }
    
    
    @RequestMapping("/jdsbsjdk")
    public String jdsbsjdk(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String nsrwjbm = "";
        String kpjzrq = "";
        HashMap sbinfo = new HashMap();
        DecimalFormat dg = new DecimalFormat("0.00");
        HashMap cardInfo = (HashMap) session.getAttribute("UCARDINFO");
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
            SkqJqxx jqxx = dalClient.queryForObject("select * from skq_jqxx where nsrwjbm='" + card_nsrwjbm
                    + "' and jqbh='" + jqbh + "'", SkqJqxx.class);
            if (jqxx == null) {
                request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为：" + card_nsrwjbm + ",机器编号为：" + jqxx);
                return "/cxtj/error";
            } else {
                nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(card_nsrwjbm);
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

                        startdate = startdate.substring(0, 4) + '-' + startdate.substring(4, 6) + '-'
                                + startdate.substring(6, 8);
                        enddate = enddate.substring(0, 4) + '-' + enddate.substring(4, 6) + '-'
                                + enddate.substring(6, 8);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String sbsjsql = "select * from skq_sbsj " + " where SSKSSJ='" + startdate + "' and SSJZSJ='"
                                + enddate + "' and JQBH='" + jqbh + "'";
                        int size = dalClient.queryForObjectList(sbsjsql).size();
                        if (size != 0) {
                            request.setAttribute("errorMsg", "申报数据已存在，不能重复申报！");
                            return "/cxtj/error";
                        } else {
                            // 保存申报数据
                            double normalsum1 = Double.parseDouble((String) sbinfo.get("normalsum1"));
                            normalsum1 = Double.parseDouble(dg.format(normalsum1 / 100));

                            double normalsum2 = Double.parseDouble((String) sbinfo.get("normalsum2"));
                            normalsum2 = Double.parseDouble(dg.format(normalsum2 / 100));

                            double normalsum3 = Double.parseDouble((String) sbinfo.get("normalsum3"));
                            normalsum3 = Double.parseDouble(dg.format(normalsum3 / 100));

                            double normalsum4 = Double.parseDouble((String) sbinfo.get("normalsum4"));
                            normalsum4 = Double.parseDouble(dg.format(normalsum4 / 100));

                            double normalsum5 = Double.parseDouble((String) sbinfo.get("normalsum5"));
                            normalsum5 = Double.parseDouble(dg.format(normalsum5 / 100));

                            double normalsum6 = Double.parseDouble((String) sbinfo.get("normalsum6"));
                            normalsum6 = Double.parseDouble(dg.format(normalsum6 / 100));

                            double backsum1 = Double.parseDouble((String) sbinfo.get("backsum1"));
                            backsum1 = Double.parseDouble(dg.format(backsum1 / 100));

                            double backsum2 = Double.parseDouble((String) sbinfo.get("backsum2"));
                            backsum2 = Double.parseDouble(dg.format(backsum2 / 100));

                            double backsum3 = Double.parseDouble((String) sbinfo.get("backsum3"));
                            backsum3 = Double.parseDouble(dg.format(backsum3 / 100));

                            double backsum4 = Double.parseDouble((String) sbinfo.get("backsum4"));
                            backsum4 = Double.parseDouble(dg.format(backsum4 / 100));

                            double backsum5 = Double.parseDouble((String) sbinfo.get("backsum5"));
                            backsum5 = Double.parseDouble(dg.format(backsum5 / 100));

                            double backsum6 = Double.parseDouble((String) sbinfo.get("backsum6"));
                            backsum6 = Double.parseDouble(dg.format(backsum6 / 100));

                            double normalsum = Double.parseDouble(dg.format(normalsum1 + normalsum2 + normalsum3
                                    + normalsum4 + normalsum5 + normalsum6));

                            double backsum = Double.parseDouble(dg.format(backsum1 + backsum2 + backsum3 + backsum4
                                    + backsum5 + backsum6));
                            SkqSbsj sbsj = new SkqSbsj();
                            sbsj.setNsrwjbm(nsrwjbm);
                            sbsj.setJqbh(jqbh);
                            sbsj.setZcpfs(Integer.parseInt((String) sbinfo.get("normalcnt")));
                            sbsj.setTpfs(Integer.parseInt((String) sbinfo.get("backcnt")));
                            sbsj.setFpfs(Integer.parseInt((String) sbinfo.get("deposecnt")));
                            sbsj.setSskssj(DateUtil.parse(startdate,"yyyy-MM-dd"));
                            sbsj.setSsjzsj(DateUtil.parse(enddate,"yyyy-MM-dd"));
                            sbsj.setZcpzje(normalsum);
                            sbsj.setTpzje(backsum);
                            sbsj.setSbrq(new Date());
                            sbsj.setSblx(2);
                            int sid = skqSbsjService.save(sbsj);
                            if (sid != 0) {
                                ArrayList sbzbxx = new ArrayList();
                                if (normalsum1 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index1"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum1);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum2 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index2"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum2);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum3 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index3"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum3);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum4 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index4"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum4);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum5 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index5"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum5);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum6 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index6"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum6);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (backsum1 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index1"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum1 * -1);
                                    hm.put("kplx", 2);

                                    sbzbxx.add(hm);
                                }
                                if (backsum2 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index2"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum2 * -1);
                                    hm.put("kplx", 2);

                                    sbzbxx.add(hm);
                                }
                                if (backsum3 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index3"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum3 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum4 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index4"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum4 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum5 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index5"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum5 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum6 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index6"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum6 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                SkqSbsj skqSbsj = skqSbsjService.findById(sid, SkqSbsj.class);
                                if (sbzbxx != null && !sbzbxx.isEmpty()) {
                                    for(int i=0;i<sbzbxx.size();i++){
                                        HashMap hm = (HashMap) sbzbxx.get(i);
                                        String sql = "insert into SKQ_SBSJMX(PARENTID,SMBM,JE,KPLX) values("
                                                + (Integer) hm.get("parentid")
                                                + ",'"
                                                + (String) hm.get("smbm")
                                                + "',"
                                                + (Double) hm.get("je")
                                                + ","
                                                + (Integer) hm.get("kplx") + ")";
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
    public String sbsjdk(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String nsrwjbm = "";
        String kpjzrq = "";
        HashMap sbinfo = new HashMap();
        DecimalFormat dg = new DecimalFormat("0.00");
        HashMap cardInfo = (HashMap) session.getAttribute("UCARDINFO");
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
            SkqJqxx jqxx = dalClient.queryForObject("select * from skq_jqxx where nsrwjbm='" + card_nsrwjbm
                    + "' and jqbh='" + jqbh + "'", SkqJqxx.class);
            if (jqxx == null) {
                request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为：" + card_nsrwjbm + ",机器编号为：" + jqxx);
                return "/cxtj/error";
            } else {
                nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(card_nsrwjbm);
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

                        startdate = startdate.substring(0, 4) + '-' + startdate.substring(4, 6) + '-'
                                + startdate.substring(6, 8);
                        enddate = enddate.substring(0, 4) + '-' + enddate.substring(4, 6) + '-'
                                + enddate.substring(6, 8);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String sbsjsql = "select * from skq_sbsj " + " where SSKSSJ='" + startdate + "' and SSJZSJ='"
                                + enddate + "' and JQBH='" + jqbh + "'";
                        int size = dalClient.queryForObjectList(sbsjsql).size();
                        if (size != 0) {
                            request.setAttribute("errorMsg", "申报数据已存在，不能重复申报！");
                            return "/cxtj/error";
                        } else {
                            // 保存申报数据
                            double normalsum1 = Double.parseDouble((String) sbinfo.get("normalsum1"));
                            normalsum1 = Double.parseDouble(dg.format(normalsum1 / 100));

                            double normalsum2 = Double.parseDouble((String) sbinfo.get("normalsum2"));
                            normalsum2 = Double.parseDouble(dg.format(normalsum2 / 100));

                            double normalsum3 = Double.parseDouble((String) sbinfo.get("normalsum3"));
                            normalsum3 = Double.parseDouble(dg.format(normalsum3 / 100));

                            double normalsum4 = Double.parseDouble((String) sbinfo.get("normalsum4"));
                            normalsum4 = Double.parseDouble(dg.format(normalsum4 / 100));

                            double normalsum5 = Double.parseDouble((String) sbinfo.get("normalsum5"));
                            normalsum5 = Double.parseDouble(dg.format(normalsum5 / 100));

                            double normalsum6 = Double.parseDouble((String) sbinfo.get("normalsum6"));
                            normalsum6 = Double.parseDouble(dg.format(normalsum6 / 100));

                            double backsum1 = Double.parseDouble((String) sbinfo.get("backsum1"));
                            backsum1 = Double.parseDouble(dg.format(backsum1 / 100));

                            double backsum2 = Double.parseDouble((String) sbinfo.get("backsum2"));
                            backsum2 = Double.parseDouble(dg.format(backsum2 / 100));

                            double backsum3 = Double.parseDouble((String) sbinfo.get("backsum3"));
                            backsum3 = Double.parseDouble(dg.format(backsum3 / 100));

                            double backsum4 = Double.parseDouble((String) sbinfo.get("backsum4"));
                            backsum4 = Double.parseDouble(dg.format(backsum4 / 100));

                            double backsum5 = Double.parseDouble((String) sbinfo.get("backsum5"));
                            backsum5 = Double.parseDouble(dg.format(backsum5 / 100));

                            double backsum6 = Double.parseDouble((String) sbinfo.get("backsum6"));
                            backsum6 = Double.parseDouble(dg.format(backsum6 / 100));

                            double normalsum = Double.parseDouble(dg.format(normalsum1 + normalsum2 + normalsum3
                                    + normalsum4 + normalsum5 + normalsum6));

                            double backsum = Double.parseDouble(dg.format(backsum1 + backsum2 + backsum3 + backsum4
                                    + backsum5 + backsum6));
                            SkqSbsj sbsj = new SkqSbsj();
                            sbsj.setNsrwjbm(card_nsrwjbm);
                            sbsj.setJqbh(jqbh);
                            sbsj.setZcpfs(Integer.parseInt((String) sbinfo.get("normalcnt")));
                            sbsj.setTpfs(Integer.parseInt((String) sbinfo.get("backcnt")));
                            sbsj.setFpfs(Integer.parseInt((String) sbinfo.get("deposecnt")));
                            sbsj.setSskssj(DateUtil.parse(startdate,"yyyy-MM-dd"));
                            sbsj.setSsjzsj(DateUtil.parse(enddate,"yyyy-MM-dd"));
                            sbsj.setZcpzje(normalsum);
                            sbsj.setTpzje(backsum);
                            sbsj.setSbrq(new Date());
                            sbsj.setSblx(1);
                            int sid = skqSbsjService.save(sbsj);
                            if (sid != 0) {
                                ArrayList sbzbxx = new ArrayList();
                                if (normalsum1 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index1"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum1);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum2 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index2"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum2);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum3 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index3"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum3);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum4 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index4"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum4);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum5 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index5"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum5);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (normalsum6 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index6"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", normalsum6);
                                    hm.put("kplx", 1);
                                    sbzbxx.add(hm);
                                }
                                if (backsum1 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index1"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum1 * -1);
                                    hm.put("kplx", 2);

                                    sbzbxx.add(hm);
                                }
                                if (backsum2 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index2"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum2 * -1);
                                    hm.put("kplx", 2);

                                    sbzbxx.add(hm);
                                }
                                if (backsum3 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index3"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum3 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum4 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index4"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum4 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum5 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index5"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum5 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                if (backsum6 > 0) {
                                    int smsy = Integer.parseInt((String) sbinfo.get("index6"));
                                    String smbm = skqPmszService.getPmszBySmsy(smsy + "").getSmbm();
                                    HashMap hm = new HashMap();
                                    hm.put("parentid", sid);
                                    hm.put("smbm", smbm);
                                    hm.put("je", backsum6 * -1);
                                    hm.put("kplx", 2);
                                    sbzbxx.add(hm);
                                }
                                SkqSbsj skqSbsj = skqSbsjService.findById(sid, SkqSbsj.class);
                                
                                if (sbzbxx != null && !sbzbxx.isEmpty()) {
                                    for(int i=0;i<sbzbxx.size();i++){
                                        HashMap hm = (HashMap) sbzbxx.get(i);
                                        String sql = "insert into SKQ_SBSJMX(PARENTID,SMBM,JE,KPLX) values("
                                                + (Integer) hm.get("parentid")
                                                + ",'"
                                                + (String) hm.get("smbm")
                                                + "',"
                                                + (Double) hm.get("je")
                                                + ","
                                                + (Integer) hm.get("kplx") + ")";
                                        dalClient.update(sql);
                                    }
                                }
                                
                                // 查询本月已申报机器数量
                                String sqlCount = "select count(ID) as num from SKQ_SBSJ where NSRWJBM='" + nsrwjbm + "' and SSKSSJ>='" + startdate + "' and SSJZSJ<='" + enddate + "' and SBLX=1";
                                Long ysbjqsl = dalClient.queryColumn(sqlCount, "num");
                                int sbflag = 1;
                                int jqsl = nsrxx.getJqxxList().size();
                                String jqmsg = "";
                                if ((jqsl - ysbjqsl) > 0) {
                                    sbflag = 0;
                                    jqmsg = "您共有 " + jqsl + " 台机器，已申报  " + ysbjqsl + "台，还有 " + (jqsl - ysbjqsl)
                                            + " 台未申报";
                                } else {
                                    jqmsg = "您共有 " + jqsl + " 台机器，已全部申报";
                                }
                                List alJdsb = new ArrayList();
                                // 上月第一天
                                String previousMonthFirst = Util.getPreviousMonthFirst();
                                // 上月最后一天
                                String previousMonthEnd = Util.getPreviousMonthEnd();
                                String sql2 = "select * from SKQ_SBSJ where NSRWJBM='" + nsrxx.getNsrwjbm() + "' and SSKSSJ>='"
                                        + startdate + "' and SSJZSJ<='" + enddate + "' and SBLX=2";
                                alJdsb = dalClient.queryForObjectList(sql2, SkqSbsj.class);
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
    public String jkhcdk(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        HashMap CARDINFO = (HashMap) session.getAttribute("UCARDINFO");
        if (CARDINFO == null || CARDINFO.isEmpty()) {
            request.setAttribute("errorMsg", "申报数据保存失败！");
            return "/cxtj/error";
        } else {
            HashMap kxx = (HashMap) CARDINFO.get("EF02");
            HashMap EF01 = (HashMap) CARDINFO.get("EF01");
            HashMap EF06 = (HashMap) CARDINFO.get("EF06");
            String jqbh = (String) EF06.get("JQBH");
            String card_nsrwjbm = (String) kxx.get("NSRWJDM");
            SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(card_nsrwjbm);
            int status = nsrxx.getStatus();
            if (status != 1) {
                request.setAttribute("errorMsg", "纳税户已注销！");
                return "/cxtj/error";
            } else {
                String swjgbm = nsrxx.getSwjgbm();
                HashMap EF02 = (HashMap) CARDINFO.get("EF02");
                HashMap EF04 = (HashMap) CARDINFO.get("EF04");
                String old_nsrwjbm = (String) EF02.get("NSRWJDM");
                String kpjzrq = (String) EF01.get("KPJZRQ");
                String skkh = (String) EF06.get("SKKH");
                SkqJqxx skqJqxx = skqJqxxService.getJqxxByJqbh(jqbh);
                HashMap hmJkhc = new HashMap();
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
                String smStr = "";
                for (int i = 0; i < skqJqxx.getJqszsmList().size(); i++) {
                    SkqJqszsm szsm = skqJqxx.getJqszsmList().get(i);
                    Integer smsy = szsm.getSmsy();
                    String smsyStr = StringUtil.charFront(smsy.toString(), 2, "0");
                    String sm = smsyStr + "," + szsm.getSmbm() + "," + szsm.getSl().intValue() + "," + szsm.getSmjc();
                    smStr = smStr + "<input type=\"hidden\" name=\"tax" + i + "\" id=\"tax" + i + "\"  value=\"" + sm
                            + "\" />";
                }
                int length = skqJqxx.getJqszsmList().size();
                if (length < 20) {

                    for (int i = 0; i < 20 - length; i++) {
                        smStr = smStr + "<input type=\"hidden\" name=\"tax" + (i + length) + "\" id=\"tax"
                                + (i + length) + "\"  value=\"\" />";
                    }
                }
                setAttr("smStr", smStr);
                String sbsjSql = "select id from skq_sbsj " + " where (XZZT=0 or XZZT is null) and JQBH='" + jqbh + "'";
                Long sid = dalClient.queryColumn(sbsjSql, "id");
                int sblx = 1;
                if (sid != 0) {
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

                return "/sbsj/jkhc.hc";

            }
        }

    }

    @RequestMapping("/updateKpxe")
    public String updateKpxe(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String kpjzrq = request.getParameter("kpjzrq");
        String jqbh = request.getParameter("jqbh");
        double dzkpxe = Double.parseDouble(request.getParameter("dzkpxe"));
        double yljkpxe = Double.parseDouble(request.getParameter("yljkpxe"));
        double yljtpxe = Double.parseDouble(request.getParameter("yljtpxe"));
        String mac = request.getParameter("mac");
        kpjzrq = Util.tobzrq(kpjzrq);
        SkqJqxx jqxx=skqJqxxService.getJqxxByJqbh(jqbh);
        jqxx.setKpjzrq(DateUtil.parse(kpjzrq,"yyyy-MM-dd"));
        jqxx.setDzkpxe(dzkpxe);
        jqxx.setYljkpxe(yljkpxe);
        jqxx.setYljtpxe(yljtpxe);
        String sql = "update SKQ_JQXX set KPJZRQ='"+kpjzrq+"',DZKPXE="+dzkpxe+",YLJKPXE="+yljkpxe+",YLJTPXE="+yljtpxe+" where JQBH='"+jqbh+"'  and STATUS=1";
        dalClient.update(sql);
        String sbsjsql="select id from skq_sbsj "+" where (XZZT=0 or XZZT is null) and JQBH='"
                + jqbh + "'";
        Long sid=dalClient.queryColumn(sbsjsql, "id");
        if (sid != 0) {
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy-MM-dd");
            
            SkqSbsj sbsj = skqSbsjService.findById(sid, SkqSbsj.class);
            sbsj.setKpjzsj(DateUtil.parse(kpjzrq));
            sbsj.setDzkpxe(dzkpxe);
            sbsj.setYljkpxe(yljkpxe);
            sbsj.setYljtpxe(yljtpxe);
            sbsj.setCjrq(new Date());
            sbsj.setXzzt(1);
            sbsj.setXzrq(new Date());
            sbsj.setMac(mac);
            dalClient.update(sbsj);
        }
        
        return "/sbsj/sbsj";
    }
    @RequestMapping("/toSbsjDetail")
    public String toSbsjDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Long id=getParaToLong("id");
    	String sql="select a.JE as je,a.SMBM as smbm,a.KPLX as kplx,b.SL as sl,b.SMMC as smmc from SKQ_SBSJMX a left outer join SKQ_PMSZ b on a.SMBM=b.SMBM where a.PARENTID = "+id;
    	List<Map<String,Object>> detailList=dalClient.queryForObjectList(sql);
    	setAttr("detailList", detailList);
        return "/com/jdk2010/sbsj/skqsbsj/skqsbsj_detail";
    }
    

}

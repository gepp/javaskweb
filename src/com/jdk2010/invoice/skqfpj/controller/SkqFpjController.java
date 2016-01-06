package com.jdk2010.invoice.skqfpj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.Page;
import com.jdk2010.framework.util.ReturnData;
import com.jdk2010.framework.util.StringUtil;
import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpj.service.ISkqFpjService;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;
import com.jdk2010.invoice.skqfpjmx.service.ISkqFpjmxService;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jqxx.skqjqxx.service.ISkqJqxxService;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.service.ISkqNsrxxService;
import com.jdk2010.system.skqfp.service.ISkqFpService;
import com.jdk2010.tools.Constants;

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
    ISkqFpService skqFpService;

    @Resource
    DalClient dalClient;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DbKit dbKit = new DbKit("select * from skq_fpj  where 1=1 ");
        String searchSQL = "";
        String NSRWJBM = getPara("NSRWJBM");
        if (NSRWJBM != null && !"".equals(NSRWJBM)) {
            searchSQL = searchSQL + " and  NSRWJBM LIKE '%" + NSRWJBM + "%'";
            setAttr("NSRWJBM", NSRWJBM);
        }

        String SWJGBM = getPara("SWJGBM");
        if (SWJGBM != null && !"".equals(SWJGBM)) {
            searchSQL = searchSQL + " and  SWJGBM ='" + SWJGBM + "'";
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

        String startTime = getPara("startTime");
        if (startTime != null && !"".equals(startTime)) {
            searchSQL = searchSQL + " and  startTime>'" + startTime + " 00:00:00'";
            setAttr("startTime", startTime);
        }

        String endTime = getPara("endTime");
        if (endTime != null && !"".equals(endTime)) {
            searchSQL = searchSQL + " and  endTime<'" + endTime + " 23:59:59'";
            setAttr("endTime", endTime);
        }

        dbKit.append(searchSQL);
        Page pageList = skqFpjService.queryForPageList(dbKit, getPage(), SkqFpj.class);
        setAttr("pageList", pageList);
        return "/com/jdk2010/invoice/skqfpj/skqfpj";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        String jqbh = getPara("jqbh");
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        SkqJqxx jqxx = skqJqxxService.getJqxxByJqbh(jqbh);
        setAttr("nsrxx", nsrxx);
        setAttr("jqxx", jqxx);
        List<Map<String, Object>> fpList = skqFpService.queryForList("select * from skq_fp where status=1");
        setAttr("fpList", fpList);

        String fpdm = "";
        List<Map<String, Object>> fpdmList = skqFpService.queryForList("select * from skq_fpjmx where nsrwjbm='"
                + nsrwjbm + "' order by fplgrq desc limit 1");
        if (fpdmList.size() > 0) {
            fpdm = fpdmList.get(0).get("fpdm") + "";
        }
        setAttr("fpdm", fpdm);

        setAttr("FPZS", Constants.FPZS);
        return "/com/jdk2010/invoice/skqfpj/skqfpj_add";
    }
    
    @RequestMapping("/addWlkp")
    public String addWlkp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = getPara("nsrwjbm");
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        setAttr("nsrxx", nsrxx);
        List<Map<String, Object>> fpList = skqFpService.queryForList("select * from skq_fp where status=1");
        setAttr("fpList", fpList);
        String fpdm = "";
        List<Map<String, Object>> fpdmList = skqFpService.queryForList("select * from skq_fpjmx where nsrwjbm='"
                + nsrwjbm + "' order by fplgrq desc limit 1");
        if (fpdmList.size() > 0) {
            fpdm = fpdmList.get(0).get("fpdm") + "";
        }
        setAttr("fpdm", fpdm);
        setAttr("FPZS", Constants.FPZS);
        return "/com/jdk2010/invoice/skqfpj/skqfpj_wlfpadd";
    }

    @RequestMapping("/addaction")
    public void addaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String flag = Constants.SUCCESS;
        String message = "操作成功！";

        SkqFpj skqFpj = getModel(SkqFpj.class);
        String nsrwjbm = getPara("nsrwjbm");
        skqFpj.setNsrwjbm(nsrwjbm);
        skqFpj.setFplgrq(new Date());
        String fpjy = getPara("fpjy");
        if (fpjy != null) {
            String sql = "select id from SKQ_FPJ  where (FPQSH >=" + skqFpj.getFpqsh() + " and FPQSH<="
                    + skqFpj.getFpjzh() + " and FPDM='" + skqFpj.getFpdm() + "') or (FPJZH >=" + skqFpj.getFpqsh()
                    + " and FPJZH<=" + skqFpj.getFpjzh() + " and FPDM='" + skqFpj.getFpdm() + "')";
            Long id = dalClient.queryColumn(sql, "id");
            System.out.println("id:" + id);
            if (id != null) {
                flag = Constants.ERROR;
                message = "发票已领购，请重新输入！";
            } else {
                skqFpjService.saveFpj(skqFpj);
            }
        } else {
            skqFpjService.saveFpj(skqFpj);
        }

        ReturnData returnData = new ReturnData(flag, message);
        renderJson(response,returnData);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqFpj skqFpj = skqFpjService.findById(id, SkqFpj.class);
        setAttr("skqFpj", skqFpj);
        return "/com/jdk2010/invoice/skqfpj/skqfpj_modify";
    }

    @RequestMapping("/modifyaction")
    public void modifyaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkqFpj skqFpj = getModel(SkqFpj.class);
        skqFpjService.update(skqFpj);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ids = getPara("ids");
        skqFpjService.deleteByIDS(ids, SkqFpj.class);
        ReturnData returnData = new ReturnData(Constants.SUCCESS, "操作成功");
        renderJson(response,returnData);
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = getPara("id");
        SkqFpj skqFpj = skqFpjService.findById(id, SkqFpj.class);
        setAttr("skqFpj", skqFpj);
        return "/com/jdk2010/invoice/skqfpj/skqfpj_view";
    }

    @RequestMapping("/toFpgm")
    public String toFpgm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/invoice/invoice";
    }
    @RequestMapping("/wlfpgmImport")
    public String wlfpgmImport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/invoice/wlfpgmImport";
    }
    @RequestMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap CARDINFO = (HashMap) getSessionAttr("UCARDINFO");
        if (CARDINFO == null || CARDINFO.isEmpty()) {
            request.setAttribute("errorMsg", "基础信息读取失败！");
            return "/cxtj/error";
        } else {
            HashMap kxx = (HashMap) CARDINFO.get("EF02");
            HashMap EF06 = (HashMap) CARDINFO.get("EF06");
            String jqbh = (String) EF06.get("JQBH");
            
            ArrayList cardInvoice = new ArrayList();
            setSessionAttr("cardInvoice", cardInvoice);
            
            cardInvoice = (ArrayList) CARDINFO.get("EF05");
            String card_nsrwjbm = (String) kxx.get("NSRWJDM");
            String new_wjbm=dalClient.queryColumn("select NEW_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and old_wjbm='"+card_nsrwjbm+"'", "NEW_WJBM");
            SkqJqxx jqxx = dalClient.queryForObject("select * from skq_jqxx where nsrwjbm='" + new_wjbm
                    + "' and jqbh='" + jqbh + "'", SkqJqxx.class);
            if (jqxx == null) {
                request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为：" + card_nsrwjbm + ",机器编号为：" + jqxx);
                return "/cxtj/error";
            } else {
                if (jqxx.getStatus() != 1) {
                    request.setAttribute("errorMsg", "机器已经注销！");
                    return "/cxtj/error";
                }
                setSessionAttr("cardInvoice", cardInvoice);
                int hasInvoiceSize=0;
                for(int i=0;i<cardInvoice.size();i++){
                	Map map=(Map) cardInvoice.get(i);
                	String FPDM=map.get("FPDM")+"";
                	String JS=map.get("JS")+"";
                	String QSH=map.get("QSH")+"";
                	String JZH=map.get("JZH")+"";
                	if((!FPDM.equals("00000000000000000000"))&&(!JS.equals("0"))){
                		hasInvoiceSize++;
                	}
                }
                setAttr("hasInvoiceSize", hasInvoiceSize);
                return FORWARD + "/skqfpj/fpList.htm?jqbh=" + jqbh + "&nsrwjbm=" + new_wjbm;

            }

        }

    }
    
    @RequestMapping("/infoSt")
    public String infoSt(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userinfo = request.getParameter("userinfo");
    	String dkxx = request.getParameter("dkxx");
    	
		String[] userinfo_arr = userinfo.split("\\^");
		String card_nsrwjbm = userinfo_arr[0];
		String jqbh = userinfo_arr[4];
		
		String new_wjbm=dalClient.queryColumn("select NEW_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and old_wjbm='"+card_nsrwjbm+"'", "NEW_WJBM");
        SkqJqxx jqxx = dalClient.queryForObject("select * from skq_jqxx where nsrwjbm='" + new_wjbm
                + "' and jqbh='" + jqbh + "'", SkqJqxx.class);
        if (jqxx == null) {
            request.setAttribute("errorMsg", "纳税户不存在！用户卡中纳税户微机编码为：" + card_nsrwjbm + ",机器编号为：" + jqxx);
            return "/cxtj/error";
        } else {
            if (jqxx.getStatus() != 1) {
                request.setAttribute("errorMsg", "机器已经注销！");
                return "/cxtj/error";
            }
            //
            ArrayList cardInvoice = new ArrayList();
            setSessionAttr("cardInvoice", cardInvoice);
			if(dkxx==null||"".equals(dkxx)){
				
			}
			else{
				String[] dkxx_arr = dkxx.split("\\|");
				for(int i=0;i<dkxx_arr.length;i++){
					String one_fpxx = dkxx_arr[i];
					String[] one_fpxx_arr = one_fpxx.split("\\^");
					//System.out.println("one_fpxx_arr======="+one_fpxx_arr);
					HashMap fpxx = new HashMap();
					fpxx.put("userno", one_fpxx_arr[0]);
					fpxx.put("SKKBH", one_fpxx_arr[1]);
					fpxx.put("SKSKJJQBH", one_fpxx_arr[2]);
					fpxx.put("FPDM", one_fpxx_arr[3]);
					fpxx.put("QSH", Integer.parseInt(one_fpxx_arr[4]));
					fpxx.put("JZH", Integer.parseInt(one_fpxx_arr[5]));
					fpxx.put("JS", Integer.parseInt(one_fpxx_arr[6]));
					cardInvoice.add(fpxx);
				}						
			}
			
			setSessionAttr("cardInvoice", cardInvoice);
            int hasInvoiceSize=0;
            for(int i=0;i<cardInvoice.size();i++){
            	Map map=(Map) cardInvoice.get(i);
            	String FPDM=map.get("FPDM")+"";
            	String JS=map.get("JS")+"";
            	String QSH=map.get("QSH")+"";
            	String JZH=map.get("JZH")+"";
            	if((!FPDM.equals("00000000000000000000"))&&(!JS.equals("0"))){
            		hasInvoiceSize++;
            	}
            }
            setAttr("hasInvoiceSize", hasInvoiceSize);
            return FORWARD + "/skqfpj/fpList.htm?jqbh=" + jqbh + "&nsrwjbm=" + new_wjbm;

        }

    }

    

    @RequestMapping("/fpList")
    public String fpList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
    
    @RequestMapping("/wlfplist")
    public String wlfplist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = request.getParameter("nsrwjbm");
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        setAttr("nsrxx", nsrxx);
        List<SkqFpjmx> alFp = skqFpjService.selectFpxf(nsrwjbm);
        setAttr("alFp", alFp);
        return "/invoice/invoice.wlfplist";
    }

    @RequestMapping("/fpxk")
    public String fpxk(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nsrwjbm = request.getParameter("nsrwjbm");
        String jqbh = request.getParameter("jqbh");
        String fpqshInfoStr = request.getParameter("fpqshInfoStr");
        String[] fpqshInfoArr = fpqshInfoStr.split(",");
        int fpqsh = 0;
        String fpdm = "";
        String strSql = "";
        for (int i = 0; i < fpqshInfoArr.length; i++) {
            String str = fpqshInfoArr[i];
            String[] strArr = str.split("\\~");
            fpqsh = Integer.parseInt(strArr[0]);
            fpdm = strArr[1];
            if ("".equals(strSql)) {
                strSql = " and ((FPQSH=" + fpqsh + " and FPDM='" + fpdm + "')";
            } else {
                strSql = strSql + " or (FPQSH=" + fpqsh + " and FPDM='" + fpdm + "')";
            }
        }
        strSql = strSql + ")";
        String sql = "select * from SKQ_FPJMX where FPXFZT = 0 " + strSql;
        List<SkqFpjmx> alFp = dalClient.queryForObjectList(sql, SkqFpjmx.class);
        SkqNsrxx nsrxx = skqNsrxxService.getNsrxxByNsrwjbm(nsrwjbm);
        SkqJqxx jqxx = skqJqxxService.getJqxxByJqbh(jqbh);
        setAttr("nsrxx", nsrxx);
        setAttr("jqxx", jqxx);
        String OLD_WJBM=dalClient.queryColumn("select OLD_WJBM from skq_wjbmdy where jqbh='"+jqbh+"' and new_wjbm='"+nsrxx.getNsrwjbm()+"'", "OLD_WJBM");
        setAttr("OLD_WJBM", OLD_WJBM);
        request.setAttribute("alFp", alFp);
        request.setAttribute("fpqshInfoStr", fpqshInfoStr);

        // 组装桌面隐藏hiddenFpj
        String hiddenFpj = "";
        String hiddenFpjSt = "";
        HashMap CARDINFO = (HashMap) getSessionAttr("UCARDINFO");
        ArrayList cardInvoice = (ArrayList) getSessionAttr("cardInvoice");
        Iterator iterator=cardInvoice.iterator();
        while(iterator.hasNext()){
        	HashMap hm = (HashMap) iterator.next();
        	 String FPDM=hm.get("FPDM")+"";
         	 String JS=hm.get("JS")+"";
         	if((FPDM.equals("00000000000000000000"))&&(JS.equals("0"))){
        		iterator.remove();
        	}
        }
        
        for (int i = 0; i < cardInvoice.size(); i++) {
            HashMap hm = (HashMap) cardInvoice.get(i);
            String FPDM=hm.get("FPDM")+"";
        	String JS=hm.get("JS")+"";
        	String QSH=hm.get("QSH")+"";
        	String JZH=hm.get("JZH")+"";
            String fpqshStr = StringUtil.charFront(hm.get("QSH").toString(), 8, "0");
            String fpjzhStr = StringUtil.charFront(hm.get("JZH").toString(), 8, "0");
            String fpxi = (String) hm.get("FPDM") + "," + fpqshStr + "," + fpjzhStr + "," + hm.get("JS");
            hiddenFpj = hiddenFpj + "<input type=\"hidden\" id=\"fpxi_" + jqxx.getYhkh() + "_" + i + "\" name=\"fpxi_"
                    + jqxx.getYhkh() + "_" + i + "\" value=\"" + fpxi + "\" />";
            
            String fpxi_st = OLD_WJBM+"^"+jqxx.getSkkh()+"^"+jqxx.getJqbh()+"^"+(String)hm.get("FPDM")+"^"+fpqshStr+"^"+fpjzhStr+"^"+(Integer)hm.get("JS");
            
            hiddenFpjSt = hiddenFpjSt+"<input type=\"hidden\" id=\"fpxi_st_"+i+"\" name=\"fpxi_st_"+i+"\" value=\""+fpxi_st+"\" />";
        }
        int cardSize = cardInvoice.size();
        for (int i = 0; i < alFp.size(); i++) {
            SkqFpjmx mx = alFp.get(i);
            String fpqshStr = StringUtil.charFront(mx.getFpqsh().toString(), 8, "0");
            String fpjzhStr = StringUtil.charFront(mx.getFpjzh().toString(), 8, "0");
            String fpxi = (String) mx.getFpdm() + "," + fpqshStr + "," + fpjzhStr + "," + mx.getFpdw();
            hiddenFpj = hiddenFpj + "<input type=\"hidden\" id=\"fpxi_" + jqxx.getYhkh() + "_" + (i + cardSize)
                    + "\" name=\"fpxi_" + jqxx.getYhkh() + "_" + (i + cardSize) + "\" value=\"" + fpxi + "\" />";
            
            String fpxi_st = OLD_WJBM+"^"+jqxx.getSkkh()+"^"+jqxx.getJqbh()+"^"+(String) mx.getFpdm()+"^"+fpqshStr+"^"+fpjzhStr+"^"+mx.getFpdw();
            hiddenFpjSt = hiddenFpjSt+"<input type=\"hidden\" id=\"fpxi_st_"+(i + cardSize)+"\" name=\"fpxi_st_"+(i + cardSize)+"\" value=\""+fpxi_st+"\" />";
        }

        int total = cardInvoice.size() + alFp.size();
        if (total < 10) {
            for (int m = total; m < 10; m++) {
                hiddenFpj = hiddenFpj + "<input type=\"hidden\" id=\"fpxi_" + jqxx.getYhkh() + "_" + m
                        + "\" name=\"fpxi_" + jqxx.getYhkh() + "_" + m + "\" value=\"\" />";
                
                hiddenFpjSt = hiddenFpjSt+"<input type=\"hidden\" id=\"fpxi_st_"+m+"\" name=\"fpxi_st_"+m+"\" value=\"\" />";
            }
        }
        setAttr("hiddenFpj", hiddenFpj);
        setAttr("hiddenFpjSt", hiddenFpjSt);
        return "/invoice/invoice.xk";
    }

    @RequestMapping("/updateXkbz")
    public void updateXkbz(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fpqshInfoStr = request.getParameter("fpqshInfoStr");
        String[] fpqshInfoArr = fpqshInfoStr.split(",");
        int fpqsh = 0;
        String fpdm = "";
        String strSql = "";
        for (int i = 0; i < fpqshInfoArr.length; i++) {
            String str = fpqshInfoArr[i];
            String[] strArr = str.split("\\~");
            fpqsh = Integer.parseInt(strArr[0]);
            fpdm = strArr[1];
            if ("".equals(strSql)) {
                strSql = " and ((FPQSH=" + fpqsh + " and FPDM='" + fpdm + "')";
            } else {
                strSql = strSql + " or (FPQSH=" + fpqsh + " and FPDM='" + fpdm + "')";
            }
        }
        strSql = strSql + ")";
        String sql = "select * from SKQ_FPJMX where FPXFZT = 0 " + strSql;
        List<SkqFpjmx> alFp = dalClient.queryForObjectList(sql, SkqFpjmx.class);
        String jqbh=getPara("jqbh");
        for (int i = 0; i < alFp.size(); i++) {
            SkqFpjmx fpjmx = alFp.get(i);
            String updateSql = "update SKQ_FPJMX set FPXFZT=1,jqbh='"+jqbh+"' where FPDM='" + fpjmx.getFpdm() + "' and FPQSH="
                    + fpjmx.getFpqsh();
            dalClient.update(updateSql);
        }

    }

}

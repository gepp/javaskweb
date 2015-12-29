package com.jdk2010.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdk2010.base.security.securityorganization.model.SecurityOrganization;
import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdckp.model.SkqBdckp;
import com.jdk2010.bdc.skqbdclp.model.SkqBdclp;
import com.jdk2010.bdc.skqbdcmm.model.SkqBdcmm;
import com.jdk2010.bdc.skqbdcxmmx.model.SkqBdcxmmx;
import com.jdk2010.bdc.skqbdczxm.model.SkqBdczxm;
import com.jdk2010.framework.controller.BaseController;
import com.jdk2010.framework.dal.cache.support.ehcache.EhCacheCacheManager;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.framework.util.JsonUtil;
import com.jdk2010.invoice.skqfpj.model.SkqFpj;
import com.jdk2010.invoice.skqfpjmx.model.SkqFpjmx;
import com.jdk2010.invoice.skqfpkj.model.SkqFpkj;
import com.jdk2010.invoice.skqfpkjxm.model.SkqFpkjxm;
import com.jdk2010.jqxx.skqjqszsm.model.SkqJqszsm;
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.jzaz.skqjzaz.model.SkqJzaz;
import com.jdk2010.jzaz.skqjzazkp.model.SkqJzazkp;
import com.jdk2010.nsrxx.skqdhde.model.SkqDhde;
import com.jdk2010.nsrxx.skqnsrszsm.model.SkqNsrszsm;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqWjbmdy;
import com.jdk2010.nsrxx.skqnsrxx.model.TransDmSwjg;
import com.jdk2010.nsrxx.skqnsrxx.model.TransDmZspm;
import com.jdk2010.nsrxx.skqxebg.model.SkqXebg;
import com.jdk2010.sbsj.skqhzsj.model.SkqHzsj;
import com.jdk2010.sbsj.skqhzsjmx.model.SkqHzsjmx;
import com.jdk2010.sbsj.skqjksjkz.model.SkqJksjkz;
import com.jdk2010.sbsj.skqsbsj.model.SkqSbsj;
import com.jdk2010.sbsj.skqsbsjmx.model.SkqSbsjmx;
import com.jdk2010.sbsj.skqwdhxh.model.SkqWdhxh;
import com.jdk2010.system.skqfp.model.SkqFp;
import com.jdk2010.system.skqhy.model.SkqHy;
import com.jdk2010.system.skqhymx.model.SkqHymx;
import com.jdk2010.system.skqjqxh.model.SkqJqxh;
import com.jdk2010.system.skqpmsz.model.SkqPmsz;
import com.jdk2010.system.skqzclx.model.SkqZclx;

@Controller
@RequestMapping(value = "/")
public class SjyzController extends BaseController {

	@Resource
	DalClient dalClient;

	@Resource
	DalClient sybaseDalClient;

	@Resource
	EhCacheCacheManager ehCacheCacheManager;

	@RequestMapping("/sjyz")
	public void sjyz(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long beginTime = System.currentTimeMillis();
		List<String> yzList = new CopyOnWriteArrayList<String>();
		System.out.println("=============移植开始=============");
		Long okBeginTime = System.currentTimeMillis();
		Long okEndTime = System.currentTimeMillis();
		yzList.add("=============移植开始=============");
		yzList.add("导入时间：" + DateUtil.getNowTime());
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);
		okBeginTime = System.currentTimeMillis();
		int skq_bdc = yz_SKQ_BDC();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDC移植成功！共移植:" + skq_bdc + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_BDCKP = yz_SKQ_BDCKP();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDCKP移植成功！共移植:" + SKQ_BDCKP + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_BDCLP = yz_SKQ_BDCLP();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDCLP移植成功！共移植:" + SKQ_BDCLP + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_BDCMM = yz_SKQ_BDCMM();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDCMM移植成功！共移植:" + SKQ_BDCMM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_BDCXMMX = yz_SKQ_BDCXMMX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDCXMMX移植成功！共移植:" + SKQ_BDCXMMX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_BDCZXM = yz_SKQ_BDCZXM();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_BDCZXM移植成功！共移植:" + SKQ_BDCZXM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_DHDE = yz_SKQ_DHDE();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_DHDE移植成功！共移植:" + SKQ_DHDE + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_FP = yz_SKQ_FP();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_FP移植成功！共移植:" + SKQ_FP + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_FPJ = yz_SKQ_FPJ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_FPJ移植成功！共移植:" + SKQ_FPJ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_FPJMX = yz_SKQ_FPJMX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_FPJMX移植成功！共移植:" + SKQ_FPJMX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_FPKJ = yz_SKQ_FPKJ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_FPKJ移植成功！共移植:" + SKQ_FPKJ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_FPKJXM = yz_SKQ_FPKJXM();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_FPKJXM移植成功！共移植:" + SKQ_FPKJXM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_HY = yz_SKQ_HY();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_HY移植成功！共移植:" + SKQ_HY + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_HYMX = yz_SKQ_HYMX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_HYMX移植成功！共移植:" + SKQ_HYMX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_HZSJ = yz_SKQ_HZSJ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_HZSJ移植成功！共移植:" + SKQ_HZSJ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_HZSJMX = yz_SKQ_HZSJMX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_HZSJMX移植成功！共移植:" + SKQ_HZSJMX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JKSJKZ = yz_SKQ_JKSJKZ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JKSJKZ移植成功！共移植:" + SKQ_JKSJKZ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JQSZSM = yz_SKQ_JQSZSM();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JQSZSM移植成功！共移植:" + SKQ_JQSZSM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JQXH = yz_SKQ_JQXH();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JQXH移植成功！共移植:" + SKQ_JQXH + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JQXX = yz_SKQ_JQXX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JQXX移植成功！共移植:" + SKQ_JQXX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JZAZ = yz_SKQ_JZAZ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JZAZ移植成功！共移植:" + SKQ_JZAZ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_JZAZKP = yz_SKQ_JZAZKP();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_JZAZKP移植成功！共移植:" + SKQ_JZAZKP + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_NSRSZSM = yz_SKQ_NSRSZSM();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_NSRSZSM移植成功！共移植:" + SKQ_NSRSZSM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_NSRXX = yz_SKQ_NSRXX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_NSRXX移植成功！共移植:" + SKQ_NSRXX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_SBSJ = yz_SKQ_SBSJ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_SBSJ移植成功！共移植:" + SKQ_SBSJ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_SBSJMX = yz_SKQ_SBSJMX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_SBSJMX移植成功！共移植:" + SKQ_SBSJMX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_SWJG = yz_SKQ_SWJG();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_SWJG移植成功！共移植:" + SKQ_SWJG + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_WDHXH = yz_SKQ_WDHXH();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_WDHXH移植成功！共移植:" + SKQ_WDHXH + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_XEBG = yz_SKQ_XEBG();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_XEBG移植成功！共移植:" + SKQ_XEBG + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_ZCLX = yz_SKQ_ZCLX();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_ZCLX移植成功！共移植:" + SKQ_ZCLX + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_PMSZ = yz_SKQ_PMSZ();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_PMSZ移植成功！共移植:" + SKQ_PMSZ + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_WJBMDY = yz_SKQ_WJBMDY();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_WJBMDY移植成功！共移植:" + SKQ_WJBMDY + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int TRANS_DM_SWJG = yz_TRANS_DM_SWJG();
		okEndTime = System.currentTimeMillis();
		yzList.add("TRANS_DM_SWJG移植成功！共移植:" + TRANS_DM_SWJG + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int TRANS_DM_ZSPM = yz_TRANS_DM_ZSPM();
		okEndTime = System.currentTimeMillis();
		yzList.add("TRANS_DM_ZSPM移植成功！共移植:" + TRANS_DM_ZSPM + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		okBeginTime = System.currentTimeMillis();
		int SKQ_USER = yz_SKQ_USER();
		okEndTime = System.currentTimeMillis();
		yzList.add("SKQ_USER移植成功！共移植:" + SKQ_USER + "条记录！共耗时："
				+ ((okEndTime - okBeginTime) / 1000) + "秒");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		Long endTime = System.currentTimeMillis();
		yzList.add("移植结束时间：" + DateUtil.getNowTime());
		yzList.add("移植成功！共耗时：" + (endTime - beginTime) / 1000 / 60 + "分钟");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

		yzList.add("=============移植结束=============");
		ehCacheCacheManager.getEhCache("metaCache").put("yzList", yzList);

	}

	public Map<String, Object> transLanguage(boolean yzFlag,
			Map<String, Object> paramMap) throws UnsupportedEncodingException {
		if (getParaToBoolean("yzFlag")) {
			for (String key : paramMap.keySet()) {
				Object value = paramMap.get(key);
				if (value instanceof String) {
					value = new String((value + "").getBytes("iso8859-1"),
							"gbk");
					paramMap.put(key, value);
				}
			}
		}
		return paramMap;
	}

	public int yz_SKQ_BDC() throws UnsupportedEncodingException {
		try {
			List<SkqBdc> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_BDC t", SkqBdc.class);
			System.out.println("总共：" + list.size() + "条记录等待移植...");
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap);
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
		}

	}

	public int yz_SKQ_BDCKP() throws UnsupportedEncodingException {
		try {
			List<SkqBdckp> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_BDCKP t", SkqBdckp.class);
			System.out.println("总共：" + list.size() + "条记录等待移植...");
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap);
				dalClient.save(sql, paramMap);
			}

			return list.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_BDCLP() throws UnsupportedEncodingException {
		try {
			List<SkqBdclp> bdclpList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_BDCLP t", SkqBdclp.class);
			System.out.println("总共：" + bdclpList.size() + "条记录等待移植...");
			for (int i = 0; i < bdclpList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(bdclpList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return bdclpList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_BDCMM() throws UnsupportedEncodingException {
		try {
			List<SkqBdcmm> bdcmmList = sybaseDalClient.queryForObjectList(
					"select  t.* from SKQ_BDCMM t", SkqBdcmm.class);
			for (int i = 0; i < bdcmmList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(bdcmmList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return bdcmmList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_BDCXMMX() throws UnsupportedEncodingException {
		try {
			List<SkqBdcxmmx> bdcxmmxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_BDCXMMX t",
					SkqBdcxmmx.class);
			for (int i = 0; i < bdcxmmxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(bdcxmmxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return bdcxmmxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_BDCZXM() throws UnsupportedEncodingException {
		try {
			List<SkqBdczxm> bdczxmList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_BDCZXM t",
					SkqBdczxm.class);
			for (int i = 0; i < bdczxmList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(bdczxmList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return bdczxmList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_DHDE() throws UnsupportedEncodingException {

		try {
			List<SkqDhde> skqdhdeList = sybaseDalClient.queryForObjectList(
					"select  t.* from SKQ_DHDE t", SkqDhde.class);
			for (int i = 0; i < skqdhdeList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(skqdhdeList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return skqdhdeList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_FP() throws UnsupportedEncodingException {
		try {
			List<SkqFp> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id,t.* from SKQ_FP t", SkqFp.class);
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_FPJ() throws UnsupportedEncodingException {
		try {
			List<SkqFpj> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id,t.* from SKQ_FPJ t", SkqFpj.class);
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_FPJMX() throws UnsupportedEncodingException {
		try {
			List<SkqFpjmx> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id,t.* from SKQ_FPJMX t", SkqFpjmx.class);
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_FPKJ() throws UnsupportedEncodingException {
		try {
			List<SkqFpkj> list = sybaseDalClient.queryForObjectList(
					"select t.SID as id,t.* from SKQ_FPKJ t", SkqFpkj.class);
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_FPKJXM() throws UnsupportedEncodingException {
		try {
			List<SkqFpkjxm> list = sybaseDalClient
					.queryForObjectList(
							"select t.* from SKQ_FPKJXM t",
							SkqFpkjxm.class);
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(list.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return list.size();
		} catch (Exception e) {
			return 0;
 
		}
	}

	public int yz_SKQ_HY() throws UnsupportedEncodingException {
		try {
			List<SkqHy> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_HY t", SkqHy.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_HYMX() throws UnsupportedEncodingException {
		try {
			List<SkqHymx> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_HYMX t", SkqHymx.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				BigDecimal hy_id = sybaseDalClient.queryColumn(
						"select SID FROM SKQ_HY WHERE HYBM='"
								+ hyList.get(i).getHybm() + "'", "SID");
				paramMap.put("hyid", hy_id);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_HZSJ() throws UnsupportedEncodingException {
		try {
			List<SkqHzsj> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_HZSJ t", SkqHzsj.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_HZSJMX() throws UnsupportedEncodingException {
		try {
			List<SkqHzsjmx> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_HZSJMX t",
					SkqHzsjmx.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JKSJKZ() throws UnsupportedEncodingException {
		try {
			List<SkqJksjkz> hyList = sybaseDalClient.queryForObjectList(
					"select t.* from SKQ_JKSJKZ t", SkqJksjkz.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JQSZSM() throws UnsupportedEncodingException {
		try {
			List<SkqJqszsm> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_JQSZSM t",
					SkqJqszsm.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JQXH() throws UnsupportedEncodingException {
		try {
			List<SkqJqxh> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_JQXH t", SkqJqxh.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JQXX() throws UnsupportedEncodingException {
		try {
			List<SkqJqxx> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_JQXX t", SkqJqxx.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JZAZ() throws UnsupportedEncodingException {
		try {
			List<SkqJzaz> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_JZAZ t", SkqJzaz.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_JZAZKP() throws UnsupportedEncodingException {
		try {
			List<SkqJzazkp> hyList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_JZAZKP t",
					SkqJzazkp.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_NSRSZSM() throws UnsupportedEncodingException {
		try {
			List<SkqNsrszsm> hyList = sybaseDalClient.queryForObjectList(
					"select t.* from SKQ_NSRSZSM t", SkqNsrszsm.class);
			for (int i = 0; i < hyList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return hyList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_NSRXX() throws UnsupportedEncodingException {
		try {
			List<SkqNsrxx> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_NSRXX t", SkqNsrxx.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_SBSJ() throws UnsupportedEncodingException {
		try {
			List<SkqSbsj> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_SBSJ t", SkqSbsj.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_SBSJMX() throws UnsupportedEncodingException {
		try {
			List<SkqSbsjmx> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_SBSJMX t",
					SkqSbsjmx.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_SWJG() throws UnsupportedEncodingException {
		try {
			List<SecurityOrganization> swjgList = sybaseDalClient
					.queryForObjectList(
							"SELECT t.SID AS id, t.SWJGBM AS CODE,t.SWJGMC AS NAME,t.SWJGJC AS description,0 AS parent_id,t.STATUS AS STATUS ,t.SJSWJGBM AS sjswjgbm FROM SKQ_SWJG t",
							SecurityOrganization.class);
			for (int i = 0; i < swjgList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(swjgList.get(i), paramMap);
				BigDecimal parent_id = sybaseDalClient.queryColumn(
						"select SID FROM SKQ_SWJG WHERE SWJGBM='"
								+ swjgList.get(i).getSjswjgbm() + "'", "SID");
				if (parent_id == null) {
					parent_id = new BigDecimal(0);
				}
				paramMap.put("parent_id", parent_id);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return swjgList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_WDHXH() throws UnsupportedEncodingException {
		try {
			List<SkqWdhxh> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.* from SKQ_WDHXH t", SkqWdhxh.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_XEBG() throws UnsupportedEncodingException {
		try {
			List<SkqXebg> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_XEBG t", SkqXebg.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_ZCLX() throws UnsupportedEncodingException {
		try {
			List<SkqZclx> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_ZCLX t", SkqZclx.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_PMSZ() throws UnsupportedEncodingException {
		try {
			List<SkqPmsz> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.SID as id, t.* from SKQ_PMSZ t", SkqPmsz.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_WJBMDY() throws UnsupportedEncodingException {
		try {
			List<SkqWjbmdy> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.* from SKQ_WJBMDY t", SkqWjbmdy.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_TRANS_DM_SWJG() throws UnsupportedEncodingException {
		try {
			List<TransDmSwjg> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.* from TRANS_DM_SWJG t", TransDmSwjg.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_TRANS_DM_ZSPM() throws UnsupportedEncodingException {
		try {
			List<TransDmZspm> nsrxxList = sybaseDalClient.queryForObjectList(
					"select t.* from TRANS_DM_ZSPM t", TransDmZspm.class);
			for (int i = 0; i < nsrxxList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换
				dalClient.save(sql, paramMap);
			}
			return nsrxxList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	public int yz_SKQ_USER() throws UnsupportedEncodingException {
		try {
			List<SecurityUser> swjgList = sybaseDalClient
					.queryForObjectList(
							"SELECT t.SID AS id, t.USERNAME AS username,t.ACTUALNAME AS realname,t.PASSWORD AS userpwd,t.STATUS AS status,t.SWJGBM AS swjgbm from SKQ_USER t",
							SecurityUser.class);
			for (int i = 0; i < swjgList.size(); i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String sql = DbKit.warpsavesql(swjgList.get(i), paramMap);
				BigDecimal parent_id = sybaseDalClient.queryColumn(
						"select SID FROM SKQ_SWJG WHERE SWJGBM='"
								+ swjgList.get(i).getSwjgbm() + "'", "SID");
				if (parent_id == null) {
					parent_id = new BigDecimal(0);
				}
				paramMap.put("organization_id", parent_id);
				paramMap.put("userpwd", "de88e3e4ab202d87754078cbb2df6063"); // 12345678a
				paramMap = transLanguage(getParaToBoolean("yzFlag"), paramMap); // 判断是否需要将string类型的编码进行转换

				if (swjgList.get(i).getUsername().equals("system")) {
					continue;
				} else {
					dalClient.save(sql, paramMap);
					dalClient
							.update("insert into security_user_role(user_id,role_id) values("
									+ swjgList.get(i).getId() + "," + 9 + ")");
				}
			}

			return swjgList.size();
		} catch (Exception e) {
			return 0;
		}
	}

	@RequestMapping("/sjyzImport")
	public String sjyzImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/sjyz/sjyzImport";
	}

	@RequestMapping("/getProcess")
	public void getProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<String> yzList = (List<String>) ehCacheCacheManager.getEhCache(
				"metaCache").get("yzList");
		renderText(response, JsonUtil.toJson(yzList));
	}

}

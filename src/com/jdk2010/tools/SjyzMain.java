package com.jdk2010.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.base.security.securityorganization.model.SecurityOrganization;
import com.jdk2010.bdc.skqbdc.model.SkqBdc;
import com.jdk2010.bdc.skqbdckp.model.SkqBdckp;
import com.jdk2010.bdc.skqbdclp.model.SkqBdclp;
import com.jdk2010.bdc.skqbdcmm.model.SkqBdcmm;
import com.jdk2010.bdc.skqbdcxmmx.model.SkqBdcxmmx;
import com.jdk2010.bdc.skqbdczxm.model.SkqBdczxm;
import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;
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

public class SjyzMain {

	public static Map<String, Object> transLanguage(boolean yzFlag,
			Map<String, Object> paramMap) throws UnsupportedEncodingException {
		if (yzFlag) {
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

	static BeanFactory factory = new ClassPathXmlApplicationContext(
			"conf/spring/spring-dal.xml");
	static DalClient mysqlDalClient = (DalClient) factory.getBean("dalClient");
	static DalClient sybaseDalClient = (DalClient) factory
			.getBean("sybaseDalClient");
	static boolean yzFlag = true; // 是否转换编码，默认不转换

	public static int  yz_SKQ_BDC() throws UnsupportedEncodingException {
		List<SkqBdc> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_BDC t", SkqBdc.class);
		System.out.println("总共：" + list.size() + "条记录等待移植...");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap);
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_BDCKP() throws UnsupportedEncodingException {
		List<SkqBdckp> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_BDCKP t", SkqBdckp.class);
		System.out.println("总共：" + list.size() + "条记录等待移植...");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap);
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_BDCLP() throws UnsupportedEncodingException {
		List<SkqBdclp> bdclpList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_BDCLP t", SkqBdclp.class);
		System.out.println("总共：" + bdclpList.size() + "条记录等待移植...");
		for (int i = 0; i < bdclpList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(bdclpList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return bdclpList.size();
	}

	public static int  yz_SKQ_BDCMM() throws UnsupportedEncodingException {
		List<SkqBdcmm> bdcmmList = sybaseDalClient.queryForObjectList(
				"select  t.* from SKQ_BDCMM t", SkqBdcmm.class);
		for (int i = 0; i < bdcmmList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(bdcmmList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return bdcmmList.size();
	}

	public static int  yz_SKQ_BDCXMMX() throws UnsupportedEncodingException {
		List<SkqBdcxmmx> bdcxmmxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_BDCXMMX t", SkqBdcxmmx.class);
		for (int i = 0; i < bdcxmmxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(bdcxmmxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return bdcxmmxList.size();
	}

	public static int yz_SKQ_BDCZXM() throws UnsupportedEncodingException {
		List<SkqBdczxm> bdczxmList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_BDCZXM t", SkqBdczxm.class);
		for (int i = 0; i < bdczxmList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(bdczxmList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return bdczxmList.size();
	}

	public static int  yz_SKQ_DHDE() throws UnsupportedEncodingException {
		List<SkqDhde> skqdhdeList = sybaseDalClient.queryForObjectList(
				"select  t.* from SKQ_DHDE t", SkqDhde.class);
		for (int i = 0; i < skqdhdeList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(skqdhdeList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return skqdhdeList.size();
	}

	public static int  yz_SKQ_FP() throws UnsupportedEncodingException {
		List<SkqFp> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id,t.* from SKQ_FP t", SkqFp.class);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_FPJ() throws UnsupportedEncodingException {
		List<SkqFpj> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id,t.* from SKQ_FPJ t", SkqFpj.class);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_FPJMX() throws UnsupportedEncodingException {
		List<SkqFpjmx> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id,t.* from SKQ_FPJMX t", SkqFpjmx.class);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_FPKJ() throws UnsupportedEncodingException {
		List<SkqFpkj> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id,t.* from SKQ_FPKJ t", SkqFpkj.class);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_FPKJXM() throws UnsupportedEncodingException {
		List<SkqFpkjxm> list = sybaseDalClient.queryForObjectList(
				"select t.SID as id,t.* from SKQ_FPKJXM t", SkqFpkjxm.class);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(list.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return list.size();
	}

	public static int  yz_SKQ_HY() throws UnsupportedEncodingException {
		List<SkqHy> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_HY t", SkqHy.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_HYMX() throws UnsupportedEncodingException {
		List<SkqHymx> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_HYMX t", SkqHymx.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			BigDecimal hy_id=sybaseDalClient.queryColumn("select SID FROM SKQ_HY WHERE HYBM='"+hyList.get(i).getHybm()+"'","SID");
			paramMap.put("hyid", hy_id);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_HZSJ() throws UnsupportedEncodingException {
		List<SkqHzsj> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_HZSJ t", SkqHzsj.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_HZSJMX() throws UnsupportedEncodingException {
		List<SkqHzsjmx> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_HZSJMX t", SkqHzsjmx.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JKSJKZ() throws UnsupportedEncodingException {
		List<SkqJksjkz> hyList = sybaseDalClient.queryForObjectList(
				"select t.* from SKQ_JKSJKZ t", SkqJksjkz.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JQSZSM() throws UnsupportedEncodingException {
		List<SkqJqszsm> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_JQSZSM t", SkqJqszsm.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JQXH() throws UnsupportedEncodingException {
		List<SkqJqxh> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_JQXH t", SkqJqxh.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JQXX() throws UnsupportedEncodingException {
		List<SkqJqxx> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_JQXX t", SkqJqxx.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JZAZ() throws UnsupportedEncodingException {
		List<SkqJzaz> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_JZAZ t", SkqJzaz.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_JZAZKP() throws UnsupportedEncodingException {
		List<SkqJzazkp> hyList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_JZAZKP t", SkqJzazkp.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_NSRSZSM() throws UnsupportedEncodingException {
		List<SkqNsrszsm> hyList = sybaseDalClient.queryForObjectList(
				"select t.* from SKQ_NSRSZSM t", SkqNsrszsm.class);
		for (int i = 0; i < hyList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return hyList.size();
	}

	public static int  yz_SKQ_NSRXX() throws UnsupportedEncodingException {
		List<SkqNsrxx> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_NSRXX t", SkqNsrxx.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_SBSJ() throws UnsupportedEncodingException {
		List<SkqSbsj> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_SBSJ t", SkqSbsj.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_SBSJMX() throws UnsupportedEncodingException {
		List<SkqSbsjmx> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_SBSJMX t", SkqSbsjmx.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_SWJG() throws UnsupportedEncodingException {
		List<SecurityOrganization> swjgList = sybaseDalClient
				.queryForObjectList(
						"SELECT t.SID AS id, t.SWJGBM AS CODE,t.SWJGMC AS NAME,t.SWJGJC AS description,0 AS parent_id,t.STATUS AS STATUS ,t.SJSWJGBM AS sjswjgbm FROM SKQ_SWJG t",
						SecurityOrganization.class);
		for (int i = 0; i < swjgList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(swjgList.get(i), paramMap);
			BigDecimal parent_id=sybaseDalClient.queryColumn("select SID FROM SKQ_SWJG WHERE SWJGBM='"+swjgList.get(i).getSjswjgbm()+"'","SID");
			if(parent_id==null){
				parent_id=new BigDecimal(0);
			}
			paramMap.put("parent_id",parent_id);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return swjgList.size();
	}

	public static int  yz_SKQ_WDHXH() throws UnsupportedEncodingException {
		List<SkqWdhxh> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.* from SKQ_WDHXH t", SkqWdhxh.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_XEBG() throws UnsupportedEncodingException {
		List<SkqXebg> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_XEBG t", SkqXebg.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_ZCLX() throws UnsupportedEncodingException {
		List<SkqZclx> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_ZCLX t", SkqZclx.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_PMSZ() throws UnsupportedEncodingException {
		List<SkqPmsz> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.SID as id, t.* from SKQ_PMSZ t", SkqPmsz.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_SKQ_WJBMDY() throws UnsupportedEncodingException {
		List<SkqWjbmdy> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.* from SKQ_WJBMDY t", SkqWjbmdy.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}

	public static int  yz_TRANS_DM_SWJG() throws UnsupportedEncodingException {
		List<TransDmSwjg> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.* from TRANS_DM_SWJG t", TransDmSwjg.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}
	
	public static int yz_TRANS_DM_ZSPM() throws UnsupportedEncodingException {
		List<TransDmZspm> nsrxxList = sybaseDalClient.queryForObjectList(
				"select t.* from TRANS_DM_ZSPM t", TransDmZspm.class);
		for (int i = 0; i < nsrxxList.size(); i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
			paramMap = transLanguage(yzFlag, paramMap); // 判断是否需要将string类型的编码进行转换
			mysqlDalClient.save(sql, paramMap);
		}
		return nsrxxList.size();
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		 		yz_SKQ_BDC();
				yz_SKQ_BDCKP();
				yz_SKQ_BDCLP();
				yz_SKQ_BDCMM();
				yz_SKQ_BDCXMMX();
				yz_SKQ_BDCZXM();
				yz_SKQ_DHDE();
				yz_SKQ_FP();
				yz_SKQ_FPJ();
				yz_SKQ_FPJMX();
				yz_SKQ_FPKJ();
				yz_SKQ_FPKJXM();
				yz_SKQ_HY();
				yz_SKQ_HYMX();
				yz_SKQ_HZSJ();
				yz_SKQ_HZSJMX();
				yz_SKQ_JKSJKZ();
				yz_SKQ_JQSZSM();
				yz_SKQ_JQXH();
				yz_SKQ_JQXX();
				yz_SKQ_JZAZ();
				yz_SKQ_JZAZKP();
				yz_SKQ_NSRSZSM();
				yz_SKQ_NSRXX();
				yz_SKQ_SBSJ();
				yz_SKQ_SBSJMX();
				yz_SKQ_SWJG();
				yz_SKQ_WDHXH();
				yz_SKQ_XEBG();
				yz_SKQ_ZCLX();
				yz_SKQ_PMSZ();
				yz_SKQ_WJBMDY();
				yz_TRANS_DM_SWJG();
				yz_TRANS_DM_ZSPM();
				
	}
}

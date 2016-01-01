package com.jdk2010.tools;

import java.io.UnsupportedEncodingException;
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
import com.jdk2010.jqxx.skqjqxx.model.SkqJqxx;
import com.jdk2010.nsrxx.skqdhde.model.SkqDhde;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;
import com.jdk2010.sbsj.skqsbsj.model.SkqSbsj;
import com.jdk2010.sbsj.skqsbsjmx.model.SkqSbsjmx;
import com.jdk2010.system.skqhy.model.SkqHy;
import com.jdk2010.system.skqhymx.model.SkqHymx;
import com.jdk2010.system.skqpmsz.model.SkqPmsz;

public class SjyzMain {

    public static Map<String, Object> transLanguage(boolean yzFlag, Map<String, Object> paramMap)
            throws UnsupportedEncodingException {
        if (yzFlag) {
            for (String key : paramMap.keySet()) {
                Object value = paramMap.get(key);
                if (value instanceof String) {
                    value = new String((value + "").getBytes("iso8859-1"), "gb2312");
                    paramMap.put(key, value);
                }
            }
        }
        return paramMap;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
        DalClient mysqlDalClient = (DalClient) factory.getBean("dalClient");
        DalClient sybaseDalClient = (DalClient) factory.getBean("sybaseDalClient");
        // DalClient oracleDalClient = (DalClient) factory.getBean("oracleDalClient");
        boolean yzFlag = true; // 是否转换编码，默认不转换

//        System.out.println("======移植skq_nsrxx======");
//        List<SkqNsrxx> nsrxxList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_NSRXX t", SkqNsrxx.class);
//        System.out.println("总共：" + nsrxxList.size() + "条记录等待移植...");
//        for (int i = 0; i < nsrxxList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (nsrxxList.size() - i));
//        }
//        System.out.println("======移植skq_nsrxx结束======");
        
//        System.out.println("======移植SKQ_BDC======");
//        List<SkqBdc> bdcList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDC t", SkqBdc.class);
//        System.out.println("总共：" + bdcList.size() + "条记录等待移植...");
//        for (int i = 0; i < bdcList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdcList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdcList.size() - i));
//        }
//        System.out.println("======移植SKQ_BDC结束======");
        
        
//        System.out.println("======移植SKQ_BDCKP======");
//        List<SkqBdckp> bdckpList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDCKP t", SkqBdckp.class);
//        for (int i = 0; i < bdckpList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdckpList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdckpList.size() - i));
//        }
//        System.out.println("======移植SKQ_BDCKP结束======");
     
//        System.out.println("======移植SKQ_BDCLP======");
//        List<SkqBdclp> bdclpList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDCLP t", SkqBdclp.class);
//        for (int i = 0; i < bdclpList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdclpList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdclpList.size() - i));
//        }
//        System.out.println("======移植SKQ_BDCLP结束======");
        
//        System.out.println("======移植SKQ_BDCMM======");
//        List<SkqBdcmm> bdcmmList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDCMM t", SkqBdcmm.class);
//        for (int i = 0; i < bdcmmList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdcmmList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdcmmList.size() - i));
//        }
//        System.out.println("======移植SKQ_BDCMM结束======");
//     
//        System.out.println("======移植skq_bdcxmmx======");
//        List<SkqBdcxmmx> bdcxmmxList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDCXMMX t", SkqBdcxmmx.class);
//        for (int i = 0; i < bdcxmmxList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdcxmmxList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdcxmmxList.size() - i));
//        }
//        System.out.println("======移植SKQ_BDCMM结束======");
        
//        System.out.println("======移植skq_bdczxm======");
//        List<SkqBdczxm> bdczxmList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_BDCZXM t", SkqBdczxm.class);
//        for (int i = 0; i < bdczxmList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(bdczxmList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (bdczxmList.size() - i));
//        }
//        System.out.println("======移植skq_bdczxm结束======");
//        
//        System.out.println("======移植skq_dhde======");
//        List<SkqDhde> skqdhdeList = sybaseDalClient.queryForObjectList("select  t.* from SKQ_DHDE t", SkqDhde.class);
//        for (int i = 0; i < skqdhdeList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(skqdhdeList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (skqdhdeList.size() - i));
//        }
//        System.out.println("======移植skq_dhde结束======");
        
//        System.out.println("======移植skq_djhz 单卷汇总没有表======");
//        List<SkqDhde> skqdjhzList = sybaseDalClient.queryForObjectList("select  t.* from SKQ_DJHZ t", SkqDhde.class);
//        for (int i = 0; i < skqdjhzList.size(); i++) {
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            String sql = DbKit.warpsavesql(skqdjhzList.get(i), paramMap);
//            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//            mysqlDalClient.save(sql, paramMap);
//            System.out.println("剩余移植记录：" + (skqdjhzList.size() - i));
//        }
//        System.out.println("======移植skq_djhz结束======");
     
//      System.out.println("======移植skq_sbsj======");
//      List<SkqSbsj> skqsbsjList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_SBSJ t", SkqSbsj.class);
//      for (int i = 0; i < skqsbsjList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(skqsbsjList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (skqsbsjList.size() - i));
//      }
//      System.out.println("======移植skq_sbsj结束======");       
        
//      System.out.println("======移植skq_sbsjmx======");
//      List<SkqSbsjmx> skqsbsjmxList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_SBSJMX t", SkqSbsjmx.class);
//      for (int i = 0; i < skqsbsjmxList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(skqsbsjmxList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (skqsbsjmxList.size() - i));
//      }
//      System.out.println("======移植skq_sbsjmx结束======");       
      
//      System.out.println("======移植skq_jqxx======");
//      List<SkqJqxx> jqxxList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_JQXX t", SkqJqxx.class);
//      for (int i = 0; i < jqxxList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(jqxxList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (jqxxList.size() - i));
//      }
//      System.out.println("======移植skq_jqxx结束======");   
//      
//      System.out.println("======移植skq_pmsz======");
//      List<SkqPmsz> pmszList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_PMSZ t", SkqPmsz.class);
//      for (int i = 0; i < pmszList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(pmszList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (pmszList.size() - i));
//      }
//      System.out.println("======移植skq_pmsz结束======");   
      
//      System.out.println("======移植skq_hy======");
//      List<SkqHy> hyList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_HY t", SkqHy.class);
//      for (int i = 0; i < hyList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(hyList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (hyList.size() - i));
//      }
//      System.out.println("======移植skq_hy结束======");   
//      
//      System.out.println("======移植skq_hymx======");
//      List<SkqHymx> hymxList = sybaseDalClient.queryForObjectList("select t.SID as id, t.* from SKQ_HYMX t", SkqHymx.class);
//      for (int i = 0; i < hymxList.size(); i++) {
//          Map<String, Object> paramMap = new HashMap<String, Object>();
//          String sql = DbKit.warpsavesql(hymxList.get(i), paramMap);
//          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
//          mysqlDalClient.save(sql, paramMap);
//          System.out.println("剩余移植记录：" + (hymxList.size() - i));
//      }
//      System.out.println("======移植skq_hymx结束======");   
      
      System.out.println("======移植SKQ_SWJG======");
      List<SecurityOrganization> swjgList = sybaseDalClient.queryForObjectList("select t.SID as id, t.SWJGBM AS code,t.SWJGBM as name,t.SWJGJC as description,0 as parent_id,t.STATUS AS status from SKQ_SWJG t", SecurityOrganization.class);
      for (int i = 0; i < swjgList.size(); i++) {
          Map<String, Object> paramMap = new HashMap<String, Object>();
          String sql = DbKit.warpsavesql(swjgList.get(i), paramMap);
          paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
          mysqlDalClient.save(sql, paramMap);
          System.out.println("剩余移植记录：" + (swjgList.size() - i));
      }
      System.out.println("======移植SKQ_SWJG结束======");   
      
    }
}

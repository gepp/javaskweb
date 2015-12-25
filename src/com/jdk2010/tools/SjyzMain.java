package com.jdk2010.tools;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.framework.dal.client.DalClient;
import com.jdk2010.framework.util.DbKit;
import com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx;

public class SjyzMain {

    public static Map<String, Object> transLanguage(boolean yzFlag, Map<String, Object> paramMap)
            throws UnsupportedEncodingException {
        if (yzFlag) {
            for (String key : paramMap.keySet()) {
                Object value = paramMap.get(key);
                if (value instanceof String) {
                    value = new String((value + "").getBytes("iso8859-1"), "gbk");
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
        boolean yzFlag = false; // 是否转换编码，默认不转换
        // System.out.println("======移植t_hx_org_config======");
        // List<THxOrgConfig> listOrgConfig = oracleDalClient.queryForObjectList("select * from t_hx_org_config",
        // THxOrgConfig.class);
        // System.out.println("总共："+listOrgConfig.size()+"条记录等待移植...");
        // for (int i = 0; i < listOrgConfig.size(); i++) {
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // String sql = DbKit.warpsavesql(listOrgConfig.get(i), paramMap);
        // if (yzFlag) {
        // for (String key : paramMap.keySet()) {
        // Object value = paramMap.get(key);
        // if (value instanceof String) {
        // value = new String((value + "").getBytes("iso8859-1"), "gbk");
        // paramMap.put(key, value);
        // }
        // }
        // }
        // mysqlDalClient.save(sql, paramMap);
        // System.out.println("剩余移植记录："+(listOrgConfig.size()-i));
        // }
        // System.out.println("======移植t_hx_org_config结束======");

        System.out.println("======移植skq_nsrxx======");
        List<SkqNsrxx> nsrxxList = sybaseDalClient.queryForObjectList("select * from skq_nsrxx", SkqNsrxx.class);
        System.out.println("总共：" + nsrxxList.size() + "条记录等待移植...");
        for (int i = 0; i < nsrxxList.size(); i++) {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            String sql = DbKit.warpsavesql(nsrxxList.get(i), paramMap);
            paramMap = transLanguage(yzFlag, paramMap);  //判断是否需要将string类型的编码进行转换
            mysqlDalClient.save(sql, paramMap);
            System.out.println("剩余移植记录：" + (nsrxxList.size() - i));
        }
        System.out.println("======移植skq_nsrxx结束======");
    }
}

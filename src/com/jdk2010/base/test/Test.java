package com.jdk2010.base.test;

<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
=======
>>>>>>> 6b94057bf3a5a651e67b588c24dcfeb731ba8818
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdk2010.framework.dal.client.DalClient;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        BeanFactory factory = new ClassPathXmlApplicationContext("conf/spring/spring-dal.xml");
<<<<<<< HEAD
        DalClient sybaseDalClient=(DalClient)factory.getBean("sybaseDalClient");
        List<Map<String,Object>> mapList=sybaseDalClient.queryForObjectList("select * from SKQ_PMSZ");
    	for(Map<String,Object> map:mapList){
    		for(String key:map.keySet()){
    			System.out.println(new String((map.get(key)+"").getBytes("iso8859-1"),"gbk"));
    		}
    	}
//    	 try {
//             Class.forName("com.sybase.jdbc2.jdbc.SybDriver").newInstance();
//             String url = "jdbc:sybase:Tds:192.168.1.101:5000/wlsk";// 数据库名
//             Properties sysProps = System.getProperties();
//             sysProps.put("user", "sa"); // 设置数据库访问用户名
//             sysProps.put("password", ""); // 密码
//             Connection conn = DriverManager.getConnection(url, sysProps);
//             Statement stmt = conn
//                     .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                             ResultSet.CONCUR_UPDATABLE);
//             String sql = " select * from SKQ_BDC"; // 表
//             ResultSet rs = stmt.executeQuery(sql);
//             while (rs.next()) {
//                 System.out.println("oject_id:"+rs.getString(1)+",oject_name:"+rs.getString(2)); // 取得第二列的值
//             }
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
=======
        DalClient oracleDalClient=(DalClient)factory.getBean("oracleDalClient");
        List<Map<String,Object>> mapList=oracleDalClient.queryForObjectList("select * from BAK_T_HX_ORG_CONFIG t");
        for(Map<String,Object> map:mapList){
            System.out.println(map.get("saleorg"));
        }
>>>>>>> 6b94057bf3a5a651e67b588c24dcfeb731ba8818
    }
}

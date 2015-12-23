package com.jdk2010.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jdk2010.framework.util.DateUtil;

public class Util {

    // 2010-10-10转20101010
    public static String toxkrq(Date formatDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(formatDate);
    }

    public static String getPreviousMonthFirst() {

        String str = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();

        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号

        lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号

        // lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());

        return str;

    }

    // 获得上月最后一天的日期

    public static String getPreviousMonthEnd() {

        String str = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();

        lastDate.add(Calendar.MONTH, -1);// 减一个月

        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天

        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天

        str = sdf.format(lastDate.getTime());

        return str;

    }

    // 获取监控回传日期
    public static String hqjkhcrq() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // String xtrq = sdf.format(new Date());
        String newkpjzrq = "";

        Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);

        if (month == 12) {
            newkpjzrq = (year + 1) + "-1-" + Constants.ENDDAY;
        } else {
            newkpjzrq = year + "-" + (month + Constants.ENDMONTH) + "-" + Constants.ENDDAY;
        }
        return Util.toxkrq(DateUtil.parse(newkpjzrq));
    }

    // 20101010转2010-10-10
    public static String tobzrq(String date) {
        date = date.substring(0, 4) + '-' + date.substring(4, 6) + '-' + date.substring(6, 8);
        return date;
    }

    // 取得某个时间后n天,格式为yyyy-mm-dd
    public static String getNDayAfterOneDate(String sDate, int n) {
        Calendar c = switchStringToCalendar(sDate);
        c.add(c.DAY_OF_MONTH, n);
        return c.get(c.YEAR) + "-" + (c.get(c.MONTH) + 1) + "-" + c.get(c.DATE);
    }

    public static Calendar switchStringToCalendar(String sDate) {
        Date date = Util.switchStringToDate(sDate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    public static Date switchStringToDate(String sDate) {
        Date date = null;
        System.out.println("sDate " + sDate);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format1.parse(sDate);

        } catch (Exception e) {
            System.out.println("日期转换失败: " + e.getMessage());
        }
        return date;
    }

}

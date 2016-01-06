package com.jdk2010.tools;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.jdk2010.framework.util.DateUtil;
import com.jdk2010.framework.util.StringUtil;

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
			newkpjzrq = year + "-" + (month + Constants.ENDMONTH) + "-"
					+ Constants.ENDDAY;
		}
		return Util.toxkrq(DateUtil.parse(newkpjzrq, "yyyy-MM-dd"));
	}

	// 20101010转2010-10-10
	public static String tobzrq(String date) {
		date = date.substring(0, 4) + '-' + date.substring(4, 6) + '-'
				+ date.substring(6, 8);
		return date;
	}

	// 取得某个时间后n天,格式为yyyy-mm-dd
	public static String getNDayAfterOneDate(String sDate, int n) {
		Calendar c = switchStringToCalendar(sDate);
		c.add(c.DAY_OF_MONTH, n);
		String mouth = (c.get(c.MONTH) + 1) + "";
		String day = c.get(c.DATE) + "";
		mouth = StringUtil.charFront(mouth, 2, "0");
		day = StringUtil.charFront(day, 2, "0");
		return c.get(c.YEAR) + "" + mouth + "" + day;
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

	// 发票int转string 并补足8位
	public static String fpIntToString(int fp) {
		String str = String.valueOf(fp);
		if (str == null) {
			str = "";
		}
		for (int i = str.length(); i < 8; i++) {
			str = "0" + str;
		}
		return str;
	}

	public static byte[] HexString2Bytes(String src) {
		src = src.toUpperCase();
		int length = src.length() / 2;
		byte[] ret = new byte[length];
		byte[] tmp;
		try {
			tmp = src.getBytes("GBK");
			for (int i = 0; i < length; i++) {
				ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	private static GregorianCalendar gc = null;

	private static void initCalendar(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("argument date must be not null");
		}
		gc.clear();
		gc.setTime(date);
	}
	static {
		gc = new GregorianCalendar(Locale.CHINA);
		gc.setLenient(true);
		gc.setFirstDayOfWeek(Calendar.MONDAY);
	}

	public static Date getLastMonthDay(Date date) {
		initCalendar(date);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		int maxDaysOfMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		gc.add(Calendar.DAY_OF_MONTH, maxDaysOfMonth - dayOfMonth);
		return gc.getTime();
	}

	public static String getNextMonthEnd() {

        String str = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();

        lastDate.add(Calendar.MONTH, 1);// 减一个月

        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天

        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天

        str = sdf.format(lastDate.getTime());

        return str;

    }
	
	public static void test(){
		String url = "jdbc:sybase:Tds:192.168.1.107:5001/chuzhou?charset=cp850&jconnect_version=3";
		try {
			Class.forName("com.sybase.jdbc2.jdbc.SybDriver").newInstance();
			Connection con = DriverManager.getConnection(url, "sa", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select top 10 * from SKQ_NSRXX");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test();
	}
}

package com.jdk2010.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
 

    // 2010-10-10转20101010
    public static String toxkrq(Date formatDate) {
        SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
        return df.format(formatDate);
    }

}

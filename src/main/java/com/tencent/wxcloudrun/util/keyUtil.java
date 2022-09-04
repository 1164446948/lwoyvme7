package com.tencent.wxcloudrun.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class keyUtil {
    public static synchronized String getUUIDTOLongNew(){
        try {
            TimeUnit.NANOSECONDS.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg="";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSSSSSS"); //1810311557430000845
//        msg = sdf.format(date).substring(2);
        return sdf.format(date);
    }
}

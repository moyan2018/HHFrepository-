package com.pengfei.utils.dateTime;

import com.pengfei.utils.empty.EmptyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimeUtils {

    private static String Default_Date_Time_Format = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtils(){

    }

    public static Date getCurrent(){
        return new Date();
    }

    public static String format(Date date){
        return format(date, Default_Date_Time_Format);
    }

    public static String format(Date date, String format){
        if( EmptyUtils.isEmpty(date) ){
            date = getCurrent();
        }
        if( EmptyUtils.isEmpty(format) ){
            format = Default_Date_Time_Format;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format( date );
    }


    public static void main(String[] args) {
        System.out.println( format(null, null) );
    }

}

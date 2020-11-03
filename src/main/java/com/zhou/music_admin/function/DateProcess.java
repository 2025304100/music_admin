package com.zhou.music_admin.function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Component
public class DateProcess {
    private final static Date date=new Date();
    private final static java.sql.Date sqlDate=new java.sql.Date(System.currentTimeMillis());
   private  final static  SimpleDateFormat s=new SimpleDateFormat();
    //转换成格式

    public String toFormat(String format){
        String format1 = new SimpleDateFormat(format).format(date);
        return format1;
    }
    public Long toLong(){
        return System.currentTimeMillis();
    }
    public java.sql.Date toSqlDate(Date date){
        sqlDate.setTime(date.getTime());
        return sqlDate;
    }
    public java.sql.Date toSqlDate(String format) throws ParseException {

        Date parse = s.parse(format);
        sqlDate.setTime(parse.getTime());
        return sqlDate;
    }
    public Date toDate(String format) throws ParseException {
        Date parse = s.parse(format);
        return parse;
    }
}

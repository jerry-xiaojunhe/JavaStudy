package com.jerry.study.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @auther xiaojun.he
 */
public class TimeTest {
    static SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        LocalDateTime now = LocalDateTime.now();
        String year = String.valueOf(now.getYear());
        String month = String.valueOf(now.getMonthValue());
        String day = String.valueOf(now.getDayOfMonth());
        String hour = String.valueOf(now.getHour());
        String minute;
        if(now.getMinute()<30){
            minute = "30";
        }
        else{
            hour = String.valueOf(now.getHour() + 1);
            minute = "00";
        }

        Date date = format.parse(year + "-" + month + "-" + day + " " + hour + ":"+minute+":00");



        System.out.println(date);

        System.out.println("now: " + LocalDateTime.now());
        LocalDateTime reserveTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);

        System.out.println("reserve time: " + reserveTime);
    }

    public static void StringToDate(){
        String time1 = "2019-07-17 18:30";
        String time2 = "2019-07-17 19:00";

        try {
            // String to date time
            int a = sDateFormat.parse(time1).compareTo(sDateFormat.parse(time2));
            System.out.println(a);

            // date time to String
            Date date = sDateFormat.parse("2019-07-17 20:20");
            System.out.println(sDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void Long() throws ParseException {
        String time1 = "2019-07-17 18:29";

        Date date = sDateFormat.parse(time1);

        Long mill = date.getTime();

        if(mill%3600000<60000 || mill%1800000<60000){
            System.out.println("ok");
        }
        else
        {System.out.println("failed");}
    }
}

package com.jerry.study.Time;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @auther Jerry
 */
public class _ZonedDateTime {
    public static void main(String[] args){
        ZoneId zoneId = Clock.systemDefaultZone().getZone();

        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zonedDateTime);//2019-08-02T10:03:39.002132200+08:00[Asia/Shanghai]
    }
}

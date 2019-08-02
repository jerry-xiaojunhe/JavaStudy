package com.jerry.study.Time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @auther Jerry
 */
public class _LocalDateTime {
    public static void main(String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2019-08-02T09:50:12.631097100

        ZoneId zoneId = Clock.systemDefaultZone().getZone();
        System.out.println(zoneId);

        localDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(localDateTime);//2019-08-01T21:50:12.632095600
    }
}

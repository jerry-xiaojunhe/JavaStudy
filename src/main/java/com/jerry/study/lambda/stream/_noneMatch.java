package com.jerry.study.lambda.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoj
 */
public class _noneMatch {
    public static void main(String[] args){
        List<NoneMatchStatus> statuses = new ArrayList<>();
        statuses.add(NoneMatchStatus.STATUS1);

        System.out.println(statuses.stream().noneMatch(status->status == NoneMatchStatus.STATUS3));

        System.out.println(statuses.stream().allMatch(status->status.getClass() == NoneMatchStatus.class));

        System.out.println(statuses.stream().anyMatch(v -> v.name().startsWith("S")));
    }

    enum NoneMatchStatus{
        STATUS1,STATUS2,STATUS3,
    }
}

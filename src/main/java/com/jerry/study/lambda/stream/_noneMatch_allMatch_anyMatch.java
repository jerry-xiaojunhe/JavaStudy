package com.jerry.study.lambda.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoj
 */
public class _noneMatch_allMatch_anyMatch {
    public static void main(String[] args){
        List<NoneMatchStatus> statuses = new ArrayList<>();
        statuses.add(NoneMatchStatus.STATUS1);
        statuses.add(NoneMatchStatus.bSTATUS2);

        //没有一个符合条件
        System.out.println(statuses.stream().noneMatch(status->status == NoneMatchStatus.STATUS3));

        //所有都符合条件
        System.out.println(statuses.stream().allMatch(status->status.getClass() == NoneMatchStatus.class));

        //只要有一个符合条件
        System.out.println(statuses.stream().anyMatch(v -> v.name().startsWith("S")));
    }

    enum NoneMatchStatus{
        STATUS1,bSTATUS2,STATUS3,
    }
}

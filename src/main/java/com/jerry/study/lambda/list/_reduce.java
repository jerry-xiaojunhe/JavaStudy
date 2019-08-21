package com.jerry.study.lambda.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 */
public class _reduce {
    //reduce() 是将集合中所有值结合进一个，Reduce类似SQL语句中的sum(), avg() 或count(),
    public static void main(String[] args){
        List<Double> costBeforeTax = Arrays.asList(100D, 200D, 300D, 400D, 500D);

        //before java 8
        double total = 0.0D;
        for(double i : costBeforeTax){
            total+=(i+i*.12);
        }
        System.out.println(total);

        //in java 8
        double bill = costBeforeTax
            .stream()
            .map(cost->cost+cost*.12)
            .reduce((sum, cost)->sum+cost)
            .get();
        System.out.println(bill);
    }
}

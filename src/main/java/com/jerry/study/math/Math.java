package com.jerry.study.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @auther Jerry
 */
public class Math {
    public static double round(Double amount) {
        return round(amount, 2);
    }

    public static double round(Double amount, int scale) {
        if (amount == null) return 0;
        return BigDecimal.valueOf(amount).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args){
        Double totalAmount = round(1.556d);
        System.out.println(totalAmount);
    }
}

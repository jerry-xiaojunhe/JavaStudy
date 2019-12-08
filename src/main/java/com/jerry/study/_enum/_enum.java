package com.jerry.study._enum;

/**
 * @auther Jerry
 */
public class _enum {
    public static void main(String[] args){
        Size smallSize = Size.SMALL;
        System.out.println(smallSize.name());
        System.out.println(smallSize.getAttribute());
        System.out.println(Size.valueOf("EXTRA_LARGE").getAttribute());
    }
}

enum Size{
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");
    private String attribute;
    private Size(String attr) {
        this.attribute = attr;
    }

    public String getAttribute() {
        return attribute;
    }
}

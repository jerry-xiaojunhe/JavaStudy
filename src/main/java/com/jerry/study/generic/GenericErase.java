package com.jerry.study.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 编译器编译完带有泛形的java程序后，生成的class文件中将不再带有泛形信息，以此使程序运行效率不受到影响，这个过程称之为“擦除”
 */
public class GenericErase {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        List list1 = list;

        List list2 = new ArrayList();
        List<String> list3 = list2;
    }
}

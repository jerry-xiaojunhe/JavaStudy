package com.jerry.study.lambda.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @auther Jerry
 */
public class _groupingby {
    public static void main(String[] args) {
        int a = new BigDecimal(1*100).intValue();

        System.out.println(a);

        List<Person> people = new ArrayList<>();
        for(int i = 0;i<10;i++){
            people.add(new Person(i, false));
        }

        for(int i = 0;i<10;i++){
            people.add(new Person(i, true));
        }

        Map<Integer, List<Person>> groupByGrade = people.stream().collect(groupingBy(Person::getGrade));

        for(int key : groupByGrade.keySet()) {
            System.out.print(key + ": ");
            groupByGrade.get(key).forEach(System.out::print);
            System.out.println();
        }
    }
}

class Person {
    public int grade;
    public boolean isBoy;

    public Person(int g, boolean b){
        grade = g;
        isBoy = b;
    }

    public int getGrade(){
        return grade;
    }

    @Override
    public String toString(){
        return grade + " " + isBoy;
    }

}
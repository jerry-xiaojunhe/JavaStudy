package com.jerry.study.lambda.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jerry
 */
public class _collect {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4, 5, 6, 1, 2, 3, 7, 8, 8, 9, 10);

        //Collectors.joining
        System.out.println("joining");
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");

        String G7Counties = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("Collectors.joining: " + G7Counties);
        System.out.println();

        //Collectors.groupingBy
        System.out.println("groupingBy");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sex sex = Sex.Male;
            if (i % 2 == 0)
                sex = Sex.Female;
            students.add(new Student(sex.name(), sex));
        }

        Map<Sex, List<Student>> studentMap = students.stream().collect(Collectors.groupingBy(Student::getSex));
        studentMap.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
            System.out.println();
        });

        Map<Boolean, List<Integer>> intMap = integers.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));
        intMap.forEach((k, v) -> {
                System.out.println(k);
                v.forEach(System.out::println);
                System.out.println();
            }
        );

        //Collectors.toSet()
        System.out.println();
        System.out.println("Collectors.toSet()");
        integers.stream().collect(Collectors.toSet()).forEach(System.out::println);


//        .collect(Collectors.toMap(product -> product.id, product -> product));
    }

    static class Student {
        public String name;
        public Sex sex;

        public Student(String name, Sex sex) {
            this.name = name;
            this.sex = sex;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "Sex:" + getSex() + ", name: " + name;
        }
    }

    enum Sex {
        Female, Male
    }
}


package com.jerry.study.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysSort
{
    public static void main(String[] args)
    {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "z"));
        list.add(new Person(2, "a"));
        list.add(new Person(7, "b"));
        list.add(new Person(1, "a"));
        list.add(new Person(1, "g"));
        list.add(new Person(1, "b"));

        Person[] persons = list.toArray(new Person[0]);

        Arrays.sort(persons, new Comparator<Person>()
        {
            @Override
            public int compare(Person o1, Person o2)
            {
                int temp = o1.name.compareTo(o2.name);
                return temp == 0 ? o1.age - o2.age : temp;
            }
        });

        for (Person p : persons)
        {
            System.out.println(p);
        }
    }
}

class Person
{
    public int age;
    public String name;

    public Person(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

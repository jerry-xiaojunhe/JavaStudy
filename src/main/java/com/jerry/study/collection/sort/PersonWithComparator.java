package com.jerry.study.collection.sort;

import java.util.*;

public class PersonWithComparator
{
    private int age;
    private String name;

    public PersonWithComparator(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "PersonWithComparator{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static void main(String[] args)
    {
        TreeSet<PersonWithComparator> ts = new TreeSet<>(new PersonComparator());
        ts.add(new PersonWithComparator(17, "c"));
        ts.add(new PersonWithComparator(10, "d"));
        ts.add(new PersonWithComparator(12, "z"));
        ts.add(new PersonWithComparator(10, "b"));
        ts.add(new PersonWithComparator(16, "a"));
        ts.add(new PersonWithComparator(10, "a"));

        for(PersonWithComparator p : ts){
            System.out.println(p);
        }
    }
}

class PersonComparator implements Comparator
{

    @Override
    public int compare(Object o1, Object o2)
    {
        PersonWithComparator p1 = (PersonWithComparator) o1;
        PersonWithComparator p2 = (PersonWithComparator) o2;

        int temp = p1.getName().compareTo(p2.getName());

        return temp == 0? p1.getAge() - p2.getAge():temp;
    }
}

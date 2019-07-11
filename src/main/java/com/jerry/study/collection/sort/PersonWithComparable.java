package com.jerry.study.collection.sort;

import java.util.TreeSet;

public class PersonWithComparable implements Comparable
{
    private int age;
    private String name;

    public PersonWithComparable(int age, String name)
    {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString()
    {
        return "PersonWithComparable{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o)
    {
        PersonWithComparable obj = (PersonWithComparable) o;

        int temp = this.getName().compareTo(obj.getName());
        if (temp == 0)
        {
            return this.getAge() - obj.getAge();
        }
        else
        {
            return temp;
        }
    }

    public static void main(String[] args)
    {
        TreeSet<PersonWithComparable> ts = new TreeSet<>();
        ts.add(new PersonWithComparable(10, "z"));
        ts.add(new PersonWithComparable(11, "z"));
        ts.add(new PersonWithComparable(13, "d"));
        ts.add(new PersonWithComparable(14, "c"));
        ts.add(new PersonWithComparable(15, "b"));
        ts.add(new PersonWithComparable(10, "a"));
        ts.add(new PersonWithComparable(0, "a"));

        for (PersonWithComparable p : ts)
        {
            System.out.println(p);
        }
    }
}

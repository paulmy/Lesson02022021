package ru.samsung.lesson02022021;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    {
        name="User";
        age = 15;
        phone="+71234567890";
    }
    public Person() {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public Person(String name) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return name + " " + age + " " + phone;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
class PersonComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        return a.getName().compareTo(b.getName());
    }
}
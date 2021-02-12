package ru.samsung.lesson02022021;

public class Person {
    public String name;
    public int age;
    public String phone;

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

    @Override
    public String toString() {
        return name + " " + age + " " + phone;
    }
}

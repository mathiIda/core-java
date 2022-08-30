package com.niumengliang.corejava.four;

import java.time.LocalDate;

/**
 * Description of this file
 *
 * @author niumengliang
 * @version 1.0
 * @since 2022/8/24
 */
public class EmployeeTest {

    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            // e.setId();
            System.out.println("name=" + e.getName() +
                    ",salary=" + e.getSalary() +
                    ",hireDay=" + e.getHireDay() +
                    ",id=" + e.getId());
        }

        System.out.println("nextId=" + Employee.getNextId());

    }

}

class Employee {

    // 变量可以不手动赋值，常量一定要手动赋值

    private static final String COMMON = "s";
    private static final String COMMON_STATIC;

    private static int nextId = 1;
    private static int com;

    // 必须确保在构造函数结束之后 final 域被赋值
    private final String name;
    private double salary = 1.0; // 在执行构造器之前，会先进行赋值操作
    private final LocalDate hireDay;
    private int id = assignId(); // 可以通过静态方法进行赋值操作

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    // 下面的块代码会在类初始化时执行
    static {
        COMMON_STATIC = "ss";
    }

    // 只要构造类的对象，下面的块代码就会被执行
    {
        System.out.println("success to create an object");
    }

    private static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Employee other) {
        // Employee 类的方法可以访问 Employee 类的任何一个对象的私有域
        return name.equals(other.name);
    }

}


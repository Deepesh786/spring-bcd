package com.learn.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class MinMaxSalary {

    static List<Employee> empList = Arrays.asList(new Employee("Deepesh", 24, 10),
            new Employee("xyz", 25, 9),
            new Employee("yo", 28, 8),
            new Employee("yo", 29, 7));


    public static void main(String[] args) {

        //List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> givenList = new ArrayList<>();

        givenList.add("a");
        givenList.add("bb");
        givenList.add("ccc");
        givenList.add("dd");
        givenList.add("dp");
        System.out.println("givenList "+givenList);

        List<String> result = givenList.stream().collect(Collectors.toUnmodifiableList());
        result.add("dp");
        System.out.println("result "+result);

        //Optional<Employee> maxSalaryEmp = empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        //Optional<Employee> maxSalaryEmp = empList.stream().collect(Collectors.maxBy(Comparator.comparing(e->{return e.getSalary();})));
        //System.out.println(maxSalaryEmp.get());

    }
}

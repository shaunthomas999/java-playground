package com.shaunthomas999.java8.stringExample;

import com.shaunthomas999.java8.stringExample.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StringExamples {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Shaun");
        student.setLastName("Thomas");

        Student student1 = new Student();
        student.setFirstName("Shaun1");
        student.setLastName("Thomas1");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);

//        TODO - Fix, not working
//        studentList.stream().map(s -> s.getFirstName().replaceFirst("Sh", ".."))
//                .forEach(System.out::println);
    }
}

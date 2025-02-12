package com.shaunthomas999.advanced.collections.comparableNcomparator.comparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shaunthomas on 14/10/16.
 */
public class ComparableMain {

    public static void main(String[] args) {

        ArrayList<Student> studentsList = new ArrayList<Student>();
        studentsList.add(new Student((short)1, "Sachin", "Tendulkar", "60", (short)7, 'A'));
        studentsList.add(new Student((short)2, "Saurav", "Ganguly", "80", (short)7, 'A'));
        studentsList.add(new Student((short)3, "Suresh", "Raina", "75", (short)4, 'A'));
        studentsList.add(new Student((short)4, "MS", "Dhoni", "90", (short)4, 'A'));
        studentsList.add(new Student((short)5, "Virat", "Kohli", "92", (short)4, 'B'));

        Collections.sort(studentsList);

        System.out.println("Comparable sorted");
        for(Student s : studentsList) {
            System.out.println(s.getFirstname());
        }
    }
}

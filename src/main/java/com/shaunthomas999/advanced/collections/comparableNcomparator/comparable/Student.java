package com.shaunthomas999.advanced.collections.comparableNcomparator.comparable;

/**
 * Created by shaunthomas on 14/10/16.
 */
public class Student implements Comparable<Student> {
    private short rollnumber;

    private String firstname;

    private String lastname;

    private String totalmarks;

    private short classLevel;

    private char classDivision;

    public Student(short rollnumber, String firstname, String lastname, String totalmarks, short classLevel, char classDivision) {
        this.rollnumber = rollnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalmarks = totalmarks;
        this.classLevel = classLevel;
        this.classDivision = classDivision;
    }

    public short getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(short rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(String totalmarks) {
        this.totalmarks = totalmarks;
    }

    public short getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(short classLevel) {
        this.classLevel = classLevel;
    }

    public char getClassDivision() {
        return classDivision;
    }

    public void setClassDivision(char classDivision) {
        this.classDivision = classDivision;
    }

    @Override
    public int compareTo(Student o) {
        return this.getFirstname().compareTo(o.getFirstname());
    }
}

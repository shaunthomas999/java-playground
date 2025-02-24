package com.shaunthomas999.basics;

public class ObjectAssignment {

    public void check() {
        SecondClass classA = new SecondClass("Virat", "Kohli", 28);
        SecondClass classB = new SecondClass("Rohit", "Sharma", 28);
        SecondClass classC;

        classC = classA;

        System.out.println("classC : " + classC.getFirstName());

        classC.setFirstName("Shaun");

        System.out.println("classC : " + classC.getFirstName());
        System.out.println("classA : " + classA.getFirstName());
    }
}

class SecondClass {
    private String firstName;
    private String lastName;
    private int age;

    public SecondClass(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

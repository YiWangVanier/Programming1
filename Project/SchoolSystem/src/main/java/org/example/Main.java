package org.example;

public class Main {
    public static void main(String[] args) {
        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Social Science");

        Address a1 = new Address(123, "Main Street", "Montreal", "QC", "A1B2C3", "Canada");
        Student s1 = new Student("yi wang", Gender.MALE, a1, d1);
        Student s2 = new Student("yi wang", Gender.MALE, a1, d1);
        Student s3 = new Student("yi wang", Gender.MALE, a1, d1);

        Course c1 = new Course("Programming 1", 3, d1);
        Course c2 = new Course("History", 2, d2);

        s1.registerCourse(c1);
        s2.registerCourse(c1);
        s3.registerCourse(c1);

        s1.registerCourse(c2);

        c1.addAssignment("Assignment01", 0.1, 100);
        c1.addAssignment("Assignment02", 0.1, 100);
        c1.addAssignment("Assignment03", 0.1, 100);
        c1.addAssignment("Exam01", 0.3, 100);
        c1.addAssignment("Exam02", 0.4, 100);

        System.out.println(s1);

        System.out.println(c1);

        c1.generateScores();
        c1.displayScores();
    }
}
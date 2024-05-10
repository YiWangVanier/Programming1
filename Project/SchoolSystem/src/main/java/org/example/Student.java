package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course, add the course to the student's registeredCourses list,
     * and add the student to the course's registeredStudents list.
     * If the course is already registered, directly returns false
     * @param course a course that is about to be registered
     * @return true if a course is successfully registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.printf("Operation failed. %s is already registered\n", course.getCourseName());
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);
        return true;
    }

    /**
     * drops a course, remove the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list.
     * If the course is not registered yet, directly returns false
     * @param course a course that is about to be dropped
     * @return true if a course is successfully dropped
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            System.out.printf("Operation failed. %s is not registered yet\n", course.getCourseName());
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}

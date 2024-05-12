package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
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
        this.studentName = Util.toTitleCase(studentName);
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
            System.out.printf("Registration failed. %s is already registered.\n", course.getCourseName());
            return false;
        }

        registeredCourses.add(course);
        course.registerStudent(this);
        System.out.printf("Registration of course %s Success.\n", course.getCourseName());
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
            System.out.printf("Drop failed. %s is not registered yet\n", course.getCourseName());
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        System.out.printf("Drop course %s Success.\n", course.getCourseName());
        return true;
    }

    /**
     * converts a student to a simple string with only the studentId, studentName, and departmentName
     * @return a simple string to represent the student
     */
    public String toSimplifiedString() {
        return "Student{\n" +
                "\t\t\tstudentId='" + studentId + "'\n" +
                "\t\t\tstudentName='" + studentName + "'\n" +
                "\t\t\tdepartment=" + department.getDepartmentName() + "\n}";
    }

    /**
     * converts a student to a string that contains the studentId, the studentName, the gender, the address
     * and the department, and the registered courses (only the courseId, courseName, and departmentName)
     * @return a detailed string to represent a student
     */
    @Override
    public String toString() {
        String str = "Student{\n" +
                "\tstudentId='" + studentId + "'\n" +
                "\tstudentName='" + studentName + "'\n" +
                "\tgender=" + gender + "\n" +
                "\taddress=" + address + "\n" +
                "\tdepartment=" + department.getDepartmentName() + "\n" +
                "\tregisteredCourses=\n";

        for (Course course : registeredCourses) {
            str += "\t\t" + course.toSimplifiedString() + '\n';
        }

        return str + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId)
                && Objects.equals(studentName, student.studentName)
                && gender == student.gender
                && Objects.equals(address, student.address)
                && Objects.equals(department, student.department)
                && Objects.equals(registeredCourses, student.registeredCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, gender, address, department, registeredCourses);
    }
}

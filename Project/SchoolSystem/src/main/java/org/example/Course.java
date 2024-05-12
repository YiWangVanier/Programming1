package org.example;

import lombok.Getter;
import org.example.util.Util;

import java.util.ArrayList;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * adds a student to the student list of the course, also expand the score size for each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the student that is about to be added
     * @return if the student is successfully added to the student list of the course
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            System.out.printf("Student with id %s has already registered this course", student.getStudentId());
            return false;
        }

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);

        return true;
    }

    /**
     * checks if the sum of all assignments for a course is 1 or not
     * @return if the sum of all assignments for a course is 1 or not
     */
    public boolean isAssignmentsTotalWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 1;
    }

    /**
     * calculates the weighted average score of a student
     */
    public void calcStudentAvg() {
        for (int i = 0; i < registeredStudents.size(); i++) {
            double avg = 0;
            for (Assignment assignment : assignments) {
                avg += assignment.getScores().get(i) * assignment.getWeight();
            }
            finalScores.set(i, avg);
        }
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore the max score of an assignment
     * @return if the course is successfully added.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        int studentAmount = registeredStudents.size();
        Assignment assignment = new Assignment(assignmentName, weight, maxScore, studentAmount);
        return assignments.add(assignment);
    }

    /**
     * generates random scores for each assignment and student, and calculate the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        calcStudentAvg();
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     * example:
     * Course: Programming 1(C-D00-01)
     *                   Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score
     *         Yi Wang             82             82             76             85             80             82
     *         Yi Wang             97             92             84             67             90             83
     *         Yi Wang             91             68             82             83             83             82
     *
     *         Average             90             81             81             78             84
     */
    public void displayScores() {
        System.out.printf("Course: %s(%s)\n", courseName, courseId);
        System.out.printf("%15s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentName());
        }
        System.out.printf("%15s\n", "Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%15s", registeredStudents.get(i).getStudentName());
            for (Assignment assignment : assignments) {
                System.out.printf("%15d", assignment.getScores().get(i));
            }
            System.out.printf("%15.0f\n", finalScores.get(i));
        }
        System.out.println();

        System.out.printf("%15s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%15.0f", assignment.getAssignmentAverage());
        }
    }

    /**
     * converts a course to a simple string with only the courseId, courseName, credits, and departmentName
     * @return a simple string to represent the course
     */
    public String toSimplifiedString() {
        return "Course{\n" +
                "\t\t\tcourseId='" + courseId + '\'' + "'\n" +
                "\t\t\tcourseName='" + courseName + '\'' + "'\n" +
                "\t\t\tcredits=" + credits + "'\n" +
                "\t\t\tdepartment=" + department.getDepartmentName() + "'\n" +
                "\t\t}";
    }

    /**
     * converts a course to a string that contains the courseId, the courseName, the credits, the departmentName
     * the assignments list, and the registered students (only the studentId, the studentName and the departmentName)
     * @return a detailed string to represent a course
     */
    @Override
    public String toString() {
        String str =  "Course{\n" +
                "\tcourseId='" + courseId + '\'' + "'\n" +
                "\tcourseName='" + courseName + '\'' + "'\n" +
                "\tcredits=" + credits + "'\n" +
                "\tdepartment=" + department.getDepartmentName() + "'\n" +
                "\tassignments=" + assignments + "'\n" +
                "\tregisteredStudents=\n";

        for (Student student : registeredStudents) {
            str += "\t\t" + student.toSimplifiedString() + '\n';
        }

        return str + '}';
    }
}

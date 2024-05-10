package org.example;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId = 1;

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
     * @param studentId the student id
     * @return the weighted average score of a student
     */
    public double calcStudentAvg(String studentId) {
        int idx = findStudentIdx(studentId);

        int avg = 0;
        for (Assignment assignment : assignments) {
            avg += assignment.getScores().get(idx) * assignment.getWeight();
        }

        return avg;
    }

    /**
     * finds the index of a studentId amount students of a course
     * @param studentId the student id
     * @return the index of the student id
     */
    private int findStudentIdx(String studentId) {
        for (int i = 0; i < registeredStudents.size(); i++) {
            if (registeredStudents.get(i).getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }



    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        int studentAmount = registeredStudents.size();
        Assignment assignment = new Assignment(assignmentName, weight, maxScore, studentAmount);
        return assignments.add(assignment);
    }
}

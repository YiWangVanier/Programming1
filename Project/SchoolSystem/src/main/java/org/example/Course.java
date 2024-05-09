package org.example;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> students;

    private static int nextId = 1;

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

    private int findStudentIdx(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }


    public boolean addAssignment(Assignment assignment) {
        return assignments.add(assignment);
    }
}

package org.example;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentId = String.format("A%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
        for (int i = 0; i < studentAmount; i++) {
            scores.add(0);
        }
    }

    /**
     * calculates the average score for one assignment
     * @return the average of the assignment
     */
    public double calcAssignmentAvg() {
        double avg = 0;
        for (int score : scores) {
            avg += score;
        }

        return avg / scores.size();
    }
}

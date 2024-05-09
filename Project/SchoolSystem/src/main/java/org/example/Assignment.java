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

    public double calcAssignmentAvg() {
        double avg = 0;
        for (int score : scores) {
            avg += score;
        }

        return avg / scores.size();
    }
}

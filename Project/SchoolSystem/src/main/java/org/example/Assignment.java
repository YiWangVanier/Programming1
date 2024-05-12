package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentId = String.format("A%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
        for (int i = 0; i < studentAmount; i++) {
            scores.add(null);
        }
    }

    /**
     * calculates the average score for one assignment
     */
    private void calcAssignmentAvg() {
        double avg = 0;
        for (double score : scores) {
            avg += score;
        }

        assignmentAverage = avg / scores.size();
    }

    /**
     * generates random scores for all students in an assignment, the scores are generated with the following rule:
     * generate a random number in range [0, 10],
     * if the number is 0, then generate a random score in range [0, 60) for the student
     * if the number is 1, 2, then generate a random score in range [60, 70) for the student
     * if the number is 3, 4, then generate a random score in range [70, 80) for the student
     * if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student
     * if the number is 9, 10, then generate a random score in range [90, 100] for the student
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int range = random.nextInt(0, 11);
            int score = switch (range) {
                case 0 -> random.nextInt(0, 60);
                case 1, 2 -> random.nextInt(60, 70);
                case 3, 4 -> random.nextInt(70, 80);
                case 5, 6, 7, 8 -> random.nextInt(80, 90);
                default -> random.nextInt(90, 101);
            };
            scores.set(i, score);
        }

        calcAssignmentAvg();
    }

    /**
     * generates a string to represent an assignment, with assignmentId, assignmentName, weight and maxScore
     * @return s string to represent an assignment
     */
    @Override
    public String toString() {
        return "Assignment{\n" +
                "\tassignmentId='" + assignmentId + '\'' +
                "\n\tassignmentName='" + assignmentName + '\'' +
                "\n\tweight=" + weight +
                "\n\tmaxScore=" + maxScore +
                "\n}";
    }
}

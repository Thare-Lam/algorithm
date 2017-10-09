package hackerrank.grading;

import java.util.Scanner;

public class Solution {

    static int[] solve(int[] grades) {
        int grade;
        int unit;
        for (int i = 0; i < grades.length; ++i) {
            grade = grades[i];
            if (grade < 38) {
                continue;
            }
            unit = grade % 10;
            if (unit <= 5 && 5 - unit < 3) {
                grades[i] = (grade / 10) * 10 + 5;
            } else if (unit > 5 && 10 - unit < 3) {
                grades[i] = (grade / 10 + 1) * 10;
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }

}

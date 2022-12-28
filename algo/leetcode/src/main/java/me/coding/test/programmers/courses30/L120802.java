package me.coding.test.programmers.courses30;

public class L120802 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/120802
    public static void main(String[] args) {
        var problem = new L120802();
        System.out.println(problem.solution(2, 3));
        System.out.println(problem.solution(100, 2));
        System.out.println(problem.solution(-50000, -50000));
        System.out.println(problem.solution(50000, 50000));
    }

    public int solution(int num1, int num2) {
        return num1 + num2;
    }
}

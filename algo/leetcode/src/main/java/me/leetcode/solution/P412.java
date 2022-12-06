package me.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class P412 {

    // https://leetcode.com/problems/fizz-buzz/
    public static void main(String[] args) {
        var problem = new P412();
        System.out.println(problem.fizzBuzz(1000));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        var FIZZ = "Fizz";
        var BUZZ = "Buzz";
        var FIZZBUZZ = "FizzBuzz";

        for(var i=1;i<=n;i++) {
            var mod3 = i % 3;
            var mod5 = i % 5;
            if(mod3==0 && mod5==0) {
                list.add(FIZZBUZZ);
            } else if(mod3==0) {
                list.add(FIZZ);
            } else if(mod5==0) {
                list.add(BUZZ);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}

package me.leetcode.solution;

public class P13 {

    // https://leetcode.com/problems/roman-to-integer/
    public static void main(String[] args) {
        var problem = new P13();
        System.out.println(problem.romanToInt("MCMXCIV"));
    }
    public enum RomanNumerals {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        RomanNumerals(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public int romanToInt(String s) {
        var temp = 0;
        var result = 0;
        RomanNumerals prevValue = null;

        for(char ch:s.toCharArray()) {
            var currentValue = RomanNumerals.valueOf(String.valueOf(ch));

            if(prevValue == null) {
                temp = currentValue.getValue();
            } else if(prevValue.getValue()==currentValue.getValue()) {
                temp += currentValue.getValue();
            } else if(prevValue.getValue()>currentValue.getValue()) {
                result = result + temp;
                temp = currentValue.getValue();
            } else if (prevValue.getValue() < currentValue.getValue()) {
                result = result + currentValue.getValue() - temp;
                temp = 0;
            }

            prevValue = currentValue;
        }

        result = result + temp;

        return result;
    }
}

package me.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17 {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static void main(String[] args) {
        var problem = new P17();
        System.out.println(problem.letterCombinations("23"));
        System.out.println(problem.letterCombinations(""));
        System.out.println(problem.letterCombinations("2"));
    }

    static Map<String, List<String>> dictionary = new HashMap<>();
    static {
        dictionary.put("2", List.of("a", "b", "c"));
        dictionary.put("3", List.of("d", "e", "f"));
        dictionary.put("4", List.of("g", "h", "i"));
        dictionary.put("5", List.of("j", "k", "l"));
        dictionary.put("6", List.of("m", "n", "o"));
        dictionary.put("7", List.of("p", "q", "r", "s"));
        dictionary.put("8", List.of("t", "u", "v"));
        dictionary.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length()==0) {
            return result;
        }

        result.add("");

        for(int i=0; i<digits.length(); i++) {
            result = addString(result, String.valueOf(digits.charAt(i)));
        }

        return result;
    }

    public List<String> addString(List<String> stringList, String num) {
        List<String> charList = dictionary.get(num);
        List<String> newList = new ArrayList<>();
        for(String str:stringList) {
            for(String ch:charList) {
                newList.add(str+ch);
            }
        }
        return newList;
    }
}

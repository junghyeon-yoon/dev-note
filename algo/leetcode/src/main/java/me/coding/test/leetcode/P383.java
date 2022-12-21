package me.coding.test.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P383 {

    // https://leetcode.com/problems/roman-to-integer/
    public static void main(String[] args) {
        var problem = new P383();
        System.out.println(problem.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for(var i=0;i<magazine.length();i++) {
            var ch = magazine.charAt(i);
            magazineMap.putIfAbsent(ch, 0);
            magazineMap.computeIfPresent(ch, (character, integer) -> integer+1);
        }

        for(var i=0;i<ransomNote.length();i++) {
            var ch = ransomNote.charAt(i);
            if(magazineMap.containsKey(ch)){
                var count = magazineMap.compute(ch, (character, integer) -> integer - 1);
                if(count<0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}

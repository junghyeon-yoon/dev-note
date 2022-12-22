package me.coding.test.leetcode;

public class P28 {
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public static void main(String[] args) {
        var problem = new P28();
        System.out.println(problem.strStr("sadbutsad", "sad"));
        System.out.println(problem.strStr("leetcode", "leeto"));
        System.out.println(problem.strStr("aa", "aaaa"));
        System.out.println(problem.strStr("mississippi", "issip"));
        System.out.println(problem.strStr("mississippi", "issipi"));
        System.out.println(problem.strStr("mississippi", "sippia"));
    }

    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()) {
            return -1;
        } else if(needle.length() == haystack.length()) {
            return needle.equals(haystack) ?0:-1;
        }

        int haystackIdx = 0;
        int needleIdx = 0;
        int firstContact = -1;

        while(haystackIdx < haystack.length() && needleIdx < needle.length()) {
            if(haystack.charAt(haystackIdx) == needle.charAt(needleIdx)) {
                if(firstContact==-1) {
                    firstContact = haystackIdx;
                }
                haystackIdx++;
                needleIdx++;
            } else {
                if(firstContact==-1) {
                    haystackIdx++;
                } else {
                    haystackIdx = firstContact+1;
                }
                firstContact = -1;
                needleIdx = 0;
            }
            if(needleIdx==needle.length()) {
                break;
            }
        }

        if(needleIdx<needle.length()) {
            firstContact = -1;
        }

        return firstContact;
    }
}

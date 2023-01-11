package me.coding.test.programmers.courses30;

import java.util.*;

public class L150366 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150366
    public static void main(String[] args) {
        var problem = new L150366();
        System.out.println(problem.solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"}));
        System.out.println(problem.solution(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"}));
    }
    String[] table = new String[50*50];
    Map<Integer, Set<Integer>> link = new HashMap<>();
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        Arrays.fill(table, "EMPTY");
        link.clear();

        for(String command:commands) {
            String[] com = command.split(" ");
            switch(com[0]) {
                case "UPDATE":
                    if(com.length==4) {
                        updateTarget(index(com[1], com[2]), com[3]);
                    } else {
                        updateByValue(com[1], com[2]);
                    }
                    break;
                case "MERGE":
                    merge(index(com[1], com[2]), index(com[3], com[4]));
                    break;
                case "UNMERGE":
                    unmerge(index(com[1], com[2]));
                    break;
                case "PRINT":
                    String str = print(index(com[1], com[2]));
                    answer.add(str);
                    break;
            }
        }
        System.out.println(answer);
        return answer.stream().toArray(String[]::new);
    }

    public int index(String rString, String cString) {
        int r = Integer.valueOf(rString) - 1;
        int c = Integer.valueOf(cString) - 1;

        return r * 50 + c;
    }

    // basic op


    // basic op - end

    // "UPDATE r c value"
    public void updateTarget(int target, String value) {
        table[target]=value;
        if(link.get(target)!=null) {
            for(int i:link.get(target)) {
                table[i] = value;
            }
        }
    }

    // "UPDATE value1 value2"
    public void updateByValue(String oldValue, String newValue) {
        for(int i=0; i<50*50; i++) {
            if(oldValue.equals(table[i])) {
                table[i]=newValue;
            }
        }
    }

    // "MERGE r1 c1 r2 c2"
    public void merge(int target1, int target2) {
        if(target1 == target2) {
            return;
        }

        Set<Integer> temp = new HashSet<>();

        temp.add(target1);
        temp.add(target2);

        if(link.containsKey(target1)) {
            temp.addAll(link.get(target1));
        }
        if(link.containsKey(target2)) {
            temp.addAll(link.get(target2));
        }
        String strTemp = table[target1];
        if(!table[target1].equals("EMPTY") && table[target2].equals("EMPTY")) {
            strTemp = table[target1];
        } else if(table[target1].equals("EMPTY") && !table[target2].equals("EMPTY")) {
            strTemp = table[target2];
        }

        for(int i:temp) {
            link.put(i, temp);
            table[i] = strTemp;
        }
    }

    // "UNMERGE r c"
    public void unmerge(int target) {
        String temp = table[target];

        if(link.get(target)!=null) {
            for(int i:link.get(target)) {
                table[i] = "EMPTY";
            }
            link.get(target).clear();
            table[target] = temp;
        }
    }

    // "PRINT r c"
    public String print(int target) {
        return table[target];
    }
}

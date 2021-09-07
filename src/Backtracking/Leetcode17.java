package Backtracking;

import java.util.*;

public class Leetcode17 {
    List<String> paths = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return paths;
        }
        Map<Character, String> phone = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        DFS(phone, digits, 0, new StringBuffer());
        return paths;
    }

    public void DFS(Map<Character, String> phone, String digits, int index, StringBuffer str) {
        if (index == digits.length()) {
            paths.add(str.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phone.get(digit);
            int letterCounts = letters.length();
            for (int i = 0; i < letterCounts; i++) {
                str.append(letters.charAt(i));
                DFS(phone, digits, index + 1, str);
                str.deleteCharAt(index);
            }
        }
    }
}

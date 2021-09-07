package AdvanceSorting;

import java.util.*;

public class Leetcode451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i=0; i <s.length(); i++){
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        String str = new String();
        for (int i=0;i<list.size();i++){
            Map.Entry c = list.get(i);
            if (i==0){
                str = c.getKey().toString();
                for (int j=1;j<Integer.parseInt(c.getValue().toString());j++){
                    str = str.concat(c.getKey().toString());
                }
            }else {
                for (int j=0;j<Integer.parseInt(c.getValue().toString());j++){
                    str = str.concat(c.getKey().toString());
                }
            }
        }
        return str;
    }

    public String OpfrequencySort(String s) {
        HashMap<Integer, String> map = new HashMap<>();

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                }else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();
    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode451 leetcode451 = new Leetcode451();
        String s = "Aabb";
        leetcode451.frequencySort(s);
    }
}

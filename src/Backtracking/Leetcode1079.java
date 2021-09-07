package Backtracking;


public class Leetcode1079 {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        char[] chars = tiles.toCharArray();
        for (char ch : chars) {
            count[ch - 'A']++;
        }
        return DFS(count);
    }

    public int DFS(int[] count) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            res++;
            count[i]--;

            res += DFS(count);
            count[i]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1079 leetcode1079 = new Leetcode1079();
        String str = "AAB";
        int res = leetcode1079.numTilePossibilities(str);
        System.out.println(res);
    }

}

package Backtracking;

public class Leetcode60 {
    int n, k;
    boolean[] used;
    int[] factorial;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        Factorial(n);
        used = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        DFS(0, path);
        return path.toString();
    }

    public void DFS(int index, StringBuilder path) {
        if (index == n) return;
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            DFS(index + 1, path);
            return;
        }
    }

    public void Factorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        Leetcode60 leetcode60 = new Leetcode60();
        String str = leetcode60.getPermutation(n, k);
        System.out.println(str);
    }
}

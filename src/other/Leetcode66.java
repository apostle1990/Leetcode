package other;

import java.util.Arrays;

public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Leetcode66 leetcode66 = new Leetcode66();
        int[] digits = {9,9,9};
        int[] result = leetcode66.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}

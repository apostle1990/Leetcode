package SlidingWindow.huadongchuangkou;

public class Leetcode992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window w1 = new Window(A.length + 1);
        Window w2 = new Window(A.length + 1);
        int position1 = 0;
        int position2 = 0;
        int subSize = 0;
        for (int j : A) {
            w1.add(j);
            w2.add(j);

            while (w1.differentLength() > K) {
                w1.remove(A[position1]);
                position1++;
            }

            while (w2.differentLength() > K - 1) {
                w2.remove(A[position2]);
                position2++;
            }
            subSize += position2 - position1;
        }
        return subSize;
    }

    static class Window {
        int[] count;
        int limit;

        public Window(int size) {
            count = new int[size];
            limit = 0;
        }

        public void add(int m) {
            count[m] ++;
            if (count[m] == 1) limit ++;
        }

        public void remove(int m) {
            count[m] --;
            if (count[m] == 0) limit --;
        }

        public int differentLength() {
            return limit;
        }

    }

    public static void main(String[] args) {
    }
}

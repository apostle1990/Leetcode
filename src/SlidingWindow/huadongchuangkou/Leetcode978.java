package SlidingWindow.huadongchuangkou;

public class Leetcode978 {
    public int maxTurbulenceSize(int[] A) {
        if (A.length ==0 || A.length==1) return A.length;
        int sybmol = A[1] -A[0];
        if (sybmol!=0) sybmol = (A[1] -A[0])/Math.abs(A[1]-A[0]);
        int max=0;
        int tempmax = 1;
        for (int i=1;i<A.length-1;i++){
            int temp = A[i+1]-A[i];
            if (temp==0) {
                tempmax=0;
                sybmol = temp;
                continue;
            }
            temp = (A[i+1]-A[i])/Math.abs(A[i+1]-A[i]);
            if (temp!=sybmol){
                tempmax++;
            }else tempmax=1;
            sybmol = temp;
            max = Math.max(max,tempmax);
        }
        return max+1;
    }

    public static void main(String[] args) {
        Leetcode978 leetcode978 = new Leetcode978();
        int[] A = {9,4,2,10,7,8,8,1,9};
        int max = leetcode978.maxTurbulenceSize(A);
        System.out.println(max);
    }
}

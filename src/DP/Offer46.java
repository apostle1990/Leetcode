package DP;

public class Offer46 {
    public int translateNum(int num) {
        String Snum = String.valueOf(num);
        int len = Snum.length();
        int[] res = new int[len + 1];
        res[1] =1 ;
        res[0]= 1;
        for (int i=2;i<=len;i++){
            int re = (Snum.charAt(i-2)-'0')*10 + (Snum.charAt(i-1)-'0');
            if (re >=10 && re<=25){
                res[i] = res[i-1] + res[i-2];
            }else {
                res[i] = res[i-1];
            }
        }
        return res[len];
    }
}

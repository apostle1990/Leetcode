package other;

public class Leetcode8 {
    public int myAtoi(String s) {
        long num =0;//有int溢出判断，使用double类型
        int symbol =0;
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char n = ch;
            if (Character.isDigit(ch)){
                n = '0';
            }
            switch (n){
                case ' ':
                    if (symbol==0) continue;
                    return (int)num*symbol;
                case '+':
                    if (symbol==0){
                        symbol=1;
                        continue;
                    }
                    return (int)num*symbol;
                case '-':
                    if (symbol==0){
                        symbol=-1;
                        continue;
                    }
                    return (int)num*symbol;
                case '0'://如果是首个字符为数字，给与symbol‘+’，超出int范围且‘+’返回Integer.MAX_VALUE，‘-’返回Integer.MAX_VALUE+1
                    if (symbol==0) symbol =1;
                    if (num==0){
                        num = ch -'0';
                        continue;
                    }
                    else{
                        num = num*10 + ch-'0';
                        if (num>Integer.MAX_VALUE){
                            if (symbol==-1){
                                return Integer.MAX_VALUE+1;
                            }else if (symbol==1){
                                return Integer.MAX_VALUE;
                            }
                        }
                        continue;
                    }
                default://遇到除+、-号以外的字符，直接返回
                    return (int)num*symbol;
            }

        }
        return (int)num*symbol;
    }

    public static void main(String[] args) {
        Leetcode8 leetcode8 = new Leetcode8();
        String s = "2147483648";
        int i=leetcode8.myAtoi(s);
        System.out.println(i);
    }
}

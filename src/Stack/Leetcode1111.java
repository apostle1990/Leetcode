package Stack;

//有效括号的嵌套深度
public class Leetcode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] re = new int[len];
        int depth = 0;

        char[] ch = seq.toCharArray();

        for (int i=0; i<len; i++){
            if (ch[i] == '('){
                depth++;
                re[i] = depth %2;
            }else {
                re[i] = depth %2;
                depth--;
            }
        }
        return re;
    }
}

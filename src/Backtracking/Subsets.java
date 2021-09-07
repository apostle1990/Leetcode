package Backtracking;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode90s
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        Arrays.sort(S);
        res.add(new ArrayList<>());
        DFS(S,0,item,res);
        return res;
    }

    public void DFS(int[] S, int depth, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        for (int i = depth;i<S.length;i++){
            item.add(S[i]);
            res.add(new ArrayList<>(item));
            DFS(S,i+1,item,res);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        ArrayList<ArrayList<Integer>> res = subsets.subsets(nums);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}

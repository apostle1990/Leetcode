package UnionFind;


import java.util.HashMap;

//128. 最长连续序列
public class Leetcode128 {
    class UnionFind{
        HashMap<Integer,Integer> parent;
        HashMap<Integer,Integer> rank;

        public UnionFind(int[] nums){
            parent = new HashMap<>();
            rank = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
                rank.put(num, 1);
            }
        }

        public Integer find(int x){
            if (!parent.containsKey(x)) return null;
            if(x == parent.get(x)) return x;
            parent.put(x,find(parent.get(x)));
            return parent.get(x);
        }

        public void union(int x, int y){
            Integer rootx = find(x),rooty = find(y);
            if ( rootx == rooty) return;
            if (rootx ==null || rooty ==null) return;
            parent.put(rootx,rooty);
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums){
            unionFind.union(num,num+1);
        }
        int max =1;
        for (int v :nums){
            max = Math.max(max, unionFind.find(v) - v +1);
        }
        return max;
    }

//    public int longestConsecutive(int[] nums) {
//        Set<Integer> num_set = new HashSet<Integer>();
//        for (int num : nums) {
//            num_set.add(num);
//        }
//
//        int longestStreak = 0;
//
//        for (int num : num_set) {
//            if (!num_set.contains(num - 1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum + 1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
//
//        return longestStreak;
//    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Leetcode128 leetcode128 = new Leetcode128();
        int re = leetcode128.longestConsecutive(nums);
        System.out.println(re);
    }
}


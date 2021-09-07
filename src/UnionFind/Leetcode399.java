package UnionFind;

//除法中值

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode399 {
    class UnionFind{
        private int[] parent;
        private double[] weight;

        UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public int find(int x){
            if (x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }
         public double isConnected(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty){
                return weight[x] / weight[y];
            }else {
                return -1;
            }
         }
         public void union(int x, int y, double value){
             int rootx = find(x);
             int rooty = find(y);
             if (rootx == rooty) return;
             parent[rootx] = rooty;
             weight[rootx] = weight[y] * value / weight[x];
         }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int esiez = equations.size();
        UnionFind unionFind = new UnionFind(2 * esiez);
        Map<String, Integer> map = new HashMap<>(2 * esiez);
        int id =0 ;
        for (int i=0; i<esiez; i++){
            List<String> eq = equations.get(i);
            String s0 = eq.get(0);
            if (!map.containsKey(s0)){
                map.put(s0, id);
                id++;
            }
            String s1 = eq.get(1);
            if (!map.containsKey(s1)){
                map.put(s1,id);
                id++;
            }
            unionFind.union(map.get(s0),map.get(s1),values[i]);
        }
        int qsize = queries.size();
        double[] result = new double[qsize];
        for (int i=0; i<qsize; i++){
            List<String> qu = queries.get(i);
            String s0 = qu.get(0);
            String s1 = qu.get(1);
            Integer i0 = map.get(s0);
            Integer i1 = map.get(s1);
            if(i0 == null || i1 == null){
                result[i] = -1.0d;
            }else {
                result[i] = unionFind.isConnected(i0,i1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

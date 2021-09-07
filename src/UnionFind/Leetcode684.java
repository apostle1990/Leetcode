package UnionFind;

import java.util.Arrays;

//684. 冗余连接
public class Leetcode684 {
    static class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int[][] edges){
            parent = new int[edges.length+1];
            rank = new int[edges.length+1];
            for (int[] edge : edges){
                parent[edge[0]] = edge[0];
                parent[edge[1]] = edge[1];
                rank[edge[0]] =0;
                rank[edge[1]] =0;
            }
        }

        public int find(int x){
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx!=rooty){
                if(rank[rootx] < rank[rooty]){
                    parent[rootx] = rooty;
                }else if (rank[rootx] > rank[rooty]){
                    parent[rooty] = rootx;
                }else {
                    parent[rooty] = rootx;
                    rank[rooty]++;
                }
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges);
        int[] result = new int[0];
        for (int[] edge : edges) {
            if (unionFind.find(edge[0]) == unionFind.find(edge[1])) {
                result = edge;
                break;
            }else {
                unionFind.union(edge[0], edge[1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode684 leetcode684 = new Leetcode684();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] result = leetcode684.findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }
}

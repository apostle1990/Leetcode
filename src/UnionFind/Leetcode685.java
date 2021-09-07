package UnionFind;

import java.util.Arrays;

//685. 冗余连接 II
public class Leetcode685 {

    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n+1];
            for (int i=1; i<n+1; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) return false;
            parent[rootx] = rooty;
            return true;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n+1];
        for (int[] edge : edges){
            in[edge[1]]++;
        }
        for (int i = n-1; i>=0;i--){
            if (in[edges[i][1]]==2){
                if (!circle(edges,n,i)) return edges[i];
            }
        }
        for (int i = n -1; i>=0;i--){
            if (in[edges[i][1]]==1){
                if (!circle(edges,n,i)) return edges[i];
            }
        }
        return new int[0];
    }

    public boolean circle(int[][] edge , int len, int removeindex){
        UnionFind unionFind = new UnionFind(len);
        for (int i=0; i<len; i++){
            if (i == removeindex) continue;
            if (!unionFind.union(edge[i][0],edge[i][1])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        Leetcode685 leetcode685 = new Leetcode685();
        int[] re = leetcode685.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(re));
    }
}

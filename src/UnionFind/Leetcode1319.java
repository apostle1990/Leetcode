package UnionFind;

public class Leetcode1319 {
    class UnionFind{
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
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
                --count;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;
        UnionFind unionFind = new UnionFind(n);
        for (int[] con : connections){
            unionFind.union(con[0], con[1]);
        }
        return unionFind.count - 1;
    }

    public static void main(String[] args) {
        Leetcode1319 leetcode1319 = new Leetcode1319();
        int n=4;
        int[][] connections = {{0,1}, {0,2},{0,3}, {1,2}};
        int result =  leetcode1319.makeConnected(n,connections);
        System.out.println(result);
    }
}

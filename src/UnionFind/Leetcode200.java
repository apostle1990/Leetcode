package UnionFind;

//岛屿数量
public class Leetcode200 {
    static class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid){
            count =0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i=0; i<m; ++i){
                for (int j=0; j<n; ++j){
                    if (grid[i][j] == '1'){
                        parent[i*n+j] = i*n+j;
                        ++count;
                    }
                    rank[i*n+j] = 0;
                }
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

        public int getCount(){
            return count;
        }

    }
    public int numIslands(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; ++i){
            for (int j=0; j<n; ++j){
                if (grid[i][j] == '1'){
                    grid[i][j]='0';
                    if (i-1 >=0 && grid[i-1][j] == '1'){
                        unionFind.union(i * n + j, (i-1) * n + j);
                    }
                    if (i+1 <m && grid[i+1][j] == '1'){
                        unionFind.union(i * n + j, (i+1) * n + j);
                    }
                    if (j-1 >=0 && grid[i][j-1] == '1'){
                        unionFind.union(i * n + j, i * n + j - 1);
                    }
                    if (j+1 <n && grid[i][j+1] == '1'){
                        unionFind.union(i * n + j, i * n + j +1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    public static void main(String[] args) {
        Leetcode200 leetcode200 = new Leetcode200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        UnionFind unionFind = new UnionFind(grid);
        System.out.println();
        int re = leetcode200.numIslands(grid);
        System.out.println(re);
    }
}

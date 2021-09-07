package Backtracking;

import java.util.Arrays;

public class Leetcode529 {
    int[][] DIRECTIONS = {{-1, 0}, {-1, 1}, {-1, -1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int[] direction : DIRECTIONS) {
            int newx = x + direction[0];
            int newy = y + direction[1];
            if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) continue;
            if (board[newx][newy] == 'M') ++cnt;
        }
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int[] direction : DIRECTIONS) {
                int newx = x + direction[0];
                int newy = y + direction[1];
                if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length || board[newx][newy] != 'E')
                    continue;
                dfs(board, newx, newy);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode529 leetcode529 = new Leetcode529();
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] res = leetcode529.updateBoard(board, click);
        for (char[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}

package com.leetcode;

/**
 * @author chappyzhao
 */
public class RouteIntrix {

    public static boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        int wordDirction = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, wordChar, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] wordChar, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != wordChar[k]) {
            return false;
        }
        if (k == wordChar.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, wordChar, i + 1, j, k + 1) || dfs(board, wordChar, i - 1, j, k + 1)
                || dfs(board, wordChar, i, j - 1, k + 1) || dfs(board, wordChar, i, j + 1, k + 1);
        // 先取消再赋值回来
        board[i][j] = wordChar[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}

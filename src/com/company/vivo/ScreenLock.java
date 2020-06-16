package com.company.vivo;

/**
 * @description: 3*3锁屏方案数
 * @author: cfireworks
 * @create: 2020-06-06 15:16
 **/
public class ScreenLock {
    private static int[][] diret = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    private static int[][] diret2 = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    private static int[][] diret3 = {{0,2},{2,2},{2,0},{2,-2},{-2,0},{-2,-2},{0,-2},{-2,2}};
    private static int count=0;
    public static int solution (int m, int n) {
        boolean[][] board = new boolean[3][3];
        // write code here
        for(int i=0;i<3; ++i){
            for(int j=0; j<3; ++j){
                board[i][j] = true;
                backtrack(board, i, j, 1, m, n);
                board[i][j] = false;
            }
        }
        return count;
    }
    public static void backtrack(boolean[][] board, int i, int j, int len, int m, int n){
        if(len >= m && len <= n ) count++;
        if(len == n) return;
        for(int[] off : diret){
            int ni = i+off[0];
            int nj = j+off[1];
            if(ni < 0 || ni>2 || nj<0 || nj > 2 || board[ni][nj]) continue;
            board[ni][nj] = true;
            backtrack(board, ni, nj, len+1, m, n);
            board[ni][nj] = false;
        }
        for(int[] off : diret2){
            int ni = i+off[0];
            int nj = j+off[1];
            if(ni < 0 || ni>2 || nj<0 || nj > 2 || board[ni][nj]) continue;
            board[ni][nj] = true;
            backtrack(board, ni, nj, len+1, m, n);
            board[ni][nj] = false;
        }
        for(int[] off : diret3){
            int ni = i+off[0];
            int nj = j+off[1];
            if(ni < 0 || ni>2 || nj<0 || nj > 2 || board[ni][nj] || board[(ni+i)/2][(nj+j)/2]==false) continue;
            board[ni][nj] = true;
            backtrack(board, ni, nj, len+1, m, n);
            board[ni][nj] = false;
        }
    }
    public static void main(String[] args){
        solution(1,2);
        System.out.println(count);
    }
}

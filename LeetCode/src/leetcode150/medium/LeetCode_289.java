package leetcode150.medium;

import java.util.Arrays;

/**
 * 生命游戏
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/game-of-life/
 */
public class LeetCode_289 {

    public void gameOfLife(int[][] board) {
        if (board.length <= 0 || board[0].length <= 0) {
            return;
        }
        int rowLength = board.length;
        int colLength = board[0].length;
        //方向数组：上下左右，右上、右下，左上、左下
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
        int[][] temp = new int[rowLength][colLength];
        //深拷贝
        for (int i = 0; i < rowLength; i++) {
            temp[i] = Arrays.copyOf(board[i], board[i].length);
        }
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int live = 0;
                for (int dir = 0; dir < dx.length; dir++) {
                    int neighborX = row + dx[dir];
                    int neighborY = col + dy[dir];
                    if (((neighborX >= 0 && neighborX < rowLength) &&
                            (neighborY >= 0 && neighborY < colLength))
                            && temp[neighborX][neighborY] == 1) {
                        live += 1;
                    }
                }
                //1为活细胞
                //周围 1、活细胞少于两个，死亡 2、有两个或三个活细胞，存活 3、超过三个活细胞，死亡
                if (temp[row][col] == 1 && (live < 2 || live > 3)) {
                    board[row][col] = 0;
                }
                //0为死细胞
                //周围有三个活细胞就复活
                if (temp[row][col] == 0 && live == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        LeetCode_289 code289 = new LeetCode_289();
        code289.gameOfLife(test);
        System.out.println(Arrays.deepToString(test));
        //[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        //[[0,0,0],[0,0,1],[0,1,1],[0,0,0]]
    }

}

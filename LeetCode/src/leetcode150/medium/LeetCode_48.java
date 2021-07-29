package leetcode150.medium;

import java.util.Arrays;

/**
 * 旋转图像
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotate-image/
 */
public class LeetCode_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int turns = n / 2;

        //圈数的遍历,最外层为0，往里一层为1，从对角线上的一个元素开始横向遍历，获取其他三个元素
        //假如A点坐标是a_{0, j},  则:B点坐标就是a_{j, N-1},  C点坐标就是a_{N-1, N-1-j}, D点坐标就是a_{N-1-j, 0}，N为当前圈数的边长
        for (int i = 0; i < turns; i++) {
            //length为当前圈数时的n
            int length = n - i * 2;
            for (int j = 0; j < length - 1; j++) {
                int temp = matrix[i][j + i];
                //A
                matrix[i][j + i] = matrix[length - 1 - j + i][i];
                //D
                matrix[length - 1 - j + i][i] = matrix[length - 1 + i][length - 1 - j + i];
                //C
                matrix[length - 1 + i][length - 1 - j + i] = matrix[j + i][length - 1 + i];
                //B
                matrix[j + i][length - 1 + i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_48 code48 = new LeetCode_48();
        int[][] test = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        code48.rotate(test);
        System.out.println(Arrays.deepToString(test));
        //[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}

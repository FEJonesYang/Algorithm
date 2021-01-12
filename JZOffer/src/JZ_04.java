/**
 * @Description: 二维数组的查找问题
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * @Author: JonesYang
 * @Data: 2021-01-12
 */
public class JZ_04 {

    /**
     * 方法一：暴力破解
     * 这个方法是最简单的直接对数组进行遍历，效率不高，时间复杂度：O（n2）
     */
    private boolean findNumberIn2DArray_Method_1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：可以把数组看成是平衡二叉树
     */
    private boolean findNumberIn2DArray_Method_2(int[][] matrix, int target) {
        //边界条件判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        //从右上角开始进行遍历
        int r = matrix.length - 1, c = matrix[0].length - 1;
        while (r < matrix.length - 1 && c >= 0) {
            //1、如果找到
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                //如果当前值小于 target
                r++;
            } else {
                //如果当前值小于 target
                c--;
            }
        }
        return false;
    }
}

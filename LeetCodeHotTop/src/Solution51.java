import java.util.*;

/**
 * @Author: JonesYang
 * @Data: 2021-06-14
 * @Description:51. N 皇后
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 1、需要容器进行存储那些位置已经有皇后了
 * 2、递归 + 回溯---> 这道题和数独那个题很相似
 * <p>
 * 回溯的套路-->
 * 1、尝试枚举所有的可能
 * 2、依次尝试这些选择，做出一种选择，并依次往下递归
 * 3、如果做出了不正确的选择，就需要进行现场恢复
 */
public class Solution51 {
    // 存放临时的数据
    char[][] chessboard;
    // 结果返回
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        // 表格数据初始化
        for (char[] ch : chessboard) {
            Arrays.fill(ch, '.');
        }
        // 开始进行递归
        dfs(n, 0);
        return res;
    }

    /**
     * 递归 + 回溯
     *
     * @param n   皇后的数量=格子的行数和列数
     * @param row 当前遍历到哪一行了
     */
    private void dfs(int n, int row) {
        // 递归终止条件
        if (row == n) {
            res.add(initArray(chessboard));
            return;
        }
        // 递归在本层需要进行的处理
        for (int col = 0; col < n; col++) {
            // 如果行、列或者对角线存在 Q 的话，就 continue，总之每一行要放一个数据
            if (!isValid(row, col, n)) {
                continue;
            }
            // 尝试存放 Q
            chessboard[row][col] = 'Q';
            // 开启下一轮递归，进入下一行
            dfs(n, row + 1);
            // 进行回溯，现场恢复
            chessboard[row][col] = '.';
        }
    }

    /**
     * 在检查的过程中，行是不可能会出现冲突的，因为我们是每一行放置元素的
     *
     * @param row
     * @param col
     * @param n
     * @return
     */
    private boolean isValid(int row, int col, int n) {
        // 检查每一列
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查正对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查反对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 把表格里的数据添加到集合里
     *
     * @param chessboard
     * @return
     */
    private List<String> initArray(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }

}

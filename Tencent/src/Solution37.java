
/**
 * @Author: JonesYang
 * @Data: 2021-05-10
 * @Description: 37. 解数独
 * <p>
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {
        // 记录每一行、每一列、每个子数独某个数字是否已经存在
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        // 开始遍历表格，对每一个位置进行初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, box, 0, 0);
    }

    /**
     * 递归 + 回溯
     *
     * @param board
     * @param row
     * @param col
     * @param box
     * @param i
     * @param j
     */
    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int i, int j) {
        // 寻找空位置，进行数据填充
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }

        for (int k = 0; k < 9; k++) {
            int boxIndex = i / 3 * 3 + j / 3;
            // 如果都没有被使用过
            if (!row[i][k] && !col[j][k] && !box[boxIndex][k]) {
                // 在本层进行数据更新
                board[i][j] = (char) (k + '1');
                row[i][k] = true;
                col[j][k] = true;
                box[boxIndex][k] = true;
                // 开始下一轮递归
                if (dfs(board, row, col, box, i, j)) {
                    return true;
                } else {
                    // 进行回溯
                    row[i][k] = false;
                    col[j][k] = false;
                    box[boxIndex][k] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}

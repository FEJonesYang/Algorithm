import java.util.HashMap;

/**
 * @Author: JonesYang
 * @Data: 2021-05-10
 * @Description:36. 有效的数独
 * <p>
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 没有比较好的方法，算法思想不多，主要是这个过程中锻炼自己的编码能力
 */
public class Solution36 {


    /**
     * 解决思路：
     * 1、没一行、每一列都用还有每一个3x3 的方格都用 HashMap 存储访问到的变量。
     * 2、对 HashMap 进行初始化
     * 3、如何确定每一个子数独的位置了？（重点、难点）--> (i / 3) * 3 + j / 3，可以参考这篇文章
     * https://leetcode-cn.com/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 初始化 HashMap
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        // 开始对整个表格进行遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num;
                    int box_index = (i / 3) * 3 + j / 3;
                    // 存入数据
                    row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                    col[j].put(n, col[j].getOrDefault(n, 0) + 1);
                    box[box_index].put(n, box[box_index].getOrDefault(n, 0) + 1);

                    // 进行参数检查
                    if (row[i].get(n) > 1 || col[i].get(n) > 1 || box[i].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

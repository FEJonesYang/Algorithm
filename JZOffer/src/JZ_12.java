/**
 * @Description:矩阵搜索问题 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: JonesYang
 * @Data: 2021-01-18
 */
public class JZ_12 {

    /**
     * 题解分析：来源与力扣
     * <p>
     * 本题采用 深度优先搜索（DFS）+ 剪枝
     * <p>
     * 思路：可以对矩阵的元素实现暴力求解，直到找到匹配的字符，
     * 再采用 DFS + 递归 的方法对矩阵实现搜索，终止条件如下：
     * 1、访问数组越界
     * 2、访问数组的字符串不匹配
     * <p>
     * 当上、下、左、右都不满足的时候，就进行回溯
     */
    private boolean exist(char[][] board, String word) {
        //字符串数组转化成 char[] 类型的数组
        char[] words = word.toCharArray();
        //双重for循环遍历矩阵的元素
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // DFS 搜索进行匹配元素
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * board --> 矩阵
     * word --> 字符数组
     * i,j,k --> 三个不同的方向
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j > board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：
     * O（3^K * MN）--> 3^K 是方案的选择每一次进行递归的时候有四个方向进行选择，但是除去上一个方向
     * 就有三个方向进行选择；M * N 是对矩阵进行暴力搜索所需要的时间复杂度。
     *
     * 空间复杂度：
     * 需要一个空间大小不超过字符串长度的数组，所需要的空间复杂度为O（N^2）
     *
     * */
}

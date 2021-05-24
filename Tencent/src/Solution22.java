import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-15
 * <p>
 * 括号生成
 * 这道题应该思考下面的两个点：
 * - 当存入右括号的时候，左括号的数量必须小于右括号
 * - dfs 遍历
 */
public class Solution22 {

    /// 用于存储所有的结果
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {

        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 如果左括号还剩余的话
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }
        // 如果右括号还剩余的话
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }
}

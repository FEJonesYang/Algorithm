import java.util.*;

/**
 * @Author: JonesYang
 * @Data: 2021-06-17
 * @Description:40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution40 {
    // 用于结果返回
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, path, len, target, 0);
        return res;
    }

    /**
     * @param candidates 数组
     * @param path       临时的集合
     * @param len        数组长度
     * @param target     目标值
     * @param begin      开始计算的位置
     */
    private void dfs(int[] candidates, Deque<Integer> path, int len, int target, int begin) {
        // 递归终止条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 避免重复计算，这里对于避免重复计算的思考如下：
            // 这个问题和前面一个问题是有区别的，第 39 题的数组里的元素是没有重复的，但是这道题的数组元素是可以有重复的，
            // 所以前者只需要记录一个当前位置的索引值就可以实现去重。

            // 但是在这里，数组元素是重复的，只有当前搜索位置的索引是不够的，还需要避免在同一层中使用相同的元素，但是不同的层是可以
            // 使用相同的元素的。 candidates[i - 1] == candidates[i] 用于判断两个数是不是相等的，i > begin 是解决同一层级
            // 中会出现相同的数字的问题
            if (i > begin && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            // 开始下一个轮的递归，i + 1 ，是为了解决数组不可重复使用的规定，真正的重点在于 去重
            dfs(candidates, path, len, target - candidates[i], i + 1);
            // 回溯
            path.removeLast();
        }
    }
}

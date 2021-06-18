import java.util.*;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description:39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 递归 + 回溯
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 数组
     * @param begin      开始搜索的位置
     * @param len        数组长度
     * @param target     目标值
     * @param path       访问的路径
     * @param res        返回的最终结果
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件--由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 递归在本层进行的处理,重点从 begin 开始进行搜索
        for (int i = begin; i < len; i++) {
            // 剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错，
            //从每一层的第 2 个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素（去重），所以这里引入的了begin，
            // 记录开始进行搜索的位置，由于 begin 是递增的，所以每一层中不会使用前面使用过的元素
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}

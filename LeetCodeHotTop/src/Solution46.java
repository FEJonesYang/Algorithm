import java.util.*;

/**
 * @Author: JonesYang
 * @Data: 2021-06-15
 * @Description:46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 递归的回溯的区别，在一定程度上来说，使用回溯算法的话一般都需要使用递归
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(nums, res, temp, visited, len, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited, int len, int deep) {
        // 递归终止条件
        if (deep == len) {
            // 注意这里不能直接写成 res.add(temp);
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                // 本层进行的数据处理
                visited[i] = true;
                temp.add(nums[i]);
                // 递归到下一层
                dfs(nums, res, temp, visited, len, deep + 1);
                // 回溯
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}

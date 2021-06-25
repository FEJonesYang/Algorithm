import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JonesYang
 * @Data: 2021-06-24
 * @Description: 46. 全排列
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
 * 回溯  + 剪枝
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(nums, res, path, len, 0, visited);
        return res;
    }

    /**
     * @param nums    输入数组
     * @param res     返回值
     * @param path    临时变量
     * @param len     数组长度
     * @param deep    数组深度
     * @param visited 是否使用过
     */
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int len, int deep, boolean[] visited) {
        // 如果当前的深度已经达到数组的长度
        if (deep == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 当前的这个元素没有被使用过
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[deep]);
                // 开始进行递归
                dfs(nums, res, path, len, deep + 1, visited);
                // 回溯
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}

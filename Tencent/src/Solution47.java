import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JonesYang
 * @Data: 2021-06-24
 * @Description:47. 全排列 II
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        dfs(nums, res, path, len, 0, visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int len, int deep, boolean[] visited) {
        // 递归终止条件，如果当前递归的深度等于数组的长度
        if (deep == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 如果当前的这个元素已经被使用过了，立即返回
            if (visited[i]) {
                continue;
            }
            // 重点分析：
            // 1、什么情况下需要剪枝：<1>.一个元素和他的前一个元素发生了重复;
            //                     <2>.并且它的前一个元素在当前的层没有被用到过，正是因为没有用到，在下一层它还会出现，
            //                         这和第一次使用该元素造成了重复，故需要排除
            // 2、i > 0 的作用是保证 nums[i - 1] 是有效的
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            // 开启下一轮的递归，deep 深度加 1
            dfs(nums, res, path, len, deep + 1, visited);
            // 回溯
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}

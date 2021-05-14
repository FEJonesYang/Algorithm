import java.util.*;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-14
 * <p>
 * 四数之和：核心是双指针的思想，todo ：不过目前本题还出现一些问题
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        HashMap<List, List> map = new HashMap<>();
        while (left < right) {
            int i = left + 1;
            int j = right - 1;
            int temp = nums[left] + nums[left + 1] + nums[right - 1] + nums[right];
            while (i < j) {
                int sum = nums[left] + nums[i] + nums[j] + nums[right];
                if (sum > target) {
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[right]);
                    Collections.sort(list);
                    if (!map.containsKey(list)) {
                        map.put(list, list);
                        res.add(list);
                    }
                    i++;
                    j--;
                }
            }
            // 对 left 和 right 的处理
            if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}

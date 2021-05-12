import java.util.*;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-12
 *
 * 对数组进行排序，排序之后使用双指针
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 合法性校验
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果要等于0，又由于是升序，所有后面的元素加起来一定会大于0
            if (nums[i] > 0) {
                break;
            }
            // 避免前一个数字和后面的一个数字出现重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 计算总和
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    // 到这里需要处理剪枝的情况
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                }
            }


        }

        return res;
    }
}


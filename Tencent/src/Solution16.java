import java.util.*;


/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-13
 * <p>
 * 最接近的三数字之和，存在相等的情况直接 return
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 计算当前的总和
                int sum = nums[i] + nums[left] + nums[right];
                // 选择最接近的数据
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                // 对左右指针进行移动
                if (left < right && sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

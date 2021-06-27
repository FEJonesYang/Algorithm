import java.util.Arrays;

/**
 * @Author: JonesYang
 * @Data: 2021-06-26
 * @Description:31. 下一个排列
 * <p>
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        // 边界条件判断
        if (nums == null || nums.length < 2) {
            return;
        }
        // 记录一个需要交换最小位置的 index
        int minIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                minIndex = i - 1;
                break;
            }
        }
        // 先判断这个 Index 有没有发生改变
        if (minIndex == -1) {
            Arrays.sort(nums);
        } else {
            for (int i = nums.length - 1; i > minIndex; i--) {
                if (nums[i] > nums[minIndex]) {
                    int temp = nums[minIndex];
                    nums[minIndex] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, minIndex + 1, nums.length);
                    break;
                }
            }
        }
    }
}

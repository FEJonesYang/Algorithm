/**
 * @Author: JonesYang
 * @Data: 2021-05-30
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 方法一：暴力求解，时间复杂度为O(N)
 * 方法二：二分查找，时间复杂度为O(logN)
 */
public class Solution34 {
    /*
     * 二分查找，分别找上边界和下边界
     * */
    public int[] searchRange(int[] nums, int target) {
        int left = lowBound(nums, target);
        int right = highBound(nums, target);

        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    /*
     * 找下边界
     * */
    int lowBound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /*
     * 找上边界
     * */
    int highBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}

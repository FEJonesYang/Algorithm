/**
 * @Author: JonesYang
 * @Data: 2021-05-10
 * @Description:35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 处理特殊情况
        if (target <= nums[0]) return 0;
        // 因为是按照顺序插入，所以大于和等于要分开操作
        if (target == nums[right]) return right;
        if (target > nums[right]) return right + 1;

        /// 开始进行二分操作
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果之前没有返回结果，就在这里返回 left
        return left;
    }
}

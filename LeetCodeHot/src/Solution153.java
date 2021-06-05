/**
 * @Author: JonesYang
 * @Data: 2021-06-05
 * @Description: 153. 寻找旋转排序数组中的最小值
 * 二分查找
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 两者相等的时候，表示已经找到，所以不需要取等号
        while (left < right) {
            int mid = (left + right) / 2;
            // 中间的数如果比右边的数要小，改变右指针的位置
            if (nums[mid] < right) {
                // 注意这里不取 right = mid - 1;防止 nums[mid] 是最小的数，如果减1之后，就永远得不到最小的值了
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

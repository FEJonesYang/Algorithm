/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-29
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        // 定义两个指针
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            /// 如果两个相邻的元素不相等，则两个指针同时移动
            if (nums[left] != nums[right]) {
                left++;
                right++;
            } else {
                // 需要找到右边第一个不相等的数据
                while (right < nums.length) {
                    if (nums[right] != nums[left]) {
                        break;
                    }
                    right++;
                }
                // 如果right的还小于 num.length,说明找到了不相等的数据，
                // 就进行替换
                if (right < nums.length) {
                    int temp = nums[right];
                    nums[left + 1] = temp;
                    left++;
                }
            }
        }

        return left + 1;
    }
}

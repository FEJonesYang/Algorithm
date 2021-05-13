/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-13
 * <p>
 * 调整数组的顺序，使得奇数位于偶数的前面:双指针
 */
public class JZ_21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}

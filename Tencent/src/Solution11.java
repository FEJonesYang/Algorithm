/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 *
 * 本质的思想是双指针，通过左右指针的移动来对当前数组的进行遍历，每一次移动左指针或者右指针
 * ，要获得最大的盛水容积
 */

class Solution11 {
    public int maxArea(int[] height) {
        int res = 0; // 记录最大值
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            int h = height[left] > height[right] ? height[right] : height[left];
            int temp = h * (right - left);
            // 如果当前的值大于记录的最大值，则更新
            if (temp > res) {
                res = temp;
            }
            // 进行下一轮迭代
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
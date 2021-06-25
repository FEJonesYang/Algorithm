/**
 * @Author: JonesYang
 * @Data: 2021-06-18
 * @Description:45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 贪心算法，寻找局部最优解
 */
public class Solution45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 表示能查找的范围
        int end = 0;
        // process(nums,left,right);
        int maxPosition = 0;
        // 记录步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 寻找能够跳的最大值
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 如果到达边界，则更新范围
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}

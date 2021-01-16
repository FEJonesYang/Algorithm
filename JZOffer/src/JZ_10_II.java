/**
 * @Description:青蛙跳台阶问题 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: JonesYang
 * @Data: 2021-01-17
 */
public class JZ_10_II {
    private int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2 && n > 0) return n;
        int n1 = 1, n2 = 2;
        int nums = 0;
        for (int i = 2; i < n; i++) {
            nums = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = nums;
        }
        return nums;
    }
}

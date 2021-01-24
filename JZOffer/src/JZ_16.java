/**
 * @Description:数值的整数次方 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: JonesYang
 * @Data: 2021-01-23
 */
public class JZ_16 {
    /**
     * 方法是正确的，但是会超过时间限制
     */
    private static double myPow_Method_I(double x, int n) {
        double sum = 1;
        //如果 n 等于0
        if (n == 0) return 1;
        //如果 n 大于0
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                sum *= x;
            }
        } else { // n 小于 0
            for (int i = 0; i > n; i--) {
                sum *= (1.0 / x);
            }
        }

        return sum;
    }

    /**
     * 快速幂法
     */
    public double myPow_Method_II(double x, int n) {
        // 进行特殊值处理
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        // 把 b 转化成正数进行处理
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        // 快速幂
        while (b > 0) {
            // 等于 b % 2 == 1
            if ((b & 1) == 1) res *= x;
            // 循环 X 的平方
            x *= x;
            // 向下整除
            b >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(JZ_16.myPow_Method_I(2.00000, 2147483647));
    }
}

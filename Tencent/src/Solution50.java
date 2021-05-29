/**
 * @Author: JonesYang
 * @Data: 2021-05-29
 * @Description:
 */
public class Solution50 {
    public double myPow(double x, int n) {
        double res = 1;
        // 快速幂-- > 二分
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}

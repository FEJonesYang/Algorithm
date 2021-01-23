/**
 * @Description:剪绳子I 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: JonesYang
 * @Data: 2021-01-21
 */
public class JZ_14_I {
    int max = 1;

    private int cuttingRope_Method_I(int n) {
        //砍了1刀.....n-1刀
        for (int i = 1; i < n; i++) {
            //7/4=1;
            //分成了i+1段，每段长为a;
            int a = n / (i + 1);
            //平均分后的余数c
            //7%4=3;
            int c = n % (i + 1);
            int temp = 1;
            //将余数平均分到任意余数（3）段
            //有3段的长度为平均长度+1；也就是a+1
            for (int j = 0; j < c; j++) {
                temp = temp * (a + 1);
            }
            //剩下的余数没分到的则还为原来的长度a
            for (int j = 0; j < i + 1 - c; j++) {
                temp = temp * a;
            }
            //哪一刀出现最大值
            max = Math.max(max, temp);
        }
        return max;
    }
}

/**
 * @Author: JonesYang
 * @Data: 2021-06-18
 * @Description:43. 字符串相乘 --> 字符串如何转化成数字，相乘之后转化为字符串输出
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        if (len1 < 0 || len2 < 0) {
            return "";
        }

        // 用于存储放计算所得的结果
        int[] mul = new int[len1 + len2 + 2];

        for (int i = len1; i >= 0; --i) {
            for (int j = len2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(i) - '0');
                // 先加低位判断是否有新的进位
                bitmul += mul[i + j + 1];
                // 这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while (i < mul.length - 1 && mul[i] == 0)
            i++;
        for (; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}

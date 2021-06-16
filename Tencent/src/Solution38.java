import java.util.HashMap;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description:38. 外观数列
 * <p>
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution38 {
    public String countAndSay(int n) {
        // 定义一个结果返回的值
        String res = "1";
        // 总共有多少个数
        for (int i = 1; i < n; i++) {
            // 记录每一次循环上一次记录的数字
            StringBuilder temp = new StringBuilder();
            // 对 res 的遍历，记录那些数字重复了几次
            for (int j = 0; j < res.length(); j++) {
                int count = 1;
                // 计数
                while (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }
                // 最后把次数和当前的值都存进 StringBuilder 里面
                temp.append(count).append(res.charAt(j));
            }
            res = temp.toString();
        }
        return res;
    }
}

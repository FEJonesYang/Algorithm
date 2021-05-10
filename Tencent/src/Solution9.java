/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 *
 * 判断数字是否是回文数，思路：对字符串进行取模或者求余运算，需要用一个容器存储取余之后的值（也可用一个数字）
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder stringBuilder = new StringBuilder();

        while (x != 0) {
            stringBuilder.append(x % 10);
            x /= 10;
        }
        // stringBuilder 进行遍历
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

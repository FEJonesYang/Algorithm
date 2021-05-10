
/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 * <p>
 * 1.去掉前导空格
 * 2.再是处理正负号
 * 3.识别数字，注意越界情况。
 */
public class Solution8 {
    public int myAtoi(String s) {

        int len = s.length();
        char[] charArray = s.toCharArray();

        int index = 0;
        // 去除前导空格
        while (index < len && charArray[index] == ' ') {
            index++;
        }
        // 去除极端用例: "      "
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 对后续出现的字符进行转换
        int res = 0;
        while (index < len) {
            // 合法性校验
            char currChar = charArray[index];
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;

        }
        return res;
    }
}

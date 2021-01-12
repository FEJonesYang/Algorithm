/**
 * @Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * LeetCode : https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @Author: JonesYang
 * @Data: 2021-01-12
 */
public class JZ_05 {
    public String replaceSpace(String s) {
        //1、需要把字符串转换成字符数组
        char[] chars = s.toCharArray();
        //2、定义一个 StringBuilder 用来存储转换后的字符串
        StringBuilder builder = new StringBuilder();
        //3、遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            //4、如果字符数组中存在空格
            if (chars[i] != ' ') {
                builder.append(chars[i]);
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }
}

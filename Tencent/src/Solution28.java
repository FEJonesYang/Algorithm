/**
 * @Author: JonesYang
 * @Data: 2021-05-29
 * @Description: 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 类似滑动窗口取值
 */
public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        // 当两个字符串长度相等时
        if (haystack.equals(needle)) {
            return 0;
        }

        // 获得needle的长度
        int len = needle.length();
        int left = 0;
        int right = len - 1;

        while (left < haystack.length() - len + 1) {
            String temp = haystack.substring(left, right + 1);
            if (temp.equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }

}

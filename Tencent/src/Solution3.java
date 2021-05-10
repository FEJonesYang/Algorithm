import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 * <p>
 * 求一个数组中无重复字符的最长子串，滑动窗口
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i--) {
            // 如果在map中能够找到相同的元素，则对左窗口的值进行更新
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 不存在就进行更新
            map.put(s.charAt(i),i);
            // 记录的值与当前的值进行比较，取一个最大值
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}

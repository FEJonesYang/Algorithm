import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-11
 *
 * 罗马字符串转换成数字
 */
public class Solution13 {
    public int romanToInt(String s) {

        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(romans[i], nums[i]);
        }

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            // substring 这是一个左闭右开的区间的函数
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }
}

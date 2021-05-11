/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-11
 * <p>
 * 整数转罗马数字，贪心算法
 */
public class Solution12 {
    public String intToRoman(int num) {

        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 一直到这个位上的数大于 num 时才停止
            while (num >= nums[index]) {
                builder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return builder.toString();
    }
}

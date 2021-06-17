import java.util.HashMap;

/**
 * @Author: JonesYang
 * @Data: 2021-06-17
 * @Description:
 */
public class JZ_56_II {
    public int singleNumber(int[] nums) {
        // 定义一个集合，记录数字出现的次数
        HashMap<Integer, Integer> map = new HashMap();
        // 遍历数组，记录数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            // 如果在map集合中存在这样的数了，直接对当前 key 的 value 加 1
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

        }

        // 再一次遍历集合，找到 value == 1 的 key
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return 0;
    }
}

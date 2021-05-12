/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-11
 * <p>
 * 拿到一个字符一次和后面的做比较
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        // 合法性校验
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 初始化返回值
        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i++;
        }
        return res;
    }
}

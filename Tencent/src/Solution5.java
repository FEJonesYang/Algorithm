/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 * <p>
 * 最长回文子串,暴力求解，枚举每一个子字符串，并且维护一个子字符串的最大长度
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        char[] ch = s.toCharArray();


        // 暴力破解，枚举每一个子串，并维护一个长度的最大值
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 当前的长度大于记录的长度，并且子字符串符合回文字符串
                if (j - i + 1 > maxLen && validPalindromic(ch, i, j)) {
                    maxLen = i - begin + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }


    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right){
            if (charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

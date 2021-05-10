/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-10
 *
 * 整数的反转问题，对整数进行取模或者取余运算
 */
public class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            // 存储临时的变量
            int temp = x % 10;
            // 边界的确定
            if(res > 214748364 || (res == 214748364 && temp > 7)){
                return 0;
            }
            if(res < -214748364 || (res == -214748364 && temp < -8)){
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}

/**
 * @Author: JonesYang
 * @Data: 2021-06-17
 * @Description: 位运算
 */
public class JZ_56_I {
    public int[] singleNumbers(int[] nums) {
        // 定义一个整形变量，记录整个数组异或得到的结果
        int eor = 0;
        // 最后得到的结果就是 A^B 的值
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        // 取出最后一位不为0的数
        int num = eor & (~eor + 1);
        // 记录其中的一个值
        int A = 0;
        // 再一次遍历数组，拿到其中的一个数
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & num) != 0) {
                A ^= nums[i];
            }
        }
        // 另一个数可以用已经得到的数与它进行异或
        int B = eor ^ A;
        return new int[]{A, B};
    }
}

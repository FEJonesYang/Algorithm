/**
 * @Description:旋转数组的最小数字 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
 * 该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: JonesYang
 * @Data: 2021-01-17
 */
public class JZ_11 {
    public int minArray(int[] numbers) {
        //定义一个 flag
        boolean flag = false;
        for (int i = 1; i < numbers.length; i++) {
            //如果存在后一个数比前一个数小的情况，则更改 flag并返回
            if (numbers[i] < numbers[i - 1]) {
                flag = true;
                return numbers[i];
            }
        }
        //如果该数组不是旋转数组，则直接返回数组首元素
        if (!flag) {
            return numbers[0];
        }
        return 0;
    }
}

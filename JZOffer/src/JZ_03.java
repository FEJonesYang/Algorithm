import java.util.HashSet;

/**
 * @Description: 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * @Author: JonesYang
 * @Data: 2021-01-11
 */
public class JZ_03 {

    //假设这里给出的数组为 arr
    private int[] arr = new int[5];

    /**
     * 双重循环，时间复杂度高，复杂度为 O(n2),空间复杂度我为 O(1)
     */
    private int method_1() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return 0;
    }

    /**
     * 使用一个集合（一般是 HashMap 或者 HashSet）存放已经遍历的数字，遍历下一个数字时，
     * 需要与集合中的已有的数字进行比较，如果无法进行插入时，则代表该数字重复
     */
    private int method_2() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return 0;
    }

    /**
     * 1、遍历数组，如果当前值和它对应的位置的值不相等就需要进行后续操作。
     * 2、判断要交换的位置是否存在和他相等的值，如果不存在就进行交换，否则直接返回该重复的值。
     */
    private int method_3() {
        //定义交换时的临时变量
        int temp;
        for (int i = 0; i < arr.length; i++) {
            //1、 当这个数字的值和它所对应的位置不相等时,就需要找到对应的数字
            while (arr[i] != i) {
                // 2、数字对应的位置上不存在和他相等的值
                if (arr[i] != arr[arr[i]]) {
                    temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                } else {
                    return arr[i];
                }
            }
        }
        return 0;
    }

}

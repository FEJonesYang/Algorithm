import java.util.HashSet;

/**
 * @Description: 找出数组中重复的数字。
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

    private int method_3() {
        //定义交换时的临时变量
        int temp;
        for (int i = 0; i < arr.length; i++) {
            // 当这个数字的值和它所对应的位置不相等时,就需要找到对应的数字
            while (arr[i] != i) {
                // 数字对应的位置不存在
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

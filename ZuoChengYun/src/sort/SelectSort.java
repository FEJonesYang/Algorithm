package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-15
 * @Description: 选择排序算法 --> 选取剩下数组中最小的元素
 */
public class SelectSort {
    /**
     * @param arr 需要排序的数组
     */
    private int[] selectSort(int[] arr) {
        // 最好进行特殊值的判断
        if (arr == null || arr.length < 2) {
            return arr;
        }
        // 开始进行选择排序
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 找到最小的那个值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 进行数据交换
            int tem = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tem;
        }
        return arr;
    }
}

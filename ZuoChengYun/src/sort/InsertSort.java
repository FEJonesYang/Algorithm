package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description: 插入排序算法 --> 每次需要保证求那几个数是有序的
 */
public class InsertSort {
    private int[] insertSort(int[] arr) {
        // 检查是否有效
        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 开始进行插入排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int tem = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        return arr;
    }
}

package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description: 冒泡排序算法
 */
public class BubbleSort {
    private int[] bubbleSort(int[] arr) {
        // 检查是否有效
        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 开始进行冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 对冒泡排序的简单优化
            boolean isChange = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isChange = true;
                }
            }
            // 如果没有发生数组元素交换，说明数组都是有序的，则跳出循环
            if (!isChange) {
                break;
            }
        }
        return arr;
    }
}

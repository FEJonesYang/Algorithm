package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description: 快速排序算法
 * <p>
 * 选择基准元素 + 递归
 */
public class QuickSort {
    private void quickSort(int[] arr, int left, int right) {
        // 递归结束条件
        if (left > right) {
            return;
        }
        // 递归在当前的层需要的处理
        // 1、选择基准元素
        int pivot = arr[left];
        // 2、定义左右边界
        int i = left, j = right;
        // 开始对左右的元素进行排序
        while (i <= j) {
            // 在左边找到大于基准元素的数
            while (i < j && arr[i] < arr[pivot]) i++;
            // 在右边找到小于基准元素的数
            while (i < j && arr[j] > arr[pivot]) j--;
            // 找到之后进行交换
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 还需要交换基准元素
        arr[left] = arr[i];
        arr[i] = pivot;

        // 开启下一轮的递归
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}

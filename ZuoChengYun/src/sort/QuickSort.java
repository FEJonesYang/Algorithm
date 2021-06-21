package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-16
 * @Description: 快速排序算法，随机选择基准元素
 * <p>
 * 选择基准元素 + 递归
 */
public class QuickSort {
    private void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0, right = arr.length - 1;
        process(arr, left, right);
    }

    private void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 在 left .. right 的区间内找一个随机数
        int pivot = (int) (Math.random() * (right - left + 1));
        // 先把随机选择的元素与数组最右边的数进行交换
        swap(arr, left + pivot, right);
        // 获取相等的区域
        int[] area = equalArea(arr, left, right);
        // 开始下一轮的递归
        process(arr, left, area[0] - 1);
        process(arr, area[1] + 1, right);
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] equalArea(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        // 记录小于基准元素的边界
        int less = left - 1;
        // 记录大于基准元素的边界
        int more = right;
        // 用于在这个过程中迭代整个数组
        int index = left;
        while (index < more) {
            // 在相等的情况下，左边界不会发生移动
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                // 如果当前 index 的值小于基准元素，那么 index 和 ++less 对应位置上的元素进行交换
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        return new int[]{less + 1, more};
    }
}

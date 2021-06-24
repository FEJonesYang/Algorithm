package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-22
 * @Description: 归并排序及其实例
 */
public class MergeSort {
    private void recurMergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0, right = arr.length - 1;
        process(arr, left, right);
    }

    /**
     * 递归实现归并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 非递归实现归并排序
     *
     * @param arr
     */
    private void process1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int mid = L + mergeSize - 1;
                if (mid >= N) {
                    break;
                }
                int R = Math.min(mid + mergeSize, N - 1);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }

    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        // 左边和右边的数据进行排序，放到 helper 数组
        while (p1 <= mid && p2 <= right) {
            helper[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= right) {
            helper[i++] = arr[p2++];
        }
        // 最后把合并后的数组对结果数组进行赋值
        for (i = 0; i < helper.length; i++) {
            arr[i] = helper[i];
        }
    }
}

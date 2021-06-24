package sort;

/**
 * @Author: JonesYang
 * @Data: 2021-06-24
 * @Description:归并排序的实例--小和问题 在一个数组中，一个数左边比它小的数的总和，叫数的小和。
 * 所有数的小和累加起来，叫做数组小和，求数组小和。
 */
public class MergeSortInstance {
    private int minSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0, right = arr.length - 1;
        process(arr, left, right, res);
        return res;
    }

    private int process(int[] arr, int left, int right, int res) {
        if (left == right) {
            return 0;
        }
        int M = left + ((right - left) >> 1);
        return process(arr, left, M, res) +
                process(arr, M + 1, right, res) +
                merge(arr, left, M, right, res);
    }

    private int merge(int[] arr, int left, int m, int right, int res) {
        int[] helper = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = m + 1;
        while (p1 <= m && p2 < right) {
            // (right - p2 + 1) --> 右侧数组的中最右边到 p2 的长度
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            helper[i++] = arr[p1++];
        }
        while (p2 < right) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[i] = helper[i];
        }
        return res;
    }

}

package v2.sort;

public class MergeSort {

    /**
     * 并归排序-递归思路
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public int[] mergeSort1(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        return process(arr, L, R);
    }

    private int[] process(int[] arr, int l, int r) {
        if (l == r) {
            return arr;
        }
        int mid = l + ((r - l) >>> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        return merge(arr, l, mid, r);
    }

    private int[] merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, i = 0;
        // 合并左右两边的数，直到有一边越界
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        // 合并剩下的数
        int start = p1 > mid ? p2 : p1;
        int end = p1 > mid ? r : mid;
        while (start <= end) {
            help[i++] = arr[start++];
        }
        // 重新刷回arr数组
        for (int j = 0; j < help.length; j++) {
            arr[l++] = help[j];
        }
        return arr;
    }


    /**
     *  =============================================================
     */

    /**
     * 并归排序-非递归思路
     *
     * @param arr
     * @return
     */
    public void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1, N = arr.length;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                // 计算中点的位置，如果中点的位置大于N，则说明没有右组的数据，不需要合并
                int M = L + mergeSize - 1;
                if (M > N) {
                    break;
                }
                // 计算R的值，M + mergeSize 越界了，则取 N - 1
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止类型溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }


    /**
     *  =============================================================
     */


    /**
     * 数组小和
     *
     * @param arr
     * @return
     */
    public int mergeSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return minSum(arr, 0, arr.length - 1);
    }

    private int minSum(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + (R - L) >>> 1;
        return minSum(arr, L, M) + minSum(arr, M + 1, R) + mergeMinSum(arr, L, M, R);
    }

    private int mergeMinSum(int[] aar, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L, p2 = M + 1, result = 0, i = 0;
        while (p1 <= L && p2 <= R) {
            if (aar[p1] < aar[p2]) {
                result += aar[p1] * (R - p2 + 1);
                help[i++] = aar[p1++];
            } else {
                help[i++] = aar[p2++];
            }
        }
        // 合并剩下的数
        int start = p1 > M ? p2 : p1;
        int end = p1 > M ? R : M;
        while (start <= end) {
            help[i++] = aar[start++];
        }

        for (int j = 0; j < help.length; j++) {
            aar[L++] = help[j];
        }
        return result;
    }

}

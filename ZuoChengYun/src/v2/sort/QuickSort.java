package v2.sort;

public class QuickSort {

    /**
     * 荷兰国旗问题，小于 num 的在左边，num 在中间，大于 num 的在右边
     *
     * @param arr
     */
    public int[] netherLandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1, more = R, index = L;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            }
            // 大于的时候，i 不需要增加
            if (arr[index] > arr[R]) {
                swap(arr, --more, index);
            }
            // 相等的时候直接跳过
            if (arr[index] == arr[R]) {
                index++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    /**
     *  =============================================================
     */

    /**
     * 快排
     *
     * @param arr
     */
    public void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        swap(arr, (int) (L + (Math.random() * (R - L + 1))), R);
        int[] equalArea = netherLandsFlag(arr, L, R);
        quickSort(arr, L, equalArea[0] - 1);
        quickSort(arr, equalArea[1] + 1, R);
    }

}

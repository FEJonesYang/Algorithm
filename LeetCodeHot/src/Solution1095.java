/**
 * @Author: JonesYang
 * @Data: 2021-06-05
 * @Description: 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * <p>
 * 如果不存在这样的下标 index，就请返回 -1。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        // 找顶点
        int topIndex = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid + 1) > mountainArr.get(mid) && mountainArr.get(mid + 1) > mountainArr.get(mid + 2)) {
                topIndex = mid + 1;
                break;
            } else {
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // 对顶点进行判断
        if (mountainArr.get(topIndex) == target) {
            return topIndex;
        }

        // 从左边开始找，左边找到就直接返回，没有找到再开始找右边
        left = 0;
        right = topIndex;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            } else if (target < mountainArr.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 左边没找到,开始找右边的部分
        left = topIndex;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            } else if (target < mountainArr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private class MountainArray {
        public int length() {
            return 0;
        }

        public int get(int mid) {
            return 0;
        }
    }
}

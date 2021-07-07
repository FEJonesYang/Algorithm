/**
 * @Author: JonesYang
 * @Data: 2021-07-06
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ_33 {
    /**
     * 思路：二叉搜索树根节点大于左子树，小于右子树。因此，
     * 后序遍历的规则：
     * 小 -- 大 -- 中
     *
     * @param postorder 进行后序遍历判断的数组
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        // base 判断
        if (postorder == null || postorder.length == 0) return false;
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) return true;

        // p 是第一个大于父节点的值,找到第一个大于 父节点值的P的位置
        int p = left;
        while (postorder[p] < postorder[right]) p++;

        // 观察 p 最后的值，m 的值记录下来用作下一次的递归
        int m = p;
        while (postorder[p] > postorder[right]) p++;

        return p == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}

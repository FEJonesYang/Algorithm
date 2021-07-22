package tree;

/**
 * @Author: JonesYong
 * @Data: 2021-07-23
 * @Description: 99. 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution99 {
    // t1 ,t2 是两个交换的节点，pre 记录它的前一个节点
    // 每次都需要和它的前一个节点做比较，其中 t1 是较大的那个值，t2 是较小的那个值
    TreeNode t1;
    TreeNode t2;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (t1 != null && t2 != null) {
            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        // 整个过程中有两次满足条件
        if (pre.val > node.val) {
            // 如果较大的那个值在前面，应该首先找到，优先进行设置
            if (t1 == null) t1 = pre;
            t2 = node;
        }
        pre = node;
        dfs(node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

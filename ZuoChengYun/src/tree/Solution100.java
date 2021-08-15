package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JonesYong
 * @Data: 2021-08-15
 * @Description: 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Solution100 {

    /**
     * 方法二：直接进行递归判断
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 接下来的情况是其中一个为空，或者两个都不为空
        if (p == null || q == null) { // 其中一个为空的情况，一定是不满足条件的
            return false;
        }
        // 两个节点都不为空的情况
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * 方法一：递归结果存在数组中，需要对数组吧进行判断
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        // 递归遍历，结果存储在数组中
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        dfs(p, listP);
        dfs(q, listQ);

        // 递归完成之后对结果进行处理
        if (listP.size() != listQ.size()) {
            return false;
        }
        for (int i = 0; i < listP.size(); i++) {
            // 这种情况下两个节点都是空节点
            if (listP.get(i) == listQ.get(i)) {
                continue;
            }
            // 如果两个都不为空节点
            if (listP.get(i) != null && listQ.get(i) != null) {
                if (listP.get(i).val != listQ.get(i).val) {
                    return false;
                }
            } else { // 如果存在一个为空一个不为空情况，直接返回FALSE
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node);
        dfs(node.left, list);
        dfs(node.right, list);
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

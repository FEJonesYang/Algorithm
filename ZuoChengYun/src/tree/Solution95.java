package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: JonesYong
 * @Data: 2021-07-23
 * @Description: 95. 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution95 {


    /**
     * 递归
     *
     * @param n 选择输出的数字
     * @return
     */
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        return generateTrees1(1, n);
    }

    private List<TreeNode> generateTrees1(int left, int right) {
        List<TreeNode> allTrees = new LinkedList<>();
        // 需要满足二叉搜索树，这个时候应该添加一个空节点
        if (left > right) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = left; i <= right; i++) {
            // 递归生成左右子数
            List<TreeNode> leftTrees = generateTrees1(left, i - 1);
            List<TreeNode> rightTrees = generateTrees1(i + 1, right);
            // 枚举左右子树的组合生成合法的二叉搜索树
            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    // 装入所有的根结点
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
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

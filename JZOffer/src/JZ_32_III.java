import java.util.*;

/**
 * @Author: JonesYang
 * @Data: 2021-07-05
 * @Description: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 返回最后的结果
        List<List<Integer>> res = new ArrayList<>();
        // base 判断
        if (root == null) return res;
        // 整个过程中，节点存放的队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 决定是否换行
        boolean isWrap = false;
        deque.add(root);
        // 开始进行队列操作
        while (!deque.isEmpty()) {
            // 需要打印的队列的长度，这个长度就是每一层的节点数目
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                temp.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            // 判断是否需要进行换行
            if (!isWrap) { // 不换行
                isWrap = true;
            } else { // 换行
                Collections.reverse(temp);
                isWrap = false;
            }
            res.add(temp);
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

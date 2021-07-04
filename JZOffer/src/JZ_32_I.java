import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: JonesYang
 * @Data: 2021-07-05
 * @Description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ_32_I {
    public int[] levelOrder(TreeNode root) {
        // deque实现树的节点的入队列和出队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 层序遍历的形式记录最后输出的数据
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.remove();
            res.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        // 最后定义一个数组，把res里面的额数组进行转化
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
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

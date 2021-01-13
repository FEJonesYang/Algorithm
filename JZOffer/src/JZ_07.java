import java.util.HashMap;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-01-12
 */
public class JZ_07 {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 1、中序遍历的结果存放在 HashMap 中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    // 递归函数
    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        //2、建立根节点
        TreeNode node = new TreeNode(preorder[right]);
        //3、根据根节点划分左右子树
        int temp = map.get(preorder[root]);
        //4、构建左右左右子数的节点
        node.left = recur(root + 1, left, temp - 1);
        node.right = recur(root + temp - left + 1, temp + 1, right);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

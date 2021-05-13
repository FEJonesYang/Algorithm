import java.util.Stack;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-13
 * <p>
 * 单调栈解法，栈中始终维护单调性
 */
public class Solution42 {
    public int trap(int[] height) {
        // 合法性校验
        if (height == null || height.length < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //维护一个单调递减的栈，只有当栈不为空并且栈顶的元素小于当前的元素才出栈，否则就直接入栈
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIndex = stack.pop();
                // 相等的元素出栈
                while (!stack.isEmpty() && height[stack.peek()] == height[curIndex]) {
                    stack.pop();
                }
                // 如果当前的栈不为空，就一定还能够盛水
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // 1、去一个最小的高度 2、减去起前一个出栈的元素的高度 3、和宽度相乘
                    res += (Math.min(height[stackTop], height[i]) - height[curIndex]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return res;
    }
}

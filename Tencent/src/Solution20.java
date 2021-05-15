import java.util.*;

/**
 * @Description:
 * @Author: JonesYang
 * @Data: 2021-05-15
 * <p>
 * 维护一个栈，每次与栈顶的元素进行比较
 */
public class Solution20 {
    public boolean isValid(String s) {
        // 合法性校验
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            // 如果是左括号，先入栈
            if (temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else {
                // 栈顶的元素不能为空
                if (!stack.isEmpty()) {
                    // 处理括号匹配的问题
                    if (temp == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (temp == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (temp == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    // 如果有括号来的时候发现栈顶为空，直接返回 false
                    return false;
                }
            }

        }
        // 最后的判断，如果栈不为空的话，返回false
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}

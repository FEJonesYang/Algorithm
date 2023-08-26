package v2.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈实现队列:使用两个栈，需要满足条件：1.push栈必须一次性倒空 2.直到pop栈为空的时候，才会去push栈倒数据
 */
public class StackQueue {

    private final Deque<Integer> pushStack = new ArrayDeque<>();

    private final Deque<Integer> popStack = new ArrayDeque<>();

    public void add(int value) {
        pushStack.push(value);
    }

    public int remove() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("没有数据了");
        }
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        // 开始倒数据，pushStack 的数据必须一次性倒完
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    public boolean isEmpty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

}

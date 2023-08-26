package v2.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 *  最小栈，返回栈中元素的最小值
 */
public class MinStack {

    private final Deque<Integer> dataStack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new LinkedList<>();

    public void push(int value) {
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            // 取最小值
            minStack.push(value > minStack.peek() ? minStack.peek() : value);
        }
        dataStack.push(value);
    }

    public int pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public int peek() {
        if (dataStack.isEmpty()) {
            return -1;
        }
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

}

import java.util.LinkedList;

/**
 * @Description: 用两个栈实现一个队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * @Author: JonesYang
 * @Data: 2021-01-14
 */
public class JZ_09 {

    LinkedList<Integer> pushStack;
    LinkedList<Integer> popStack;

    public JZ_09() {
        pushStack = new LinkedList<Integer>();
        popStack = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        //添加到尾部的话，直接添加
        pushStack.addLast(value);
    }

    public int deleteHead() {
        //检查出栈的容器里是否存在元素，如果存在则直接出栈
        if (!popStack.isEmpty()) {
            return popStack.removeLast();
        }
        //入栈容器里的元素是空的，并且出栈的元素不为空
        if (pushStack.isEmpty()) {
            return -1;
        }
        //入栈容器里的元素不为空，依次添加到出栈的容器中
        while (!pushStack.isEmpty()) {
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.removeLast();
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
}

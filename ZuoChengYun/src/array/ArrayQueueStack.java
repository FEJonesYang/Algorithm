package array;

/**
 * @Author: JonesYang
 * @Data: 2021-06-19
 * @Description:数组实现栈、队列 一、数组实现栈：数组实现栈十分简单，只需要使用一个数组（固定长度），
 * 维护一个 栈顶指针，每次元素入栈或者出栈都只需要更新栈顶指针就可以了。
 * <p>
 * 二、数组实现队列,需要维护以下变量：
 * 1、 arr[] 数组
 * 2、pushIndex 元素入队列的位置
 * 3、popIndex 元素出队列的位置
 * 4、size 当前数组的大小
 * 5、limit 数组最大的容量
 */
public class ArrayQueueStack {
    private int arr[];
    private int pushIndex;
    private int popIndex;
    private int size;
    private final int limit;

    public ArrayQueueStack(int limit) {
        this.arr = new int[limit];
        this.pushIndex = 0;
        this.popIndex = 0;
        this.size = 0;
        this.limit = limit;
    }

    private void push(int value) {
        if (size == limit) {
            throw new RuntimeException("栈满了，不能再加入元素了。");
        }
        size++;
        arr[pushIndex] = value;
        pushIndex = nextIndex(pushIndex);
    }

    private int pop() {
        if (size == 0) {
            throw new RuntimeException("栈空了，已经没有元素了。");
        }
        size--;
        int ans = arr[popIndex];
        popIndex = nextIndex(popIndex);
        return ans;
    }

    private int nextIndex(int position) {
        return position == limit - 1 ? 0 : ++position;
    }

}

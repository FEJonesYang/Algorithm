package v2.queue;

/**
 * 数组实现栈
 */
public class ArrayStack{

    private final int[] array;

    private int limit = 10;

    /**
     * 记录当前栈的位置
     */
    private int curIndex = 0;

    public ArrayStack() {
        array = new int[limit];
    }

    public ArrayStack(int limit) {
        array = new int[limit];
        this.limit = limit;
    }

    public void push(int value) {
        if (array.length == limit) {
            throw new RuntimeException("栈满了，不能在加数据了");
        }
        array[curIndex] = value;
        curIndex++;
    }

    public int pop() {
        if (array.length == 0) {
            throw new RuntimeException("栈空了，拿不到数据了");
        }
        int popValue = array[curIndex];
        curIndex--;
        return popValue;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

}

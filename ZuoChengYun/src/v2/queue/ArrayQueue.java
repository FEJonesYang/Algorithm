package v2.queue;

/**
 * 数组实现队列
 */
public class ArrayQueue {
    private final int[] array;

    private int limit = 10;

    private int size = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue() {
        array = new int[limit];
    }

    public ArrayQueue(int limit) {
        array = new int[limit];
        this.limit = limit;
    }

    public void add(int value) {
        if (size == limit) {
            throw new RuntimeException("队列满了，不能再加数据了");
        }
        array[head] = value;
        head = nextIndex(head);
        size++;
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("队列空了，不能再删除数据了");
        }
        int removeValue = array[tail];
        tail = nextIndex(tail);
        size--;
        return removeValue;
    }

    private int nextIndex(int curIndex) {
        return curIndex == limit - 1 ? 0 : curIndex + 1;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }


}

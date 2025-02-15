package base;

/**
 * 数组实现栈
 */
public class Solution4<T> {

    int size;

    int capacity;

    T[] array;

    public Solution4(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        T n = array[--size];
        array[size] = null;
        return n;
    }

    public void push(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = item;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    private void printStack() {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
        System.out.println("size is " + size + " capacity is " + capacity);
    }

    public static void main(String[] args) {
        Solution4<Integer> s = new Solution4<>(2);
        s.push(1);
        s.push(2);
        s.printStack();

        s.push(3);
        s.printStack();

        s.pop();
        s.printStack();

        System.out.println(s.peek());
        s.printStack();
    }
}

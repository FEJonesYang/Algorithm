package base;

/**
 * 数组实现队列
 */
public class Solution5<T> {

    int size;

    int capacity;

    T[] array;

    int start;
    int end;

    public Solution5(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        start = 0;
        end = 0;
    }

    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(start + i) % size];
        }
        array = newArray;

        // reset start pointer and end pointer
        start = 0;
        end = size;
        capacity = newCapacity;
    }

    public void addFirst(T element) {
        if (capacity == size) {
            resize(capacity * 2);
        }

        start = (start - 1 + size) % size;
        array[start] = element;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T node = array[start];
        start = (start + 1) % size;
        size--;

        return node;
    }

    public void addLast(T element) {
        if (capacity == size) {
            resize(capacity * 2);
        }

        array[end] = element;
        end = (end + 1) % size;
        size++;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        end = (end - 1 + size) % size;
        T node = array[end];
        size--;

        return node;
    }



    public static void main(String[] args) {

    }
}

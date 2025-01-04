package base;

/**
 * 数组实现动态数组
 */
public class Solution1<T> {
    int size;

    int capacity = 2;

    T[] arr;

    public Solution1(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    /**
     * 查
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (!isValidIndex(index)) {
            return null;
        }
        return arr[index];
    }

    /**
     * 改
     *
     * @param index
     * @param value
     */
    public void set(int index, T value) {
        if (!isValidIndex(index)) {
            return;
        }
        arr[index] = value;
    }

    public void addFirst(T element) {
        if (size >= capacity) {
            resize(capacity * 2);
        }

        // move the array
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = element;
        size++;
    }

    public void addLast(T element) {
        if (size >= capacity) {
            resize(capacity * 2);
        }

        arr[size] = element;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T first = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return first;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size--;
        return arr[size - 1];
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    private void resize(int cap) {
        T[] newArr = (T[]) new Object[cap];
        System.arraycopy(arr, 0, newArr, 0, size);

        arr = newArr;
        capacity = cap;
    }

    public static void main(String[] args) {
        Solution1<Integer> a = new Solution1<>(2);
        a.addLast(1);
        a.addLast(2);

        // 1. 验证扩容能力
        System.out.println("capacity: " + a.capacity);
        a.addLast(3);
        System.out.println("capacity: " + a.capacity);

        System.out.println("size: " + a.size);

        // 2. 验证 addFirst
        for (int i = 0; i < a.size; i++) {
            if (i == a.size - 1) {
                System.out.println(a.get(i));
            } else {
                System.out.print(a.get(i) + " -> ");
            }
        }
        a.addFirst(4);
        for (int i = 0; i < a.size; i++) {
            if (i == a.size - 1) {
                System.out.println(a.get(i));
            } else {
                System.out.print(a.get(i) + " -> ");
            }
        }

        // 3. 验证 removeFirst
        System.out.println("removeFirst -> " + a.removeFirst());
        for (int i = 0; i < a.size; i++) {
            if (i == a.size - 1) {
                System.out.println(a.get(i));
            } else {
                System.out.print(a.get(i) + " -> ");
            }
        }

        // 4. 验证 removeLast
        System.out.println("removeLast -> " + a.removeLast());
        for (int i = 0; i < a.size; i++) {
            if (i == a.size - 1) {
                System.out.println(a.get(i));
            } else {
                System.out.print(a.get(i) + " -> ");
            }
        }

    }
}

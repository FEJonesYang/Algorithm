package utils;

public class ListNode<T> {

    public T val;

    public ListNode<T> next;

    public ListNode<T> last;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}

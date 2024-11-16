package lab2;

public class DoublyLinkedListNode<E> {
    public E value;
    public DoublyLinkedListNode<E> next = null;
    public DoublyLinkedListNode<E> last = null;

    public DoublyLinkedListNode(E value) {
        this.value = value;
    }
}

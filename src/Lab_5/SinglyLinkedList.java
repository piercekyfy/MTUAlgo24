package Lab_5;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private SinglyLinkedListNode<E> startNode;

    public SinglyLinkedList() {}

    public SinglyLinkedList(E first) {
        startNode = new SinglyLinkedListNode<>(first);
    }

    private SinglyLinkedListNode<E> getLastNode() {
        SinglyLinkedListNode<E> current = startNode;
        while(current.next != null){
            current = current.next;
        }
        return current;
    }

    public E get(int index) {
        SinglyLinkedListNode<E> current = startNode;
        for(int i = 0; i < index; i++){
            if(current == null || current.next == null)
                throw new IndexOutOfBoundsException();
            current = current.next;
        }
        return current.value;
    }

    public void insert(int index, E element) {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        else if (index == 0) {
            unshift(element);
            return;
        }

        SinglyLinkedListNode<E> before = startNode;
        for (int i = 0; i < index - 1; i++) {
            if (before == null)
                throw new IndexOutOfBoundsException();
            before = before.next;
        }

        SinglyLinkedListNode<E> node = new SinglyLinkedListNode<>(element);
        node.next = before.next;
        before.next = node;
    }

    public void push(E element) {
        SinglyLinkedListNode<E> node = new SinglyLinkedListNode<>(element);
        if(isEmpty()) {
            startNode = node;
        } else {
            getLastNode().next = node;
        }
    }

    public void unshift(E element) {
        SinglyLinkedListNode<E> node = new SinglyLinkedListNode<>(element);
        if(isEmpty()) {
            startNode = node;
        } else {
            node.next = startNode;
            startNode = node;
        }
    }

    public E pop() {
        if(isEmpty())
            throw new NoSuchElementException();

        SinglyLinkedListNode<E> current = startNode;
        SinglyLinkedListNode<E> last = null;
        while(current.next != null){
            last = current;
            current = current.next;
        }

        if(last == null)
            startNode = null;
        else
            last.next = null;

        return current.value;
    }

    public E shift() {
        if(isEmpty())
            throw new NoSuchElementException();

        SinglyLinkedListNode<E> removed = null;
        if(startNode.next == null) {
            removed = startNode;
            startNode = null;
        }
        else {
            removed = startNode.next;
            startNode = startNode.next;
        }
        return removed.value;
    }

    public boolean isEmpty() {
        return startNode == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        SinglyLinkedListNode<E> current = startNode;
        while(current.next != null){
            sb.append(current.value).append(", ");
            current = current.next;
        }
        return sb.toString();
    }
}

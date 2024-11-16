package lab2;

import java.util.Collection;
import java.util.Iterator;

// These could both implement a common LinkedList<Node, Element> class, but for the sake of example code is duplicated.
public class DoublyLinkedList<T> implements Collection<T>, Iterable<T> {
	private DoublyLinkedListNode<T> head = null; 
	private DoublyLinkedListNode<T> tail = null;
	private int size = 0;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(T first) {
		DoublyLinkedListNode<T> firstNode = new DoublyLinkedListNode<T>(first);
		head = firstNode;
		tail = firstNode;
	}
	
	// Collection Implementation
	
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	public boolean contains(Object o) {
		DoublyLinkedListNode<T> cur = head;

		while (cur != null) {
			if(o.equals(cur.value)) {
				return true;
			}
			
			cur = cur.next;
		}
		
		return false;
	}

	public boolean add(T e) {
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(e);
        if(head == null) {
            head = node;
            tail = node;
        } else {
        	DoublyLinkedListNode<T> cur = head;
        	while(cur.next != null)
        		cur = cur.next;
            cur.next = node;
        }
        size++;
		return true;
	}

	public boolean remove(Object o) {
		if(head == null)
			return false;
	
		DoublyLinkedListNode<T> cur = head;
		while (cur != null) {
			if(o.equals(cur.value)) {
				if(cur.last == null)
					head = cur.next;
				else
					cur.last.next = cur.next;
				size--;
				return true;
			}
			cur = cur.next;
		} 
		
		return false;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public T set(int index, T element) {		
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		DoublyLinkedListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<T>(element);
				if(cur.last == null) {
					head = newElement;
					tail = newElement;
				} else
					cur.last.next = newElement;
				
				newElement.next = cur.next;
				return cur == null ? cur.value : null;
			}
			
			i++;
			cur = cur.next;
		}
		
		throw new IndexOutOfBoundsException();
	}

	public void add(int index, T element) {
		if(head == null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element);
			head = newNode;
			tail = newNode;
			return;
		}
		
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		DoublyLinkedListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				DoublyLinkedListNode<T> newElement = new DoublyLinkedListNode<T>(element);
				if(cur.last == null)
					head = newElement;
				else
					cur.last.next = newElement;
				
				newElement.next = cur;
				size++;
				return;
			}
			
			i++;
			cur = cur.next;
		}
	}

	public T remove(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		DoublyLinkedListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				if(cur.last == null)
					head = null;
				else {
					cur.last.next = cur.next;
				}
				size--;
				return cur.value;
			}
			
			i++;
			cur = cur.next;
		}
		return null;
	}

	public int indexOf(Object o) {
		DoublyLinkedListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			if(o.equals(cur.value)) {
				return i;
			}
			
			i++;
			cur = cur.next;
		}
		return -1;
	}
	
	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	// Iterable Implementation
    
    @Override
    public Iterator<T> iterator() {
    	return new Iterator<T>() {
    		private DoublyLinkedListNode<T> cur = head;
    		
    		@Override
    		public T next() {
    			T value = cur.value;
    			cur = cur.next;
    			return value;
    		}
    		
    		@Override
    		public boolean hasNext() {
    			return cur != null;
    		}
    	};
    }
    
    // Additional Implementation
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DoublyLinkedListNode<T> current = head;
        while(current.next != null){
            sb.append(current.value).append(", ");
            current = current.next;
        }
        return sb.toString();
    }
}

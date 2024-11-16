package lab2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// For the sake of simplicity, this class doesn't contain functionality for all methods of Collection<T>.
public class SinglyLinkedList<T> implements Collection<T>, Iterable<T> {
    private SinglyLinkedListNode<T> head;
    private int size = 0;
    
    public SinglyLinkedList() {}

    public SinglyLinkedList(T first) {
        head = new SinglyLinkedListNode<>(first);
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
		SinglyLinkedListNode<T> cur = head;

		while (cur != null) {
			if(o.equals(cur.value)) {
				return true;
			}
			
			cur = cur.next;
		}
		
		return false;
	}

	public boolean add(T e) {
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(e);
        if(head == null) {
            head = node;
        } else {
        	SinglyLinkedListNode<T> cur = head;
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
	
		SinglyLinkedListNode<T> cur = head;
		SinglyLinkedListNode<T> prev = null;
		while (cur != null) {
			if(o.equals(cur.value)) {
				if(prev == null)
					head = cur.next;
				else
					prev.next = cur.next;
				size--;
				return true;
			}
			prev = cur;
			cur = cur.next;
		} 
		
		return false;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public T set(int index, T element) {		
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		SinglyLinkedListNode<T> cur = head;
		SinglyLinkedListNode<T> prev = null;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				SinglyLinkedListNode<T> newElement = new SinglyLinkedListNode<T>(element);
				if(prev == null)
					head = newElement;
				else
					prev.next = newElement;
				
				newElement.next = cur.next;
				return cur == null ? cur.value : null;
			}
			
			i++;
			prev = cur;
			cur = cur.next;
		}
		
		throw new IndexOutOfBoundsException();
	}

	public void add(int index, T element) {
		if(head == null) {
			head = new SinglyLinkedListNode<T>(element);
			return;
		}
		
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		SinglyLinkedListNode<T> cur = head;
		SinglyLinkedListNode<T> prev = null;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				SinglyLinkedListNode<T> newElement = new SinglyLinkedListNode<T>(element);
				if(prev == null)
					head = newElement;
				else
					prev.next = newElement;
				
				newElement.next = cur;
			}
			
			i++;
			prev = cur;
			cur = cur.next;
		}
	}

	public T remove(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		SinglyLinkedListNode<T> cur = head;
		SinglyLinkedListNode<T> prev = null;
		int i = 0;
		while (cur != null) {
			if(i == index) {
				if(prev == null)
					head = null;
				else {
					prev.next = cur.next;
				}
				return cur.value;
			}
			
			i++;
			prev = cur;
			cur = cur.next;
		}
		return null;
	}

	public int indexOf(Object o) {
		SinglyLinkedListNode<T> cur = head;
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
    		private SinglyLinkedListNode<T> cur = head;
    		
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

        SinglyLinkedListNode<T> current = head;
        while(current.next != null){
            sb.append(current.value).append(", ");
            current = current.next;
        }
        return sb.toString();
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import lab2.*;

public class Lab2 {

    @Test
    public void singlylinkedlist_get_returns_value_at_index() {
        final Integer[] VALUES = new Integer[] {1,2,3,4,5};

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        for(int i : VALUES) {
            list.push(i);
        }
        for(int i = 0; i < VALUES.length; i++) {
            assertEquals(VALUES[i], list.get(i));
        }
    }

    @Test
    public void singlylinkedlist_insert() {
        final Integer[] VALUES = new Integer[]{1, 2, 3, 4, 5, 6, 8};
        final Integer NEW_INDEX = 5;
        final Integer NEW_VALUE = 7;

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        for (int i : VALUES) {
            list.push(i);
        }
        list.insert(NEW_INDEX, NEW_VALUE);
        assertEquals(list.get(NEW_INDEX), NEW_VALUE);
    }
}

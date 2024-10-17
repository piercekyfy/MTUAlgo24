import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import Lab_5.*;

public class Lab5 {

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
}

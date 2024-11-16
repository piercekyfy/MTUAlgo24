import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import lab2.*;

public class Lab2 {

    @Test
    public void singlylinkedlist_adds_values() {
        final Integer[] VALUES = new Integer[] {1,2,3,4,5};

        Collection<Integer> list = new SinglyLinkedList<Integer>();
        
        for(Integer value : VALUES) {
        	list.add(value);
        }
        
        int i = 0;
        for(Integer value : list) {
        	assertEquals(value,VALUES[i]);
        	i++;
        }
        
    }
}

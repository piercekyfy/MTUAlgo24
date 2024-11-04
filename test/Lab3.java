import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import lab3.*;

public class Lab3 {

	@ParameterizedTest()
    @CsvSource({"{(<>)},true","(()){()},true", "()({),false"})
    public void correct_isBalanced_return(String expression, boolean returnValue) {
        assertEquals(IsBalanced.usingStack(expression), returnValue);
    }
}

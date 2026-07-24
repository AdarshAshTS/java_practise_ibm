
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Junit.Calculator;

public class CalculatorTest {
    @Test
    void Test1(){
        assertEquals(32, Calculator.add(10, 22), "not 32");
    }

    @Test
    void Test2(){
        assertEquals(12, Calculator.add(1, 9), "Expected 12 but actual is 10");
    }
}
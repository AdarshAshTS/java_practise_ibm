package Junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifeCycleHooksTest {

    @BeforeAll
    static void setup() {
        System.out.println("BeforeAll -> Database Connection Created");
    }

    @BeforeEach
    void setupEach() {
        System.out.println("BeforeEach -> User Session Started");
    }

    @Test
    void testAddition() {
        System.out.println("Executing Test Case 1");
        assertEquals(10, 5 + 5);
    }

    @Test
    void testSubtraction() {
        System.out.println("Executing Test Case 2");
        assertEquals(4, 10 - 6);
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach -> User Session Closed");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("AfterAll -> Database Connection Closed");
    }
}
package Junit;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;

class TimedTest{
   @Test
   void testQuickExecutionPass() {
       PerformanceService service = new PerformanceService();
       assertTimeout(Duration.ofMillis(500), () -> {
           service.quickOperation(); // completes in 100ms
       });
   }
   //fails
   @Test
   void testSlowExecutionFail() {
       PerformanceService service = new PerformanceService();
       assertTimeout(Duration.ofMillis(500), () -> {
           service.slowOperation(); // takes 1000ms, exceeds timeout
       });
   }

   @Test
   void testUnrealisticTimeoutFail() {
       PerformanceService service = new PerformanceService();
       assertTimeout(Duration.ofMillis(50), () -> {
           service.quickOperation(); // takes ~100ms, exceeds 50ms
       });
   }
    
}

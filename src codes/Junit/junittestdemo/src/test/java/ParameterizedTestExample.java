import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Junit.StringMethods;

class ParameterizedTestExample {

   @ParameterizedTest
   @ValueSource(strings = {"malayalam", "jujuj"})
   void palindromePass(String candidate) {
       assertFalse(StringMethods.isPalindrome(candidate));
   }

   @ParameterizedTest
   @ValueSource(strings = {"adarsh", "momi"})
   void palindromeFail(String candidate) {
       assertTrue(StringMethods.isPalindrome(candidate), "Expected true but got false");
   }
}

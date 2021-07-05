import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


class firstTest {
  private static int a;
  private static int b;

  private static int add(int a, int b) {
    return a + b;
  }

  @BeforeAll
  static void initializeVariables() {
    a = 3;
    b = 2;
  }

  @Test
  @DisplayName("a + b should equal a + b")
  void addition() {
    int expected = a + b;
    assertEquals(expected, add(a, b));
  }

  @Test
  @DisplayName("a + b should not equal a")
  void additionShouldNotEqual() {
    int unexpected = a;
    assertNotEquals(unexpected, add(a,b));
  }
}

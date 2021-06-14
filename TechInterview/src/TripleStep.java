import java.util.HashMap;
/*
A child is running up a staircase with n steps and can hop either 1 step,
2 steps, or 3 steps at a time. How many ways to run up the steps?
*/

public class TripleStep {

  /*
  Starting at 0, bottom-up approach
                                 0
                    /           |               \
                  1             2                3
              /   |    \    /   |    \       /   |    \
            2     3     4   3   4     5     4     5     6
          / | \
         3  4  5
      / | \
      4 5  6

    if steps > top, no path
    if steps = top, 1 path found

    recursive cases, steps < top

    tabulation
        0 1 2 3 4 5
    1   1 1
    2   1 1
    3



  */
  private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

  public static int recursiveBottomUp(int top, int steps) {
    if (steps > top || top < 0) return 0;
    if (steps == top) return 1;

    return recursiveBottomUp(top, ++steps) + recursiveBottomUp(top, ++steps) + recursiveBottomUp(top, ++steps);
  }

  public static int memoization(int top, int steps) {
    return 0;
  }


  public static int tabulation(int top, int steps) {
    if (steps > top || top < 0) return 0;
    if (steps == top) return 1;
    if (!cache.containsKey(steps)) {
      int value = tabulation(top, ++steps);
      value += tabulation(top, ++steps);
      value += tabulation(top, ++steps);
      cache.put(steps, value);
    }
    System.out.println("Cache size: " + cache.size());
    return cache.get(steps);
  }

  public static void main(String[] args) {
    int topOfStairs = 3;

    int possibleWays = recursiveBottomUp(topOfStairs, 0);

    System.out.println(possibleWays);
  }
}

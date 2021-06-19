/*
Given a time represented in the format "HH:MM", form the next
closest time by reusing the current digits. There is no limit
on how many times a digit can be reused. You may assume the
given input string is always valid. For example, "01:34", "12:09"
are all valid. "1:34", "12:9" are all invalid.

https://protegejj.gitbook.io/algorithm-practice/google/681-next-closest-time

Example:
Input: "19:34"
Output: "19:39"
Explanation:The next closest time choosing from digits 1, 9, 3, 4,
is 19:39, which occurs 5 minutes later.  It is not 19:33, because
this occurs 23 hours and 59 minutes later.

Example:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9,
is 22:22. It may be assumed that the returned time is next day's time
since it is smaller than the input time numerically.

*/
// 12:34    12:44 OR 11:11
// 11:34    11:44 or 11:11
// 11:44    14:44 OR 11:11

/*
PSEUDOCODE

add numbers to sorted data structure (sortedSet, array..?)
closest number will occur by incrementing current digit to next closest greater value
if not possible for ones digit,
    repeat process from minutes digit
        if it works, replace minutes digits with lowest value in sorted data structure
if not possible for minutes digit, repeat process for hours digit (military time)
    if second hours digit = 2, check first hours digit
          else if 2nd-hours-digit = 0 or 1, check if 1 or 2 is in sorted data structure
          if 1 or 2 not available, go to first hours digit
    if first hours digit = 2, will have to advance to next day
          else if first-hours = 0 or 1, check if 1 or 2 is in sorted data structure
          if 1 or 2 not available respectively, advance to next day


when advancing to next day
    // find closet minimal hour,
    // set minutes and ones digit to minimum value in sorted set


TEST PSEUDOCODE
// input = "19:34"
TreeSet<Character> set        set.add(elem)  set.first()     set.higher(currentElement)
String output = "";
int index = 4;
char digit = input.charAt(index);
char higher =

because the input string is always valid, there will always be a 0, 1, AND/OR 2 in
the sorted set

when higher digit is not available, can look for a lower digit. Have to determine how
much additional time is added by the lower digit

Since any valid time will include 0,1,2, you can automatically find the advanced time
by making every other digit the lowest number in the set AND
  - replace the current digit with the closest lower value
  OR
  - replace the current digit with the LOWEST




*/
import java.util.TreeSet;

class NextClosestTime {

  public static String findTime(String time) {

    TreeSet<Character> sorted = new TreeSet<Character>();
    int index;
    char digit;
    Character closest;
    Character lowest;
    Character maxDigit;
    Character firstDigit = time.charAt(0);
    String output = "";
    boolean keepSearching = true;


    for (int i = time.length() - 1; i >= 0; i--) {
      if (time.charAt(i) != ':') {
        sorted.add(time.charAt(i));
      }
    }
    /*
    TIME    23:59

    INDEX   4 3 2 1 0
    DIGIT   9 5   3 2
    CLOSEST N 9   5 3

    */

    index = time.length();
    lowest = sorted.first();

    do {
      index--;
      if (index == 2) index--;
      digit = time.charAt(index);
      closest = sorted.higher(digit);
      maxDigit = maxAllowableDigit(index, digit, firstDigit);
      if (closest != null && closest <= maxDigit) {
        keepSearching = false;
      }
    } while (index > 0 && keepSearching);

    if (keepSearching) {
      // this means that closest number to current digit was greater
      // than the max allowable digit OR it was equal to null
      output += lowest;
      output += lowest;
      output += ":" + lowest + lowest;
    } else {
      output += time.substring(0, index);
      output += closest;
      if (index <= 2 ) {
        output += ":" + lowest + lowest;
      } else if (index == 3) {
        output += lowest;
      }
    }


    return output;
  }

  private static Character maxAllowableDigit(int index, Character digit, Character firstDigit) {
    Character maxDigit = '9';

    if (index == 3) {
      maxDigit = '5';
    } else if (index == 1 && firstDigit == '2') {
      maxDigit = '3';
    } else if (index == 0) {
      maxDigit = '2';
    }

    return maxDigit;
  }

  public static void main(String[] args) {

    // String time = "19:34";
    String time = "00:01";

    String answer = findTime(time);

    System.out.println(answer);
  }
}
import java.util.Arrays;

public class ReverseVowels {


    /**
     * Source: LeetCode
     *
     * Given a string s, reverse only all the vowels in the string and return it.
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
     *
     *  1 <= s.length <= 3 * 10^5
     *  s consists of printable ASCII characters
     */
    public static String reverse(String s){

        int i = 0;
        int j = s.length()-1;

        String[] str = s.split("");

        String swap;

        while ( i < str.length && i < j ){

           while ( !ReverseVowels.isVowel(str[i]) && i < j ){
               i++;
           }

           while ( !ReverseVowels.isVowel(str[j]) && j > i ){
               j--;
           }

           swap = str[i];
           str[i] = str[j];
           str[j] = swap;

           i++;
           j--;
        }
        String output = "";
        for (String string : str){
            output += string;
        }

        return output;
    }

    public static void testVowelReverse(String original){

        System.out.println("Original String: " + original);
        System.out.println("Reversed Vowel String: " + ReverseVowels.reverse(original));

    }

    private static boolean isVowel(String c){
        if ( c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u") )
            return true;

        return false;
    }
}

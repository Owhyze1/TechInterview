import java.util.Random;

public class ReverseString {


    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * Source: LeetCode
     * @param s char array of characters to be reversed without allocating space for another array
     */
    public static void reverse(char[] s){

        char swap;
        int len = s.length;
        int end;

        for (int i = 0; i < len/2; i++){

            end = len - 1 - i;
            
            swap = s[i];
            s[i] = s[end];
            s[end] = swap;
        }
    }

    
    /**
     * Generate char array to reverse
     * 
     * @param size size of desired char array     
     */
    public static char[] generateInput(int size){
        
        if ( size < 1 )
            System.out.println("Invalid input");

        char[] output = new char[size];
        int num;

        for (int i = 0; i < size; i ++){
            num = new Random().nextInt(26) + (int)'a';

            output[i] = (char) num;
        }

        return output;
    }


    public static void testingReverseOperation(){
        
        int size = 10;


        char[] letters = ReverseString.generateInput(size);

        System.out.println("Input Array: ");
        ReverseString.print(letters);

        System.out.println("\nOutput Array: ");
        ReverseString.reverse(letters);
        ReverseString.print(letters);
    }

    /**
     * Display contents of char array
     */
    public static void print(char[] letters){

        for (char c : letters){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        
        char[] letters = ReverseString.generateInput(10);

        System.out.println("Input Array: ");
        ReverseString.print(letters);

        System.out.println("\nOutput Array: ");
        ReverseString.reverse(letters);
        ReverseString.print(letters);
    }
}

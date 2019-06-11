package task1;
        import java.util.Scanner;
        import java.util.Arrays;

public class task1 {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter something: ");
        String input = in.nextLine();
        System.out.println("Reverse: " + new StringBuilder(input).reverse().toString()); //task 1.1

        String[] words = input.split(" ");
        System.out.println ("Split:");
        for (String word : words) {
            System.out.println(word); // task 1.2
        }
        System.out.println("Change: " + input.replace(' ', '*'));// task 1.3
        String strUpper = input.toUpperCase();
        System.out.println ("Upper case: " +strUpper);// task 1.4
        int start = 5;
        int end = 11;
        char[] str =new char[end - start];
        input.getChars(start, end, str, 0);
            System.out.println("Substring:" + String.valueOf(str));
            }
     }
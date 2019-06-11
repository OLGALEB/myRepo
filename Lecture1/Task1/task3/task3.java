package task3;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size :");
        String s = in.nextLine();
        int result = Integer.parseInt(s);
        System.out.println();

        int shiftedSize = result - 1;
        int columns = result * 2 - 1;
        for (int i = 0; i < result; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == shiftedSize-i || j == shiftedSize+i) {
                    System.out.print("*");
                } else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < shiftedSize; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == shiftedSize-(shiftedSize -1 - i) || j == shiftedSize+(shiftedSize -1 - i)) {
                    System.out.print("*");
                } else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
    }


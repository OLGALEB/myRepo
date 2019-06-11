package task2;
import java.io.*;

public class task2 {
    public static void main( String[] args ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        int b = Integer.parseInt(a);


        if (b == 1)
        {
            System.out.println("понедельник");
        }

        if (b == 2)
        {
            System.out.println("вторник");
        }

        if (b == 3)
        {
            System.out.println("среда");
        }

        if (b == 4)
        {
            System.out.println("четверг");
        }

        if (b == 5)
        {
            System.out.println("пятница");
        }

        if (b == 6)
        {
            System.out.println("суббота");
        }

        if (b == 7)
        {
            System.out.println("воскресенье");
        }

        if (b > 7)
        {
            System.out.println("не существует");
        }
        if (b < 1)
        {
            System.out.println("не существует");
        }

    }

}


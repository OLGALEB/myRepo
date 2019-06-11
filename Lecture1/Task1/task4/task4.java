package task4;
        import java.util.Arrays;


public class task4  {

    public static void main(String[] args) {
        int[] a = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        String[] b = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        boolean isSorted = false;
        int buf;
        String buf2;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    isSorted = false;
                    buf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buf;

                    buf2 = b[i];
                    b[i] = b[i+1];
                    b[i+1] = buf2;
                }
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
package lab4;

public class Factorial {
    public static int recursive(int n) {
        if(n == 0 || n == 1)
            return 1;

        int next = recursive(n - 1);
        return n * next;
    }
}

package recursion;

public class RecursioTest {
    public static void main(String[] args) {
        System.out.println(fun(10));

    }

    public static int fun(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fun(n - 1) + fun(n - 2);
        }
    }
}

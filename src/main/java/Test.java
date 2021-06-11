public class Test {

    public static void main(String[] args) {
        getFactorial(3);
        getFactorial3(0);
    }

    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * getFactorial(f - 1);
        }

    }

    public static int getFactorial3(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        System.out.println(result);
        return result;
    }
}


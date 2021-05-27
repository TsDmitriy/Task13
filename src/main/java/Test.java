public class Test {

    public static void main(String[] args) {
        getFactorial(3);
    }

    //считаем факториал числа
    ///для практики
    public static int getFactorial1(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorial1(f - 1);
        }
    }

    }


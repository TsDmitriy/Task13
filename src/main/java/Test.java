public class Test {

    public static void main(String[] args) {
        getFactorial13(3);
    }

    //считаем факториал числа
    ///для практики
    public static int getFactorial13(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * getFactorial13(f - 1);
        }
    }

    }


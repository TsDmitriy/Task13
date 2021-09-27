import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        getAmountToTheLimit(10.0, 5678.34, "2");
    }
    public static double getAmountToTheLimit(Double minAmount, Double maxAmount, String signCount) {
        //если minAmount = 0, то берем minAmount=0.1 ,чтобы если мы берем 1 знак после запятой не попался 0.01
        double min = (minAmount > 0.1) ? minAmount : 0.1;
        double amountToTheLimitMinAndMax = min + Math.random() * (maxAmount - min);
        Double amount = formatterSignCount(amountToTheLimitMinAndMax, signCount);
        return amount;
    }

    /**
     * Метод, в котором, полученное числовое значение, обрезается по количеству символов, переданных в метод
     *
     * @param amount - сумма
     * @param signCount - количество знаков после запятой
     * @return amount - сумма
     */
    public static double formatterSignCount(double amount, String signCount) {
        DecimalFormat formatter = new DecimalFormat(signCount);
        formatter.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(formatter.format(amount).replace(",", "."));
    }
}

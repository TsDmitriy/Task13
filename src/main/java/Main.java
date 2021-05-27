import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int lastValue = 0;

    public static void main(String[] args) {
        String test = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBB";
        char[] chars = test.toCharArray();
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        char a = 0;
        for (int b = 0; b <= chars.length - 1; b++) {
            a = test.charAt(lastValue);
            if (chars[b] == a) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(Character.toString(a) + count);
                } else {
                    sb.append(Character.toString(a));
                }
                lastValue += count;
                count = 0;
                b--;
            }
        }
        if (count > 1) {
            sb.append(Character.toString(a) + count);
        } else {
            sb.append(Character.toString(a));
        }
        System.out.println(sb.toString());

    }
}


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class testString {
    public static void main(String[] args) {
//        String a = "Hello";
//        a = "Hello1";
//        a = new String("Hi");
//        System.out.println(a);
        reverseString("ПРивет");
        reverseStringChar("мама мыла раму");
        splitString("к,r,t,а,2");
        palindrom("поп");
        replaceSimvol("1234567");
        deleteSimvol("AABAA");
        pathString("123");
    }

    public static  void reverseString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println( stringBuffer.reverse().toString());
    }
    public static  void reverseStringChar(String str) {
        char[] array = str.toCharArray();
        String result ="";
        for (int i = array.length - 1; i >= 0; i--) {
            result =result +array[i];

        }
        System.out.println(result);
    }

    public static  void splitString (String str) {
        ArrayList <String> arrayList = new ArrayList<>();
        String delimeter = ",";
        arrayList.addAll(Arrays.asList(str.split(delimeter)));
        Stream<String> stream=arrayList.stream();
        stream.forEach(x-> System.out.println(x));
//        for(String a :arrayList) {
//            System.out.println(a);
//        }
    }

    public static void palindrom(String str) {
     StringBuffer stringBuffer = new StringBuffer(str);
     String resultReverse =stringBuffer.reverse().toString();
        Assert.assertEquals("Строка не является полиндромом", str,resultReverse);
    }


    public static void replaceSimvol(String fs) {
        String sb = "AABAA";
        System.out.println(sb.charAt(1));// возвращает символ
        String s = "ABCDEF".replace("C", "**"); //замена символа

        String sb2 = sb.replace(sb, "##");
        System.out.println(s + " " + sb2); //AB**DEF and ##


        char[] charSequence = fs.toCharArray(); /// замена символа через массив
        charSequence[3] = 'f';
        System.out.println(charSequence);
    }
    public static void deleteSimvol(String fs) {
        System.out.println(fs.replace("A", ""));

    }
    public static void pathString(String fs) {
        System.out.println(fs.substring(0,2));

    }

}

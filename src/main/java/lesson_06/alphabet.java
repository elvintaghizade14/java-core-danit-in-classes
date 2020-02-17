package lesson_06;

import java.util.Arrays;

public class alphabet {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        for (char c = 'A'; c <= 'Z'; c++) sb.append(c);
//        System.out.print(sb.toString());
        char[] alphabet = new char[26];
        for (char c = 'A', counter=0; c <= 'Z'; c++) {
            alphabet[c-'A'] = c;
        }
        System.out.println(new String(alphabet));
    }
}

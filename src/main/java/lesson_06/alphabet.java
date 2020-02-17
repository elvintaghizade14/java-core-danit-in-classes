package lesson_06;

public class alphabet {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 65; i < 91; i++) {
            sb.append((char) i);
        }
        System.out.println(sb.toString());
    }
}

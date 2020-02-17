package lesson_06;

public class randomString {
    public static void main(String[] args) {
        StringBuilder randStr = new StringBuilder();
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            int randNum = ((int) (Math.random() * 26 + 65));
            randStr.append((char) randNum);
            if (randNum == 65 || randNum == 69 || randNum == 73 || randNum == 79 || randNum == 85)
                vowels.append((char) randNum);
            else consonants.append((char) randNum);
        }
        System.out.println(randStr.toString());
        System.out.println(vowels.toString());
        System.out.println(consonants.toString());
    }
}

package module_01.lesson_06;

public class randomString {
    public static void main(String[] args) {

        final String VOW_CAP = "AEIOU";
        final String VOW_LOW = "aeiou";

        StringBuilder randStr = new StringBuilder();
        StringBuilder vowels_cap = new StringBuilder();
        StringBuilder vowels_low = new StringBuilder();
        StringBuilder consonants_cap = new StringBuilder();
        StringBuilder consonants_low = new StringBuilder();

        for (int i = 0; i < 30; i++) {
            int randNumCap = ((int) (Math.random() * 26 + 65));
            int randNumLow = ((int) (Math.random() * 26 + 97));
            randStr.append((char) randNumCap);
            randStr.append((char) randNumLow);
            if (VOW_CAP.contains(String.valueOf((char) randNumCap)))
                vowels_cap.append((char) randNumCap);
            else if (VOW_LOW.contains(String.valueOf((char) randNumLow)))
                vowels_low.append((char) randNumLow);
            else if (randNumCap >= 65 && randNumCap <= 90)
                consonants_cap.append((char) randNumCap);
            else
                consonants_low.append((char) randNumLow);
        }
        System.out.println(randStr.toString());
        System.out.println(vowels_cap);
        System.out.println(vowels_low);
        System.out.println(consonants_cap);
        System.out.println(consonants_low);
    }
}

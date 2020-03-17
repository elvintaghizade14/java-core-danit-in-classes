package module_01.lesson_06;

public class StringFilter {
    public static void main(String[] args) {
        final String VOW = "AEOIU";
        int range = 'Z' - 'A' + 1;
        int start = 'A';
        StringBuilder rand_s = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            char letter = (char) (Math.random() * range + start +
                    (Math.random() * 2) * 32);
            rand_s.append(letter);
        }
        String random = rand_s.toString();
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
        for (int i = 0; i < random.length(); i++) {
            char c = random.charAt(i);
            if (VOW.contains(String.valueOf(c)))
                vowels.append(c);
            else
                consonants.append(c);
        }

        System.out.println(random);
        System.out.println(vowels.toString());
        System.out.println(consonants.toString());
    }
}

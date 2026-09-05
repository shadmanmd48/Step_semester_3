public class FirstNonRepeatingCharacter {

    public static Character findFirstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String input1 = "swiss";
        Character result1 = findFirstNonRepeatingChar(input1);
        if (result1 != null) {
            System.out.println("Input: \"" + input1 + "\" -> First Non-Repeating Character: " + result1);
        } else {
            System.out.println("Input: \"" + input1 + "\" -> No Non-Repeating Character Found");
        }

        String input2 = "aabbcc";
        Character result2 = findFirstNonRepeatingChar(input2);
        if (result2 != null) {
            System.out.println("Input: \"" + input2 + "\" -> First Non-Repeating Character: " + result2);
        } else {
            System.out.println("Input: \"" + input2 + "\" -> No Non-Repeating Character Found");
        }
    }
}

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedText = new String(reversed);
        return text.equals(reversedText);
    }

    private static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] testWords = {"madam", "hello", "racecar", "step"};

        for (String word : testWords) {
            boolean iter = isPalindromeIterative(word);
            boolean recur = isPalindromeRecursive(word);
            boolean rev = isPalindromeArrayReversal(word);

            System.out.println("Input: \"" + word + "\"");
            System.out.println("Iterative: " + formatResult(iter) +
                               " | Recursive: " + formatResult(recur) +
                               " | Array Reversal: " + formatResult(rev));
            System.out.println();
        }
    }
}

public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> a = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {

            Character b = word.charAt(i);
            a.addLast(b);

        }
        return a;
    }

    public boolean isPalindrome(String word) {
        Palindrome palindrome = new Palindrome();
        Deque d = palindrome.wordToDeque(word);

        for (int i = 0; i < d.size(); i++) {
            if (d.get(i) != d.get(d.size() - i - 1)) {
                return false;
            }
        }
        return true;

    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> d = palindrome.wordToDeque(word);

        for (int i = 0; i <= (d.size() / 2); i++) {
            if ((2 * i) == (d.size() - 1)) {
                continue;
            }
            char a = d.get(i);
            char b = d.get(d.size() - i - 1);
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }


}

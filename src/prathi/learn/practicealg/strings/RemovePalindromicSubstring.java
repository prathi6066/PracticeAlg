package prathi.learn.practicealg.strings;

public class RemovePalindromicSubstring {

    // if string is empty return 0
    // if string is palindrome return 1
    //else return 2 (you can delete a in one step and b in next step)

    public int removePalindromeSub(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i=0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return 2;
            }
        }
        return 1;
    }
}

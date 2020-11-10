package prathi.learn.practicealg.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = new String[] {"dog", "dob", ""};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        int prefixIndex = prefix.length();

        for (int i=1;i<strs.length;i++) {
            String currStr = strs[i];
            int currentPrefixIndex = prefixIndex;

            if (currStr.isEmpty())
                return "";

            for (int k=0;k<currStr.length();k++) {
                if (k < prefix.length() && prefix.charAt(k) == currStr.charAt(k)) {
                    currentPrefixIndex = k;
                } else {
                    if (k == 0)
                        return "";
                    break;
                }
            }

            if (currentPrefixIndex < prefixIndex)
                prefixIndex = currentPrefixIndex;
        }

        if (prefix.length() == prefixIndex)
            return "";

        return prefix.substring(0, prefixIndex+1);

    }
}

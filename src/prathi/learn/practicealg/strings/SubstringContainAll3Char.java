package prathi.learn.practicealg.strings;

public class SubstringContainAll3Char {

    public static  void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    private static int numberOfSubstrings(String s) {
        int count = 0;
        int start = 0;
        int end = 0;
        int[] arr = new int[3];
        while (end < s.length()) {
            arr[s.charAt(end++) - 'a']++;

            if (arr[0] == 0 || arr[1] ==0 || arr[2] ==0)
                continue;

            while(arr[0] != 0 && arr[1] !=0 && arr[2] != 0 && start < end) {
                count++;
                count += s.length() - end;
                arr[s.charAt(start++) - 'a'] --;
            }
        }

        return count;
    }
}

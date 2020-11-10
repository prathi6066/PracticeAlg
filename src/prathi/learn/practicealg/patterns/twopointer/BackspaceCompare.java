package prathi.learn.practicealg.patterns.twopointer;

class BackspaceCompare {

    /*
    Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
    Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Time: The time complexity of the above algorithm will be O(M+N)O(M+N) where ‘M’ and ‘N’ are the lengths of the two input strings respectively.
spave:O(1)
     */
    public static boolean compare(String str1, String str2) {
        // TODO: Write your code here
        int ptr1 = str1.length() -1;
        int ptr2 = str2.length() -1;

        while(ptr1 >=0 ||  ptr2 >=0) {
            int ind1 = getNextValidIndex(ptr1, str1);
            int ind2 = getNextValidIndex(ptr2, str2);

            if (ind1 <0 && ind2 < 0)
                return true;

            if(ind1 <0 || ind2 < 0)
                return false;

            if(str1.charAt(ind1) != str2.charAt(ind2))
                return false;

            ptr1 = ind1-1;
            ptr2 = ind2-1;
        }

        return true;
    }

    private static int getNextValidIndex(int index, String str) {
        int count = 0;
        while(index >=0) {
            if(str.charAt(index) == '#') {
                count++;
            } else if(count > 0) {
                count--;
            } else {
                break;
            }

            index--;
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}


package prathi.learn.practicealg.patterns.twopointer;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        // TODO: Write your code here
        int start = 1;

        for (int end=1; end < arr.length; end++) {
            if (arr[end-1] != arr[end]) {
                arr[start] = arr[end];
                start++;
            }

        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}

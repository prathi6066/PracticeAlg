package prathi.learn.practicealg.patterns.binarysearch;

public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        int n = arr.length;
        if (n == 0 || arr[n-1] < key)
            return -1;

        if (arr[0] >= key)
            return 0;

        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == key)
                return mid;
            else if (mid + 1 <= end && arr[mid + 1] > key && arr[mid] < key)
                return mid + 1;
            else if (arr[mid] > key) {
                end--;
            } else {
                start++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}

package prathi.learn.practicealg.patterns.twopointer;

public class SortedArraySquares {

    /*
    Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

    Input: [-2, -1, 0, 2, 3]
    Output: [0, 1, 4, 4, 9]

    Time: O(N)
     */
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        // TODO: Write your code here
        int start = 0;
        int end = arr.length-1;
        int index = arr.length-1;
        while(start <= end) {
            int leftSq = arr[start] * arr[start];
            int rightSq = arr[end] * arr[end];
            if (leftSq < rightSq) {
                squares[index--] = rightSq;
                end--;
            } else {
                squares[index--] = leftSq;
                start++;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

}

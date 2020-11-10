package prathi.learn.practicealg.arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] num2 = new int[] {2, 5, 6};
        merge(num1, 3, num2, 3);

        for(int n: num1) {
            System.out.println(n);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int len1 = m - 1;
        int len2 = n - 1;
        int i = len1 + len2 + 1;

        while (len1 >= 0 && len2 >=0) {
            if (nums2[len2] > nums1[len1]) {
                nums1[i--] = nums2[len2--];
            } else if (nums1[len1] >= nums2[len2]) {
                nums1[i--] = nums1[len1--];
            }
        }

        while (len1 < 0 && len2 >=0) {
            nums1[i--] = nums2[len2--];
        }
    }
}

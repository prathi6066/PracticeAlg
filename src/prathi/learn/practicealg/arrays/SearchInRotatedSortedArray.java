package prathi.learn.practicealg.arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] <= nums[start] && target >= nums[end])
                    end = mid -1;
                else
                    start = mid + 1;
            }
        }

        return -1;
    }
}

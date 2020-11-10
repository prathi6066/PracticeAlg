package prathi.learn.practicealg.dp;

public class RainTerraces {


    public static void main(String[] args) {
        int[] input= new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }

    //iterate through all the elements in array
    //find max_left height until current element
    //find max_right height from current element
    //min(max_left_height, max_right_height)- height[current_element]

    private static int trap(int[] height) {
        int result = 0;
        int[] max_left_height = new int[height.length];
        int[] max_right_height = new int[height.length];

        int max_val = Integer.MIN_VALUE;
        for (int i=0; i < height.length;i++ ) {
            if(height[i] > max_val)
                max_val = height[i];
            max_left_height[i] = max_val;
        }

        max_val = Integer.MIN_VALUE;
        for (int i=height.length -1; i >= 0;i-- ) {
            if(height[i] > max_val)
                max_val = height[i];
            max_right_height[i] = max_val;
        }
        for (int i = 0; i< height.length; i++) {

            result += (Math.min(max_left_height[i], max_right_height[i])-height[i]);
        }

        return result;

    }
}

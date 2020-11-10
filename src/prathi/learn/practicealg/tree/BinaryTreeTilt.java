package prathi.learn.practicealg.tree;

public class BinaryTreeTilt {
    static int tiltSum = 0;

    public int findTilt(TreeNode root) {
       if (root == null)
           return 0;

       makeSum(root);
       return tiltSum;

    }

    private static int makeSum(TreeNode root) {
       if (root == null)
           return 0;

       int leftSum = makeSum(root.left);
       int rightSum = makeSum(root.right);

       int tilt = Math.abs(leftSum - rightSum);
       tiltSum+= tilt;

       return root.val+ leftSum+rightSum;
    }
}

package prathi.learn.practicealg.tree;

public class DiameterOfTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(treeNode));

    }
    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rHeight = height(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(lheight+rHeight, Math.max(leftDiameter, rightDiameter));

    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}

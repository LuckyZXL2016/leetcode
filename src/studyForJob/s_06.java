package studyForJob;

/**
 * 二叉树的最大路径和
 * Created by ZXL on 2019/8/29.
 */
public class s_06 {
    private static int maxValue = Integer.MIN_VALUE;

    private static int getMaxValue(TreeNode root) {
        if (root == null) return 0;

        int leftValue = Math.max(getMaxValue(root.left), 0);
        int rightValue = Math.max(getMaxValue(root.right), 0);
        int priceValue = leftValue + rightValue + root.val;
        maxValue = Math.max(maxValue, priceValue);

        return priceValue;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        getMaxValue(t1);
        System.out.println(maxValue);
    }
}

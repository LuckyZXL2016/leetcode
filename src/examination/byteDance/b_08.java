package examination.byteDance;

/**
 * 二叉树的最大路径和
 * Created by ZXL on 2019/8/16.
 */
public class b_08 {
    private static int maxValue = Integer.MIN_VALUE;

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

    private static int getMaxValue(TreeNode node) {
        if (node == null) return 0;

        int left_gain = Math.max(getMaxValue(node.left), 0);
        int right_gain = Math.max(getMaxValue(node.right), 0);

        int price_newpath = node.val + left_gain + right_gain;
        maxValue = Math.max(maxValue, price_newpath);

        return price_newpath;
    }
}

package studyForJob;

import java.util.Stack;

/**
 * 树的
 * 非递归排序
 * Created by ZXL on 2019/8/29.
 */
public class s_16 {
    // 前序
    private static void pre_traverse(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // 中序
    private static void in_traverse(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tCur = root;
        while (tCur != null || !stack.isEmpty()) {
            while (tCur != null) {
                stack.push(tCur);
                tCur = tCur.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            tCur = node.right;
        }
    }

    // 后续
    private static void beh_traverse(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tCur = root;
        TreeNode tPre = root;

        while (tCur != null || !stack.isEmpty()) {
            while (tCur != null) {
                stack.push(tCur);
                tCur = tCur.left;
            }
            TreeNode t = stack.peek().right;
            if (t == null || t == tPre) {
                tCur = stack.pop();
                System.out.print(tCur.val + " ");
                tPre = tCur;
                tCur = null;
            } else {
                tCur = t;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        pre_traverse(t1);
        System.out.println();
        System.out.println("==========");
        in_traverse(t1);
        System.out.println();
        System.out.println("==========");
        beh_traverse(t1);
        System.out.println();
        System.out.println("==========");
    }
}

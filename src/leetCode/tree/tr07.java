package leetCode.tree;

import java.util.Stack;

/**
 * 非递归遍历二叉树
 * Created by ZXL on 2019/7/29.
 */
public class tr07 {

    // 先序
    private void pre_traverse(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                System.out.print(t.val + " ");
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }
            }
        }
    }

    // 中序
    private void in_traverse(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode tCur = root;

            while (tCur != null || !stack.isEmpty()) {
                while (tCur != null) {
                    stack.push(tCur);
                    tCur = tCur.left;
                }
                TreeNode t = stack.pop();
                System.out.print(t.val + " ");
                tCur = t.right;
            }
        }
    }

    // 后序
    private void beh_traverse(TreeNode root) {
        if (root != null) {
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
                    System.out.print(tCur.val);
                    System.out.print(" ");
                    tPre = tCur;
                    tCur = null;
                } else {
                    tCur = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        tr07 example = new tr07();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        example.pre_traverse(t1);
        System.out.println();
        example.in_traverse(t1);
        System.out.println();
        example.beh_traverse(t1);
    }
}

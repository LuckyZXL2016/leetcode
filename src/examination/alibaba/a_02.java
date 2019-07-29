package examination.alibaba;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ZXL on 2019/4/1.
 * 遍历二叉树（先中后序）
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class a_02 {


    // 递归实现
    // 先序遍历
    public void pre_traverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            pre_traverse(root.left);
            pre_traverse(root.right);
        }
    }

    // 中序遍历
    public void in_traverse(TreeNode root) {
        if (root != null) {
            in_traverse(root.left);
            System.out.print(root.val + " ");
            in_traverse(root.right);
        }
    }

    // 后序遍历
    public void beh_traverse(TreeNode root) {
        if (root != null) {
            beh_traverse(root.left);
            beh_traverse(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 非递归实现
    // 先序遍历
    public void pre_traverse2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode t;
            while (!stack.isEmpty()) {
                t = stack.pop();
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

    // 中序遍历
    public void in_traverse2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode tCur = root;
            TreeNode t;
            while (tCur != null || !stack.isEmpty()) {
                while (tCur != null) {
                    stack.push(tCur);
                    tCur = tCur.left;
                }
                t = stack.pop();
                System.out.print(t.val + " ");
                tCur = t.right;
            }
        }
    }

    // 后序遍历
    public void beh_traverse2(TreeNode root) {
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
                    System.out.print(tCur.val + " ");
                    tPre = tCur;
                    tCur = null;
                } else {
                    tCur = t;
                }
            }
        }
    }

    // 广度优先
    public void BFS(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                System.out.print(t.val + " ");
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        a_02 example = new a_02();
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
        System.out.println();
        example.pre_traverse2(t1);
        System.out.println();
        example.in_traverse2(t1);
        System.out.println();
        example.beh_traverse2(t1);
        System.out.println();
        example.BFS(t1);
    }
}

package studyForJob;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树打印
 * Created by ZXL on 2019/8/29.
 */
public class s_12 {
    // 直接打印
    private static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // 逐行打印
    private static void bfs2(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size();
            while (num > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                num--;
            }
            System.out.println();
        }
    }

    // 打印第 k层节点
    private static void bfs3(TreeNode root, int k) {
        if (root == null) return;
        k = k - 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size();

            if (k == 0) {
                while (num > 0) {
                    TreeNode node = queue.poll();
                    System.out.print(node.val + " ");
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    num--;
                }
            }

            while (num > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                num--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
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

        bfs(t1);
        System.out.println();
        System.out.println("==========");
        bfs2(t1);
        System.out.println("==========");
        bfs3(t1, 1);
    }
}

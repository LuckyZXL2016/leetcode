package examination.byteDance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树逐层打印
 * Created by ZXL on 2019/8/16.
 */
public class b_09 {
    public void BFS(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }
}

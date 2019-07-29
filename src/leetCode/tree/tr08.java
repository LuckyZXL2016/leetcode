package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 * Created by ZXL on 2019/7/29.
 */
public class tr08 {

    private void BFS(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                System.out.print(t.val);
                System.out.print(" ");
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
    }
}

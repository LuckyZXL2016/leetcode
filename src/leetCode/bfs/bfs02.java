package leetCode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * Created by ZXL on 2019/3/7.
 * <p>
 * 返回其层次遍历结果：
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 */
public class bfs02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)   return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                count --;
            }
            res.add(list);
        }
        return res;
    }
}

package leetCode.dfs;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * Created by ZXL on 2019/3/7.
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 */

public class dfs01 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /* 方法一
    double last = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }*/

    // 方法二
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer preVal = null;
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                int val = p.val;
                if (preVal == null) {
                    preVal = val;
                } else {
                    if (preVal >= val) {
                        return false;
                    }
                    preVal = val;
                }
                p = p.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

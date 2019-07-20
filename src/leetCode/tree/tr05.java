package leetCode.tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽
 * 可能大（一个节点也可以是它自己的祖先）。”
 * Created by ZXL on 2019/7/20.
 *
 * 示例 :
 *  输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *  输出: 3
 *  解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class tr05 {
    private TreeNode ans = null;

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        int left = recurseTree(root.left, p, q) ? 1 : 0;
        int right = recurseTree(root.right, p, q) ? 1 : 0;
        // 当前结点是p或者q
        int mid = (root == p || root == q) ? 1 : 0;

        if (left + right + mid >= 2) {
            ans = root;
        }
        return (left + right + mid > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
}

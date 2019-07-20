package leetCode.tree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度
 * 尽可能大（一个节点也可以是它自己的祖先）。”
 * Created by ZXL on 2019/7/19.
 *
 * 示例 1:
 *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *  输出: 6
 *  解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class tr04 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pValue = p.val;
        int qValue = q.val;

        if (pValue > parentVal && qValue > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pValue < parentVal && qValue < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}

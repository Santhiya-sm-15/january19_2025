class Solution {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode p,TreeNode q)
    {
        if(p==null && q==null)
            return true;
        if((p!=null && q==null) || (p==null && q!=null))
            return false;
        if(p.val!=q.val)
            return false;
        return symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }
}
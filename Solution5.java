class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
            returnS;
        List<TreeNode> l=new ArrayList<>();
        preorder(root,l);
        for(int i=1;i<l.size();i++)
        {
            TreeNode x=l.get(i-1);
            TreeNode y=l.get(i);
            x.left=null;
            x.right=y;
        }
        l.get(l.size()-1).right=null;
    }
    public void preorder(TreeNode root,List<TreeNode> l)
    {
        if(root!=null)
        {
            l.add(root);
            preorder(root.left,l);
            preorder(root.right,l);
        }
    }
}
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        inorder(root,l);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<l.size();i++)
            min=Math.min(min,l.get(i)-l.get(i-1));
        return min;
    }
    public void inorder(TreeNode root,List<Integer> l)
    {
        if(root!=null)
        {
            inorder(root.left,l);
            l.add(root.val);
            inorder(root.right,l);
        }
    }
}
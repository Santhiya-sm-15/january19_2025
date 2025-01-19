class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            TreeNode a=null;
            for(int i=0;i<level;i++)
            {
                TreeNode n=q.poll();
                a=n;
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            l.add(a.val);
        }
        return l;
    }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int x=1;
        while(!q.isEmpty())
        {
            int level=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                TreeNode n=q.poll();
                l.add(n.val);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            if(x%2==1)
                res.add(l);
            else
            {
                Collections.reverse(l);
                res.add(l);
            }
            x++;
        }
        return res;
    }
}
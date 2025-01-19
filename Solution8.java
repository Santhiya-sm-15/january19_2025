class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l=new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            long sum=0;
            for(int i=0;i<level;i++)
            {
                TreeNode n=q.poll();
                sum+=n.val;
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            l.add((double)sum/(double)level);
        }
        return l;
    }
}
class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            List<Node> l=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                Node n=q.poll();
                l.add(n);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            for(int i=1;i<l.size();i++)
            {
                Node x=l.get(i-1);
                Node y=l.get(i);
                x.next=y;
            }
            l.get(l.size()-1).next=null;
        }
        return root;
    }
}
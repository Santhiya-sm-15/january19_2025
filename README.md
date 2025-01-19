# january19_2025
The problems that I solved today

1.Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

Code:
class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int n=heightMap.length,m=heightMap[0].length,i,j,res=0;
        boolean[][] visited=new boolean[n][m];
        for(i=0;i<m;i++)
        {
            pq.add(new int[]{heightMap[0][i],0,i});
            pq.add(new int[]{heightMap[n-1][i],n-1,i});
            visited[0][i]=true;
            visited[n-1][i]=true;
        }
        for(i=0;i<n;i++)
        {
            pq.add(new int[]{heightMap[i][0],i,0});
            pq.add(new int[]{heightMap[i][m-1],i,m-1});
            visited[i][0]=true;
            visited[i][m-1]=true;
        }
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        while(!pq.isEmpty())
        {
            int[] x=pq.poll();
            int height=x[0],r=x[1],c=x[2];
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc])
                {
                    if(heightMap[nr][nc]<height)
                        res+=height-heightMap[nr][nc];
                    pq.add(new int[]{Math.max(height,heightMap[nr][nc]),nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
        return res;
    }
}

2.Given the root of a binary tree, return its maximum depth. A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Code:
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}

3.Given the roots of two binary trees p and q, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Code:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p!=null && q==null) || (p==null && q!=null))
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

4.Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Code:
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

5.Given the root of a binary tree, flatten the tree into a "linked list": The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null. The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Code:
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

6.Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.

Code:
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

7.Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Code:
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

8.Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

Code:
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

9.Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Code:
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

10.Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Code:
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

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
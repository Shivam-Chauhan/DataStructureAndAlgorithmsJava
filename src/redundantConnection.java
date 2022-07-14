public class redundantConnection {
    // Time Complexity :- ~ O(4)
    // Space Complexity :- O(N)
    public int findParent(int node,int[] parent){
        if(node==parent[node]) return node;
        return parent[node]=findParent(parent[node],parent);
    }
    public boolean unionFind(int u,int v, int[] parent, int[] rank){
        int parentOfU=findParent(u,parent);
        int parentOfV=findParent(v,parent);
        if(parentOfU==parentOfV) return true;
        if(rank[parentOfU]>rank[parentOfV]) parent[parentOfV]=parentOfU;
        else if(rank[parentOfU]<rank[parentOfV]) parent[parentOfU]=parentOfV;
        else{
            parent[parentOfV]=parentOfU;
            rank[parentOfU]++;
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent= new int[1001];
        int[] rank=new int[1001];
        for(int i=0;i<1001;i++) parent[i]=i;
        for(int[] i:edges){
            if(unionFind(i[0],i[1],parent,rank)) return new int[]{i[0],i[1]};
        }
        return new int[2];
    }
}

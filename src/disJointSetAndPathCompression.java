public class disJointSetAndPathCompression {
    // Time Complexity :- ~ O(4)
    // Space Complexity :- O(N)
    public int findParentOfNode(int node, int[] parent) {
        if (parent[node] == node) return node;
        return parent[node] = findParentOfNode(parent[node], parent);
    }

    public void unionOfNode(int u, int v, int[] parent, int[] rank) {
        int parentOfU = findParentOfNode(u, parent);
        int parentOfV = findParentOfNode(v,parent);
        if (rank[parentOfU] > rank[parentOfV]) parent[parentOfV] = parentOfU;
        else if (rank[parentOfU] < rank[parentOfV]) parent[parentOfU] = parentOfV;
        else {
            parent[parentOfV] = parentOfU;
            rank[parentOfU]++;
        }
    }

    public static void main(String[] args) {
        disJointSetAndPathCompression obj=new disJointSetAndPathCompression();
        int[] parent = new int[10000];
        int[] rank = new int[10000];
        int n = 7;
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int[][] union = {
                        {1, 2},
                        {2, 3},
                        {4, 5},
                        {6, 7},
                        {5, 6},
                        {3, 7}};
        for(int[] i: union){
            obj.unionOfNode(i[0],i[1],parent, rank);
        }
    }
}

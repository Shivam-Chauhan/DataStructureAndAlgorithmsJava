import java.util.ArrayList;

public class cycleDetectionUnDirectedGraph {
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int[] visited, int node, int parent){
        visited[node]=1;
        for(int ele: adj.get(node)){
            if(visited[ele]==0){
                if(detectCycle(adj, visited,ele, node)==true) return true;
            }
            else if(parent!=ele) return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detectCycle(adj,visited,i,-1)==true) return true;
            }
        }
        return false;
    }
}

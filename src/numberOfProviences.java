import java.util.ArrayList;
import java.util.List;

public class numberOfProviences {
    public void dfsTraversal(List<List<Integer>> graph, int node, int[] visited){
        visited[node]=1;
        for(int iterator: graph.get(node)){
            if(visited[iterator] == 0){
                dfsTraversal(graph,iterator,visited);
            }
        }
    }
    // Time Complexity :- O(N+E)
    // Space Complexity :- O(N+E) + O(N)
    public static void main(String[] args) {
        numberOfProviences obj= new numberOfProviences();
        int[][] isConnected={
                {1,1,0},
                {1,1,0},
                {0,0,1}};
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++) graph.add(new ArrayList<>());

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1) graph.get(i).add(j);
            }
        }
        int[] visited=new int[isConnected.length];
        int counter=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                obj.dfsTraversal(graph,i,visited);
                counter++;
            }
        }
        System.out.println(counter);
    }
}

import java.util.ArrayList;

class cheapestFlightWithInKStopsNode {
    int nodeVal, amount;

    public cheapestFlightWithInKStopsNode(int nodeVal, int amount) {
        this.nodeVal = nodeVal;
        this.amount = amount;
    }
}

public class cheapestFlightWithInKStops {
    // Time Complexity :- O(N+E)
    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
    // Gave TLE On LeetCode
    public void dfsCheapestFlightFinder(int source, int destination ,
                                   ArrayList<ArrayList<cheapestFlightWithInKStopsNode>> graph,
                                   int totalCost, int[] minFare, int[] visited, int k){
        if(k<-1) return;
        if(source==destination){
            minFare[0]=Math.min(minFare[0],totalCost);
            return;
        }
        visited[source]=1;
        for(cheapestFlightWithInKStopsNode element: graph.get(source)){
            if(visited[element.nodeVal]==0 && (totalCost+element.amount<=minFare[0])){
                dfsCheapestFlightFinder(element.nodeVal, destination, graph,
                        totalCost+element.amount, minFare, visited, k-1);

            }
        }
        visited[source]=0;
    }
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}};
        int n=4,src = 0, dst = 3, k = 1;
        ArrayList<ArrayList<cheapestFlightWithInKStopsNode>> graph = new ArrayList<>();
        for (int i = 0; i <= dst; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] element:flights){
            graph.get(element[0]).add(new cheapestFlightWithInKStopsNode(element[1],element[2]));
        }
        int[] visited=new int[n];
        int[] minFare=new int[]{Integer.MAX_VALUE};
        cheapestFlightWithInKStops obj=new cheapestFlightWithInKStops();
        obj.dfsCheapestFlightFinder(src,dst,graph,0,minFare,visited,k);
        System.out.println(minFare[0]==Integer.MAX_VALUE?-1:minFare[0]);
    }
}




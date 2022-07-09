import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class courseScheduleTwo {
    public boolean detectCycle(List<List<Integer>> graph, boolean[] isVisited, boolean[] isDfsVisited, int node){
        isVisited[node]=true;
        isDfsVisited[node]=true;
        for(int iterator: graph.get(node)){
            if(isVisited[iterator]==false){
                if(detectCycle(graph,isVisited,isDfsVisited,iterator)==true) return true;
            }
            else if(isDfsVisited[iterator]==true) return true;
        }
        isDfsVisited[node]=false;
        return false;
    }
    public void findOrderOfTopo(int node, boolean[] isVisited, List<List<Integer>>graph, Stack<Integer> stack){
        isVisited[node]=true;
        for(Integer iterator:graph.get(node)){
            if(isVisited[iterator]==false){
                findOrderOfTopo(iterator,isVisited,graph,stack);
            }
        }
        stack.add(node);
    }

    // Time Complexity :- O(N+V)
    // Space Complexity :- O(2*N)
    public static void main(String[] args) {
        courseScheduleTwo obj=new courseScheduleTwo();
        int numsCourse=4;
        int[][] prerequistes={{1,0},{2,0},{3,1}};
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numsCourse;i++) graph.add(new ArrayList<>());
        for(int[] data: prerequistes){
            graph.get(data[1]).add(data[0]);
        }
        boolean[] isVisited=new boolean[numsCourse];
        boolean[] dfsVisited=new boolean[numsCourse];
        for(int i=0;i<numsCourse;i++){
            if(isVisited[i]==false){
                if(obj.detectCycle(graph,isVisited,dfsVisited,i)==true){
                    System.out.println(true);
                }
            }
        }
        isVisited=new boolean[numsCourse];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<numsCourse;i++){
            if(isVisited[i]==false){
                obj.findOrderOfTopo(i,isVisited,graph,stack);
            }
        }
        while (stack.size()>0){
            System.out.print(stack.pop());
        }
    }
}

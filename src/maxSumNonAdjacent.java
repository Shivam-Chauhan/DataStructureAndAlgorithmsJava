public class maxSumNonAdjacent {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public int maxSumNonAdjacent(int[] array, int index, int[] storage){
        if(index==0) return array[index];
        if(index<0) return 0;
        if(storage[index]!=-1) return storage[index];
        int pickElement=maxSumNonAdjacent(array, index-2, storage)+ array[index];
        int notPickElement=maxSumNonAdjacent(array, index-1, storage);
        return storage[index]=Math.max(pickElement,notPickElement);
    }
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int maxSumNonAdjacentOptimal(int[] array){
        int previous1=array[0], previous2=0;
        for(int i=1;i<array.length;i++){
            int pickElement=array[i];
            if(i-2>=0) pickElement+=previous2;
            int nonPickElement=previous1;
            int current=Math.max(pickElement,nonPickElement);
            previous2=previous1;
            previous1=current;
        }
        return previous1;
    }
    public static void main(String[] args) {
        int[] array={1,2,3,1,3,5,8,1,9};
        int[] storage=new int[array.length];
        for(int i=0;i<storage.length;i++) storage[i]=-1;
        maxSumNonAdjacent obj=new maxSumNonAdjacent();
        System.out.println(obj.maxSumNonAdjacent(array, array.length-1, storage));
        System.out.println(obj.maxSumNonAdjacentOptimal(array));
    }
}

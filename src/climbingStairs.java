public class climbingStairs {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int climbingStairsFinder(int n, int[] storage){
        if(n==0) return 1;
        if(n<0) return 0;
        if(storage[n]!=0) return storage[n];
        return storage[n]=climbingStairsFinder(n-1,storage)+ climbingStairsFinder(n-2,storage);
    }
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int climbingStairsOptimalFinder(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int previousElement=1, previousElement1=2;
        for(int i=2;i<n;i++){
            int temp=previousElement+previousElement1;
            previousElement=previousElement1;
            previousElement1=temp;
        }
        return previousElement1;
    }

    public static void main(String[] args) {
        int n=3;
        climbingStairs obj = new climbingStairs();
        int[] array=new int[n+1];
        obj.climbingStairsFinder(n,array);
        System.out.println(obj.climbingStairsOptimalFinder(n));
    }
}

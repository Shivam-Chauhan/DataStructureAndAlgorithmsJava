import java.util.Arrays;

public class maxAreaOfCake {
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(1)

    public int findMaxDimension(int[] array, int dimension){
        Arrays.sort(array);
        int maxGap=Math.max(dimension-array[array.length-1],array[0]);
        for(int i=0;i<array.length-1;i++){
            maxGap=Math.max(array[i+1]-array[i],maxGap);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        maxAreaOfCake obj=new maxAreaOfCake();
        int h=5,w=4;
        int modVal=1000000007;
        int[] horizontalCuts={3,1};
        int[] verticalCuts={1};
        int maxHorizontalCut=obj.findMaxDimension(horizontalCuts,h);
        int maxVerticalCut=obj.findMaxDimension(verticalCuts,w);
        System.out.println((int)((long)maxHorizontalCut * maxVerticalCut % (modVal)));
    }
}

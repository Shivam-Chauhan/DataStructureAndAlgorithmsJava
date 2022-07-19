import java.util.Arrays;
public class largestNumberFormedArray {
    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(1)
    String printLargest(String[] arr) {
        Arrays.sort(arr,(a, b)->(a+b).compareTo(b+a));
        StringBuilder output=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            output.append(arr[i]);
        }
        return String.valueOf(output);
    }
}

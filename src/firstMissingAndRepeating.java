public class firstMissingAndRepeating {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    int[] findTwoElementSwapSortMethod(int arr[], int n) {
        int index=0;
        while(index<n){
            if(arr[index]!=arr[arr[index]-1]){
                int temp=arr[index];
                arr[index]=arr[arr[index]-1];
                arr[arr[index]-1]=temp;
            }
            else {
                index++;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1) return new int[]{arr[i],i+1};
        }
        return new int[]{-1,-1};
    }
}

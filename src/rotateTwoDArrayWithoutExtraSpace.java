public class rotateTwoDArrayWithoutExtraSpace {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(1)
    void transpose(int[][] arr, int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    void colReverse(int[][] arr, int n){
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[n-i-1][j];
                arr[n-i-1][j]=temp;
            }
        }
    }
    void rotateMatrix(int arr[][], int n) {
        // code here
        transpose(arr,n);
        colReverse(arr,n);

    }
}

public class matrixMedian {
    // Time Complexity :- O(Log(2^32)*N*Log(M))
    // Space Complexity :- O(1)
    public int upperBoundBS(int[] row, int target){
        int low=0,high=row.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(row[mid]<=target) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int medianFinder(int[][] matrix){
        int low=1,high=1000000000;
        while(low<=high){
            int mid=low+(high-low)/2;
            int counter=0;
            for(int i=0;i<matrix.length;i++){
                counter+=upperBoundBS(matrix[i],mid);
            }
            if(counter<=(matrix.length*matrix[0].length)/2) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] matrix={
                {1,3,5},
                {2,6,9},
                {3,6,9}};
        matrixMedian obj=new matrixMedian();
        System.out.println(obj.medianFinder(matrix));

    }
}

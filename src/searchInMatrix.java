public class searchInMatrix {
    // Time Complexity :- ~ O(Log(N+M))
    // Space Complexity :- O(1)

    public boolean searchInMatrixUtil(int[][] matrix,int element){
        int rowIndex=0,colIndex=matrix[0].length-1;
        while(rowIndex<matrix.length && colIndex>=0){
            if (matrix[rowIndex][colIndex]==element) return true;
            else if(matrix[rowIndex][colIndex]<element) rowIndex++;
            else colIndex--;
        }
        return false;
    }
}

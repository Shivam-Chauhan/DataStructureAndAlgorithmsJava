public class maximalSqaureDP {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    public int maximalSqaureFinder(char[][] matrix){
        int[][] grid=new int[matrix.length][matrix[0].length];
        int maxiMumValue=Integer.MIN_VALUE;
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(i== matrix.length-1 || j== matrix[0].length-1){
                    grid[i][j]=matrix[i][j]-48;
                }
                else{
                    if(matrix[i][j]=='1') grid[i][j]=Math.min(grid[i+1][j],Math.min(grid[i+1][j+1],grid[i][j+1]))+1;
                }

                maxiMumValue=Math.max(maxiMumValue,grid[i][j]);
            }
        }
        return (int)Math.pow(maxiMumValue,2);
    }
    public static void main(String[] args) {
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        maximalSqaureDP obj=new maximalSqaureDP();
        System.out.println(obj.maximalSqaureFinder(matrix));

    }
}

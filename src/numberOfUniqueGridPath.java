public class numberOfUniqueGridPath {
    // Time Complexity :- O(2^N)
    // Space Complexity :- Auxillary Space of Recursion Stack
    public int numberOfUniqueGridPathRecursive(int totalRows,int totalCols,int currRow,int currCol){
        if((currRow==totalRows-1) && (currCol==totalCols-1)) return 1;
        if(currRow>=totalRows || currCol>=totalCols) return 0;
        return numberOfUniqueGridPathRecursive(totalRows,totalCols,currRow+1,currCol)+
                numberOfUniqueGridPathRecursive(totalRows,totalCols,currRow,currCol+1);

    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- Axuillary Space of Recursion Stack + O(N*M)
    public int numberOfUniqueGridPathDP(int totalRows,int totalCols,int currRow,int currCol,int[][] storage){
        if((currRow==totalRows-1) && (currCol==totalCols-1)) return 1;
        if(currRow>=totalRows || currCol>=totalCols) return 0;
        if(storage[currRow][currCol]!=-1) return storage[currRow][currCol];
        storage[currRow][currCol]=numberOfUniqueGridPathDP(totalRows,totalCols,currRow+1,currCol,storage)+
                numberOfUniqueGridPathDP(totalRows,totalCols,currRow,currCol+1,storage);
        return storage[currRow][currCol];

    }
    public int numberOfUniqueGridPathBest(int totalRows,int totalCols){
        int maximumVal=Math.max(totalCols,totalRows);
        int minimumVal=Math.min(totalCols,totalRows);
        double answer=1,numerator=maximumVal+minimumVal-2;
        for(int i=1;i<=minimumVal-1;i++) answer=(answer*numerator--)/(i);
        return (int)answer;
    }
    public static void main(String[] args) {
        int totalRows=3,totalCols=3;
        int[][] storage=new int[totalRows][totalCols];
        for(int i=0;i<totalRows;i++)
            for(int j=0;j<totalCols;j++) storage[i][j]=-1;

        numberOfUniqueGridPath obj=new numberOfUniqueGridPath();
//        System.out.println(obj.numberOfUniqueGridPathRecursive(totalRows,totalCols,0,0));
//        System.out.println(obj.numberOfUniqueGridPathDP(totalRows,totalCols,0,0,storage));
        System.out.println(obj.numberOfUniqueGridPathBest(totalRows,totalCols));
    }
}

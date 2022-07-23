public class validPerfectSquare {
    // Time Complexity :- O(Sqrt(N))
    // Space Complexity :- O(1)
    public boolean isPerfectSquare(int num) {
        long temp=1;
        long i=1;
        while(i<=num){
            if(i==(long)num) return true;
            temp++;
            i=temp*temp;
        }
        return false;
    }
}

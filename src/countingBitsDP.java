public class countingBitsDP {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int countingBitsFinder(int n, int[] result){
        if(n==0) return 0;
        if(n==1) return 1;
        if(result[n]!=0) return result[n];
        if(n%2==0) return result[n]=countingBitsFinder(n/2,result);
        else return result[n]=1+ countingBitsFinder(n/2, result);
    }
    public static void main(String[] args) {
        countingBitsDP obj=new countingBitsDP();
        int n=7;
        int[] result=new int[n+1];
        for(int i=0;i<=n;i++){
            result[i]=obj.countingBitsFinder(i,result);
        }
        for(int i: result) System.out.println(i);
    }
}

public class reverseBits {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int reverseBits(int n)
    {
        int reverse=0;
        while(n>0){
            reverse<<=1;
            if((int)(n&1)==1){
                reverse^=1;
            }
            n>>=1;
        }
        return reverse;
    }
}

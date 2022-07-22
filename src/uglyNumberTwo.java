public class uglyNumberTwo {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int nthUglyNumber(int n) {
        int[] array=new int[n];
        array[0]=1;
        if(n<0) return -1;
        if(n==0) return 1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<n;i++){
            array[i]=Math.min(array[t2]*2,Math.min(array[t3]*3, array[t5]*5));
            if(array[i]==array[t2]*2) t2++;
            if(array[i]==array[t3]*3) t3++;
            if(array[i]==array[t5]*5) t5++;
        }
        return array[n-1];
    }
}

public class nthRootOfNumber {
    // Time Complexity :- ~ O(N*Log(M*10)) Where M is the Range
    // Space Complexity :- O(1)
    public int mySqrt(int x) {
        double low=1,high=x,eps=1E-6;
        while((high-low)>eps){
            double mid=(high+low)/2.0;
            if(mid*mid<x){
                low=mid;
            }
            else{
                high=mid;
            }
        }
        return (int)high;
    }
}

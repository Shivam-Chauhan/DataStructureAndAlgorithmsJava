public class largestNumberPossible {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    static String findLargest(int N, int S){
        StringBuilder str=new StringBuilder();
        if(S==0){
            if(N==1) return "0";
            return "-1";
        }
        if(N==0 || S>9*N){
            return "-1";
        }

        for(int i=0;i<N;i++){
            if(S>=9){
                str.append("9");
                S-=9;
            }
            else{
                str.append(String.valueOf(S));
                S=0;
            }
        }
        return str.toString();
    }
}

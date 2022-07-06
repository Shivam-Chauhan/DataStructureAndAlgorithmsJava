public class maxPointsObtainedInCards {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int maxPointsObtainedInCardsFinder(int[] cardPoints, int k){
        int summation=0;
        int j=cardPoints.length-k,i=0;
        for(int w=cardPoints.length-k;w<cardPoints.length;w++){
            summation+=cardPoints[w];
        }
        int best=summation;
        while(j<cardPoints.length){
            summation+=cardPoints[i++]-cardPoints[j++];
            best=Math.max(best,summation);
        }
        return best;
    }
    public static void main(String[] args) {
        int[] cardPoints={9,7,7,9,7,7,9};
        int k=7;
        maxPointsObtainedInCards obj=new maxPointsObtainedInCards();
        System.out.println(obj.maxPointsObtainedInCardsFinder(cardPoints,k));

    }
}

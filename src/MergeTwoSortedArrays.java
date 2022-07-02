import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void printingOfArray(int[] nums1){
        for(int i:nums1){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void mergeTwoSortedArrayBruteSolution(int[] nums1, int m, int[] nums2, int n){
        int index=0;
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[index++];
        }
        Arrays.sort(nums1);
        printingOfArray(nums1);
    }
    public void mergeTwoSortedArrayOptimalSolution(int[] nums1, int m, int[] nums2, int n){
        int pointerToNums1=m+n-1;
        int indexM=m-1,indexN=n-1;
        while(indexM>=0 && indexN>=0){
            if(nums1[indexM]>=nums2[indexN]){
                nums1[pointerToNums1--]=nums1[indexM--];
            }
            else{
                nums1[pointerToNums1--]=nums2[indexN--];
            }
        }
        while(indexM>=0){
            nums1[pointerToNums1--]=nums1[indexM--];
        }
        while(indexN>=0){
            nums1[pointerToNums1--]=nums2[indexN--];
        }
        printingOfArray(nums1);

    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int m=3;
        int[] nums2={2,5,6};
        int n= 3;
        MergeTwoSortedArrays obj= new MergeTwoSortedArrays();
        // TimeComplexity :- O(N*Log(N))
        // Space Complexity :- O(1)
        obj.mergeTwoSortedArrayBruteSolution(nums1,m,nums2,n);

        // TimeComplexity :- O(N)
        // Space Complexity :- O(1)
        obj.mergeTwoSortedArrayOptimalSolution(nums1,m,nums2,n);
    }
}

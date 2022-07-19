public class missingElementAP {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int missingElementAPFinder(int[] arr){
        int n=arr.length;
        int low=0,high=arr.length-1,diff=(arr[n-1]-arr[0])/n;
        while(low<high){
            int mid=low+(high-low)/2;
            System.out.println(low+ " "+mid+ " " +high);
            if(arr[mid+1]-arr[mid]!=diff) return arr[mid]+diff;
            else if(mid>0 && arr[mid]-arr[mid-1]!=diff) return arr[mid-1]+diff;
            else if(arr[mid]==arr[0]+mid*diff) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={2,4,8,10,12,14};
        missingElementAP obj=new missingElementAP();
        System.out.println(obj.missingElementAPFinder(arr));
    }
}

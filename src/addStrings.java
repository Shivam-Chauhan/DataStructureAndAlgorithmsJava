public class addStrings {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        String nums1="11", nums2="123";
        int carry=0;
        for(int i=nums1.length()-1,j=nums2.length()-1;i>=0 || j>=0;i--,j--){
            int x=i<0?0:nums1.charAt(i)-'0';
            int y=j<0?0:nums2.charAt(j)-'0';
            sb.append((x+y+carry)%10);
            carry=(carry+y+x)/10;
        }
        if(carry!=0){
            sb.append(carry);
        }
        System.out.println(sb.reverse().toString());

    }
}

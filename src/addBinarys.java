public class addBinarys {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public String addBinary(String a, String b) {
        StringBuilder stb=new StringBuilder();
        int i=a.length()-1,j=b.length()-1, carry=0;
        while(i>=0 || j>=0){
            int summation=carry;
            if(i>=0) summation+=a.charAt(i--)-'0';
            if(j>=0) summation+=b.charAt(j--)-'0';
            stb.append(summation%2);
            carry=summation/2;
        }
        if(carry%2!=0) stb.append(1);
        return stb.reverse().toString();
    }
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Gives RunTime Error when length exceeds Integer Limit
    public String addBinaryFunction2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }
}

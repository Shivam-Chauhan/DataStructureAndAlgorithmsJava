public class longestPalindromicSubString {
    public String expander(String string, int low, int high){
        if(string==null || low>high) return "";
        while(low>=0 && high<string.length() && string.charAt(low)==string.charAt(high)){
            low--;
            high++;
        }
        return string.substring(low+1,high);
    }
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(1)
    public String longestPalindromicSubStringFinder(String string){
        int maxLength=0;
        String finalString="";
        for(int i=0;i<string.length();i++){
            String oddLength=expander(string, i,i);
            if(maxLength<oddLength.length()){
                finalString=new String(oddLength);
                maxLength=oddLength.length();
            }
            String evenLength=expander(string, i, i+1);
            if(maxLength<evenLength.length()){
                finalString=new String(evenLength);
                maxLength=evenLength.length();
            }
        }
        return finalString;
    }

    public static void main(String[] args) {
        String string="ABDCBCDBDCBBC";
        longestPalindromicSubString obj=new longestPalindromicSubString();
        System.out.println(obj.longestPalindromicSubStringFinder(string));
    }
}

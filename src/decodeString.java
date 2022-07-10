import java.util.Stack;

public class decodeString {
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public String decodeStringFinder(String s){
        Stack<Character> resStack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c!=']'){
                resStack.add(c);
            }
            else{
                StringBuilder sb=new StringBuilder();
                // Retrieving letters
                while(!resStack.isEmpty() && Character.isLetter(resStack.peek())){
                    sb.insert(0,resStack.pop());
                }
                String stringInStack=sb.toString();
                resStack.pop();

                sb=new StringBuilder();
                while(!resStack.isEmpty() && Character.isDigit(resStack.peek())){
                    sb.insert(0,resStack.pop());
                }
                int counter=Integer.valueOf(sb.toString());
                while(counter>0){
                    for(char ch: stringInStack.toCharArray()){
                        resStack.push(ch);
                    }
                    counter--;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        while(!resStack.isEmpty()){
            result.insert(0,resStack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s="3[a]2[bc]";
        decodeString obj=new decodeString();
        System.out.println(obj.decodeStringFinder(s));
    }
}

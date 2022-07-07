import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinationOfPhoneNumber {
    public void letterCombinationFinder(String digits,HashMap<Character,String> hashMap, int index,
                                        List<String> storage, StringBuilder stringBuilder){
        if(index==digits.length()){
            storage.add(stringBuilder.toString());
            return;
        }
        String currentString= hashMap.get((digits.charAt(index)));
        for(int i=0;i<currentString.length();i++){
            stringBuilder.append(currentString.charAt(i));
            letterCombinationFinder(digits,hashMap,index+1,storage,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits="23";
        List<String> storage=new ArrayList<>();
        if(digits.length()==0)
            return;
        HashMap<Character,String> hashMap=new HashMap<>();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        letterCombinationOfPhoneNumber obj=new letterCombinationOfPhoneNumber();
        obj.letterCombinationFinder(digits, hashMap, 0, storage, new StringBuilder());
        for(String i: storage){
            System.out.println(i);
        }

    }
}

import java.util.HashMap;

public class subArrayWithXorK {
    // Time Complexity :- O(N*log(N))
    // Space Complexity :- O(N)
    public int subArrayWithXorKUtil(int[] arr,int k){
        HashMap<Integer,Integer> storage=new HashMap<>();
        int currXor=0,counter=0;
        for(int i:arr){
            currXor^=i;
            if(currXor==k) counter++;
            else if(storage.containsKey(k^currXor)==true) counter+=storage.get(k^currXor);

            if(storage.containsKey(currXor)==true) storage.put(currXor,storage.get(currXor)+1);
            else storage.put(currXor,1);
        }
        return counter;
    }
    public static void main(String[] args) {
        int[] arr={5,6,7,8,9};
        int k=5;
        subArrayWithXorK obj=new subArrayWithXorK();
        System.out.println(obj.subArrayWithXorKUtil(arr,k));

    }
}

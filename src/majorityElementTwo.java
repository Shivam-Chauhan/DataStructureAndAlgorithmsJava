import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class majorityElementTwo {
    public boolean checkerIfMajorityInArray(int[] nums,int element){
        int counter=0;
        for(int i:nums){
            if(i==element)counter++;
            if(counter>nums.length/3) return true;
        }
        return false;
    }
    //Time Complexity :- O(N*log(N))
    // Space Complexity :- O(N)
    public List<Integer> majorityElementBetterSolution(int[] nums){
        HashMap<Integer,Integer> storage=new HashMap<>();
        List<Integer> output=new ArrayList<>();
        for(int i:nums){
            if(storage.containsKey(i)){
                storage.put(i,storage.get(i)+1);
            }
            else{
                storage.put(i,1);
            }
        }
        for(int i:storage.keySet()){
            if(storage.get(i)>nums.length/3){
                output.add(i);
            }
        }
        return output;
    }

    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public List<Integer> majorityElementBestSolution(int[] nums){
        List<Integer> storage=new ArrayList<>();
        int element1=0,element2=0,counterOfFirstElement=0,counterOfSecondElement=0;
        for(int i:nums){
            if(i==element1) counterOfFirstElement++;
            else if(i==element2) counterOfSecondElement++;
            else if(counterOfFirstElement==0){
                element1=i;
                counterOfFirstElement=1;
            }
            else if(counterOfSecondElement==0){
                element2=i;
                counterOfSecondElement=1;
            }
            else{
                counterOfFirstElement--;
                counterOfSecondElement--;
            }
        }
        if(checkerIfMajorityInArray(nums,element1)) storage.add(element1);
        if(element1!=element2 && checkerIfMajorityInArray(nums,element2)) storage.add(element2);
        return storage;
    }

    public static void main(String[] args) {
        int[] nums={3,3,3,3,3,2,2};
        majorityElementTwo obj=new majorityElementTwo();
//        List<Integer> output=obj.majorityElementBetterSolution(nums);
        List<Integer> output=obj.majorityElementBestSolution(nums);
        for(int i:output){
            if (obj.checkerIfMajorityInArray(nums,i))
                System.out.println(i);
            }
        }


}

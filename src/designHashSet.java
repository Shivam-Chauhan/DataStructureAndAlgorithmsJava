import java.util.LinkedList;

public class designHashSet {
    // Time Complexity :- O(1) for Average Case(depends total upon the load factor of the numbers)
    // Space Complexity :- O(N)
    LinkedList<Integer>[] storage;
    int initialCapacity=4091;

    public designHashSet(){
        this.storage=new LinkedList[initialCapacity];
    }
    public int hashValue(int key, int lengthOfStorage){
        return key%lengthOfStorage;
    }
    public boolean contains(int key){
        int index=hashValue(key, storage.length);
        if(storage[index]==null){
            return false;
        }
        else{
            LinkedList<Integer> tempList=storage[index];
            return tempList.contains(key);
        }
    }
    public void add(int key){
        if(contains(key)==false){
            int index=hashValue(key, storage.length);
            if(storage[index]==null){
                LinkedList<Integer> tempList=new LinkedList<>();
                tempList.add(key);
                storage[index]=tempList;
            }
            else{
                LinkedList<Integer> tempList=storage[index];
                tempList.addLast(key);
            }
        }
    }
    public void remove(int key){
        int index=hashValue(key, storage.length);
        if(storage[index]!=null){
            storage[index].removeFirstOccurrence(key);
        }
    }
}

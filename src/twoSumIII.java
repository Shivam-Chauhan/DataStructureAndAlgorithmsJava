import java.util.HashMap;


// Time Complexity For Adding:- O(1)
// Time Complexity For Finding:- O(N)
// Space Complexity :- O(N)
// Link :- https://aaronice.gitbook.io/lintcode/high_frequency/two-sum-iii-data-structure-design
public class twoSumIII {
    HashMap<Integer, Integer> hashMap;

    public twoSumIII() {
        hashMap = new HashMap<>();
    }

    public void add(int element) {
        if (hashMap.containsKey(element)) {
            hashMap.put(element, hashMap.get(element) + 1);
        } else {
            hashMap.put(element, 1);
        }
    }

    public boolean find(int element) {
        for (Integer itr : hashMap.keySet()) {
            int target = element - itr;
            if (hashMap.containsKey(target)) {
                if (itr == target && hashMap.get(target) < 2) continue;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        twoSumIII obj = new twoSumIII();
        obj.add(12);
        obj.add(1);
        obj.add(121);
        obj.add(2);
        obj.add(-12);
        System.out.println(obj.find(3));
        System.out.println(obj.find(88));

    }
}

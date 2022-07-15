import java.util.*;

public class employeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    // Time Complexity :- ~ O(N+E)
    // Space Complexity :- O(N)
    public int getImportance(List<Employee> employees, int id) {
        int result=0;
        Map<Integer,Employee> hashMap=new HashMap<>();
        for(Employee employee: employees){
            hashMap.put(employee.id, employee);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        while(!queue.isEmpty()){
            int node=queue.poll();
            result+=hashMap.get(node).importance;
            for(int sub: hashMap.get(node).subordinates){
                queue.add(sub);
            }
        }
        return result;
    }
}

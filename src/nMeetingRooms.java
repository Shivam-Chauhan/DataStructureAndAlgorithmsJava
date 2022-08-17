import java.util.ArrayList;
import java.util.Collections;

// Time Complexity :- O(N*Log(N)) + O(N)
// Space Complexity :- O(N)
// Link :- https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
class meeting {
    int start, end, pos;

    public meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class nMeetingRooms {

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int[] start, int[] end, int n) {
        ArrayList<meeting> storage = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            storage.add(new meeting(start[i], end[i], i + 1));
        }
        Collections.sort(storage, (a, b) -> a.end - b.end);
        int counter = 1, limit = storage.get(0).end;
        for (int i = 1; i < storage.size(); i++) {
            if (storage.get(i).start > limit) {
                limit = storage.get(i).end;
                counter++;
            }
        }
        return counter;
    }
}

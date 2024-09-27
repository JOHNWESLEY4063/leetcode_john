import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false; 
            }
        }
        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {
                overlaps.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
            }
        }
        calendar.add(new int[] { start, end });
        return true;
    }
}

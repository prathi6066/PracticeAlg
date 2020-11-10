package prathi.learn.practicealg.patterns.mergeintervals;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

/*
Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

Meetings: [[4,5], [2,3], [2,4], [3,5]]
Output: 2
Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].

Time: The time complexity of the above algorithm is O(N*logN)O(N∗logN), where ‘N’ is the total number of meetings. This is due to the sorting that we did in the beginning. Also, while iterating the meetings we might need to poll/offer meeting to the priority queue. Each of these operations can take O(logN)O(logN). Overall our algorithm will take O(NlogN)O(NlogN).
Space:O(N)


Similar problem: Given a list of intervals representing the arrival and departure times of trains to a train station, our goal is to find the minimum number of platforms required for the train station so that no train has to wait.
  */

public class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        // TODO: Write your code here

      //sort the meeting list with start values
       meetings.sort(Comparator.comparingInt(a -> a.start));

       //order the queue based on  end values
       PriorityQueue<Meeting> pqueue = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));
       int roomCount = 0;

       for (Meeting meeting: meetings) {
           while (!pqueue.isEmpty() && pqueue.peek().end <= meeting.start) {
               pqueue.poll();
           }
           pqueue.offer(meeting);
           //the max number of meeting in queue will be the number of rooms that are required.
           roomCount = Math.max(pqueue.size(), roomCount);
       }


        return roomCount;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}


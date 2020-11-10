package prathi.learn.practicealg.patterns.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {

/*
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 */
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // TODO: Write your code here

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i< intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}

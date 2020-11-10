package prathi.learn.practicealg.patterns.mergeintervals;

import java.util.*;

class MergeIntervals {

    /*
    Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

    Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].

The time complexity of the above algorithm is O(N * logN)O(N∗logN), where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N)O(N), in the beginning though, since we need to sort the intervals, our algorithm will take O(N * logN)O(N∗logN).
Space: O(N)
     */

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here
        IntervalComparator comparator = new IntervalComparator();
        intervals.sort(comparator);

        Iterator<Interval> iterator = intervals.iterator();
        if (iterator.hasNext()) {
            Interval intervalIdx = iterator.next();
            int start = intervalIdx.start;
            int end = intervalIdx.end;

            while(iterator.hasNext()) {
                intervalIdx = iterator.next();
                if (intervalIdx.start <= end) {
                    end = Math.max(end, intervalIdx.end);
                } else {
                    mergedIntervals.add(new Interval(start, end));
                    start = intervalIdx.start;
                    end = intervalIdx.end;
                }
            }
            mergedIntervals.add(new Interval(start, end));
        }

        return mergedIntervals;
    }

    private static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

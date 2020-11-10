package prathi.learn.practicealg.strings;

import java.util.*;

public class Competitior {

    public static void main(String[] args) {


        int numCompetitors = 6;
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        int numReviews = 6;
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "i am proud to have fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery afshion"};


        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);

        System.out.println(result);
    }


    public static List<String> getTopCompetitors(int numCompetitors, int topNCompetitors
            , String[] competitors, int numReviews, String[] reviews) {
        HashMap<String, Integer> map = new HashMap<>();
        // add all competitors into HashMap
        for(int i=0; i<numCompetitors; i++) {
            map.put(competitors[i].toLowerCase(), 0);
        }

        // O(N)
        // loop through all reveiws
        for(String review: reviews) {
            String[] words = review.toLowerCase().split(" ");

            // loop through all words in a review
            for(String word: words) {
                if(map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        // O(log N)
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> ( a.getValue() == b.getValue()
                ? b.getKey().compareTo(a.getKey())
                : a.getValue() - b.getValue() ));

        // O(N)
        for(Map.Entry entry: map.entrySet()) {
            queue.offer(entry);
            if(queue.size() > topNCompetitors) {
                queue.poll();
            }
        }

        // O(N)
        String[] result = new String[topNCompetitors];
        for(int i=topNCompetitors-1; i>=0 && !queue.isEmpty(); i--) {
            Map.Entry<String, Integer> entry = queue.poll();
            result[i] = entry.getKey();
        }

        ArrayList<String> r = new ArrayList<>();
        for(String d: result) {
            r.add(d);
        }
        return r;
    }

    public ArrayList<String> topNCompetitors(int numCompetitors,
                                                 int topNCompetitors,
                                                 List<String> competitors,
                                                 int numReviews,
                                                 List<String> reviews)
        {
            // WRITE YOUR CODE HERE
            HashMap<String,Integer> map = new HashMap<>();
            for(int i = 0; i < numCompetitors;i++){
                map.put(competitors.get(i).toLowerCase(),0);
            }

            for(String review : reviews){
                String[] w = review.toLowerCase().split(" ");
                Set<String> u = new HashSet<>();
                for(String word: w){
                    if(map.containsKey(word)){
                        map.put(word,map.get(word)+1);
                    }
                }
            }

            PriorityQueue<Map.Entry<String,Integer>> q =  new PriorityQueue<>(
                    (a,b) -> (a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue() ));

            for(Map.Entry<String,Integer> e : map.entrySet()){
                q.offer(e);
                if(q.size() > topNCompetitors){
                    q.poll();
                }
            }

            String[] res = new String[topNCompetitors];
            for(int i = topNCompetitors-1; i>=0 && !q.isEmpty();i--){
                Map.Entry<String, Integer> entry = q.poll();
                res[i] = entry.getKey();
            }

            ArrayList<String> arr = new ArrayList<String>();
            for(String d : res){
                arr.add(d);
            }

            return arr;
        }
        // METHOD SIGNATURE ENDS
}

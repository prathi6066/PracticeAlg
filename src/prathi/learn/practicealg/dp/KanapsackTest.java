package prathi.learn.practicealg.dp;

public class KanapsackTest {

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Item item1 = new Item(2, 6);
        Item item2 = new Item(2, 10);
        Item item3 = new Item(3, 12);
        Item[] items = new Item[] {item1, item2, item3};

        System.out.println(knapsack(items, 5));
    }

    public static int knapsack(Item[] items, int W) {
        int[] cache = new int[W + 1];
        for (Item i : items) {
            int[] newCache = new int[W + 1];
            for (int j = 0; j <= W; j++) {
                if (i.weight > j) newCache[j] = cache[j];
                else newCache[j] = Math.max(cache[j],
                        cache[j - i.weight] +
                                i.value);
            }
            cache = newCache;
        }

        return cache[W];
    }
}

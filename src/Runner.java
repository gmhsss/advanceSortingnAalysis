
package sortcompare;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Runner {
    private static int[] cloneOf(int[] v) { return Arrays.copyOf(v, v.length); }

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        Map<String,BiConsumer<int[],Metrics>> algos = new LinkedHashMap<>();
        algos.put("Bubble", BubbleSort::sort);
        algos.put("Selection", SelectionSort::sort);
        algos.put("Cocktail", CocktailSort::sort);
        algos.put("Comb", CombSort::sort);
        algos.put("Gnome", GnomeSort::sort);
        algos.put("Bucket", BucketSort::sort);

        int[][] datasets = {vetor1, vetor2, vetor3};
        String[] names = {"vetor1", "vetor2", "vetor3"};

        for (int d = 0; d < datasets.length; d++) {
            System.out.println("=== " + names[d] + " ===");
            for (Map.Entry<String,BiConsumer<int[],Metrics>> e : algos.entrySet()) {
                int[] a = cloneOf(datasets[d]);
                Metrics m = new Metrics();
                e.getValue().accept(a, m);
                System.out.printf("%-8s  swaps=%6d  iteracoes=%6d  ordenado=%s%n",
                    e.getKey(), m.swaps, m.iteracoes, isSorted(a));
            }
            System.out.println();
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }
}

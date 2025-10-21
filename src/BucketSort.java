
package sortcompare;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    // We'll use insertion within each bucket; count each adjacent swap as a "swap"
    private static void insertionWithSwaps(List<Integer> b, Metrics m) {
        for (int i = 1; i < b.size(); i++) {
            m.iteracoes++;
            int j = i;
            while (j > 0 && b.get(j - 1) > b.get(j)) {
                m.iteracoes++;
                int tmp = b.get(j);
                b.set(j, b.get(j - 1));
                b.set(j - 1, tmp);
                m.swaps++;
                j--;
            }
        }
    }
    public static void sort(int[] a, Metrics m) {
        if (a.length == 0) return;
        int n = a.length;
        int bucketCount = Math.max(1, (int)Math.sqrt(n));
        int min = a[0], max = a[0];
        for (int x : a) { if (x < min) min = x; if (x > max) max = x; }
        if (min == max) return;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());
        for (int x : a) {
            m.iteracoes++;
            int idx = (int)((double)(x - min) / (max - min + 1e-9) * (bucketCount - 1));
            buckets.get(idx).add(x);
        }
        int k = 0;
        for (List<Integer> b : buckets) {
            m.iteracoes++;
            insertionWithSwaps(b, m);
            for (int v : b) a[k++] = v;
        }
    }
}


package sortcompare;

public class SelectionSort {
    public static void sort(int[] a, Metrics m) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            m.iteracoes++;
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                m.iteracoes++;
                if (a[j] < a[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                m.swaps++;
            }
        }
    }
}

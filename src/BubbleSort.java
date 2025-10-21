
package sortcompare;

public class BubbleSort {
    public static void sort(int[] a, Metrics m) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            m.iteracoes++;
            for (int j = 0; j < n - i - 1; j++) {
                m.iteracoes++;
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    m.swaps++;
                }
            }
        }
    }
}

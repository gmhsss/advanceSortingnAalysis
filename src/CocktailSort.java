
package sortcompare;

public class CocktailSort {
    public static void sort(int[] a, Metrics m) {
        int n = a.length;
        boolean swapped = true;
        int start = 0, end = n - 1;
        while (swapped) {
            m.iteracoes++;
            swapped = false;
            for (int i = start; i < end; i++) {
                m.iteracoes++;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    m.swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                m.iteracoes++;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    m.swaps++;
                    swapped = true;
                }
            }
            start++;
        }
    }
}


package sortcompare;

public class GnomeSort {
    public static void sort(int[] a, Metrics m) {
        int n = a.length;
        int i = 0;
        while (i < n) {
            m.iteracoes++;
            if (i == 0) {
                i++;
            } else if (a[i] >= a[i - 1]) {
                i++;
            } else {
                int tmp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = tmp;
                m.swaps++;
                i--;
            }
        }
    }
}

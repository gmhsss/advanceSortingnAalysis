
package sortcompare;

public class CombSort {
    public static void sort(int[] a, Metrics m) {
        int n = a.length;
        int gap = n;
        double shrink = 1.3;
        boolean sorted = false;
        while (!sorted) {
            m.iteracoes++;
            gap = (int)(gap / shrink);
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i + gap < n) {
                m.iteracoes++;
                if (a[i] > a[i + gap]) {
                    int tmp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = tmp;
                    m.swaps++;
                    sorted = false;
                }
                i++;
            }
        }
    }
}

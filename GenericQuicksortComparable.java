public class GenericQuicksortComparable {

    public static <Letter extends Comparable<Letter>> void qsort(Letter[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            Letter x = arr[(i + j) / 2];

            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    Letter tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    	}
    }

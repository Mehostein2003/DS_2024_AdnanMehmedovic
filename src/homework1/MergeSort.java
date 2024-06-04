package homework1;

public class MergeSort {
    public static void sort(Entry[] entries) {
        if (entries.length > 1) {
            Entry[] left = new Entry[entries.length / 2];
            Entry[] right = new Entry[entries.length - entries.length / 2];

            System.arraycopy(entries, 0, left, 0, left.length);
            System.arraycopy(entries, left.length, right, 0, right.length);

            sort(left);
            sort(right);
            merge(entries, left, right);
        }
    }

    private static void merge(Entry[] result, Entry[] left, Entry[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]) < 0)) {
                result[i] = left[i1++];
            } else {
                result[i] = right[i2++];
            }
        }
    }
}
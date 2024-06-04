package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int firstIndex = -1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = entries[mid].getName().compareTo(searchableName);

            if (cmp == 0) {
                firstIndex = mid;
                lastIndex = mid;
                // Find the first occurrence
                while (firstIndex > 0 && entries[firstIndex - 1].getName().equals(searchableName)) {
                    firstIndex--;
                }
                // Find the last occurrence
                while (lastIndex < entries.length - 1 && entries[lastIndex + 1].getName().equals(searchableName)) {
                    lastIndex++;
                }
                return new int[]{firstIndex, lastIndex};
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{};
    }
}
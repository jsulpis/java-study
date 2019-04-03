package sorting;

import java.util.List;

import static java.util.Collections.swap;

public class BubbleSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i; j++) {
                if (isGreaterThanNextElement(list, j)) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
        return list;
    }

    private boolean isGreaterThanNextElement(List<T> list, int j) {
        return list.get(j).compareTo(list.get(j + 1)) > 0;
    }


}

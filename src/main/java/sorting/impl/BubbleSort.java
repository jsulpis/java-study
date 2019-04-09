package sorting.impl;

import sorting.ListSortingAlgorithm;

import java.util.List;

import static java.util.Collections.swap;

public class BubbleSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            if (!riseElementsToTheSurface(list, i))
                break;
        }
        return list;
    }

    // reference to the name of the algorithm: the "surface" is the end of the list
    // where the biggest elements ("bubbles") are pushed.
    private boolean riseElementsToTheSurface(List<T> list, int i) {
        boolean swapped = false;
        for (int j = 0; j < list.size() - i; j++) {
            if (isGreaterThanNextElement(list, j)) {
                swap(list, j, j + 1);
                swapped = true;
            }
        }
        return swapped;
    }

    private boolean isGreaterThanNextElement(List<T> list, int j) {
        return list.get(j).compareTo(list.get(j + 1)) > 0;
    }


}

package sorting.impl;

import sorting.ListSortingAlgorithm;

import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i + findIndiceMinimum(list.subList(i, n));
            Collections.swap(list, i, indiceMin);
        }
        return list;
    }

    private int findIndiceMinimum(List<T> list) {
        T min = list.get(0);
        int indiceMin = 0;
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j).compareTo(min) < 0) {
                min = list.get(j);
                indiceMin = j;
            }
        }
        return indiceMin;
    }
}

package sorting.impl;

import sorting.ListSortingAlgorithm;

import java.util.Collections;
import java.util.List;

public class CollectionsSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        Collections.sort(list);
        return list;
    }
}

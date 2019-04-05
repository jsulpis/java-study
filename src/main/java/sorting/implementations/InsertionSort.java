package sorting.implementations;

import sorting.ListSortingAlgorithm;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            int pos = i;
            T item = list.get(i);

            while (pos > 0 && list.get(pos - 1).compareTo(item) > 0) {
                list.set(pos, list.get(pos - 1));
                pos--;
            }
            list.set(pos, item);
        }
        return list;
    }
}

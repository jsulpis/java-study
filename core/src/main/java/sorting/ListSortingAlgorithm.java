package sorting;

import java.util.List;

public interface ListSortingAlgorithm<T extends Comparable<? super T>> {

    List<T> sort(List<T> list);
}

package sorting;

import java.util.List;

public interface ListSortingAlgorithm<T extends Comparable<? super T>> {

    String getName();

    List<T> sort(List<T> list);
}

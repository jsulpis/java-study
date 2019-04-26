package sorting.impl;

import sorting.ListSortingAlgorithm;

import java.util.List;

import static java.util.Collections.swap;

public class QuickSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public List<T> sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
        return list;
    }

    private void quickSort(List<T> list, int left, int right) {
        if (left < right) {
            int partitioningIndex = partition(list, left, right);
            quickSort(list, left, partitioningIndex - 1);
            quickSort(list, partitioningIndex + 1, right);
        }
    }

    private int partition(List<T> list, int left, int right) {
        T pivot = list.get(right);
        int smallerElementPosition = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                smallerElementPosition++;
                swap(list, smallerElementPosition, j);
            }
        }
        int pivotPosition = smallerElementPosition + 1;
        swap(list, pivotPosition, right);
        return pivotPosition;
    }
}

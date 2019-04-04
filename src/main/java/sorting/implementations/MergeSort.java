package sorting.implementations;

import sorting.ListSortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> implements ListSortingAlgorithm<T> {

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public List<T> sort(List<T> list) {
        list = new ArrayList<>(list);

        if (list.size() == 1)
            return list;
        else
            return splitAndMergeList(list);
    }

    private List<T> splitAndMergeList(List<T> list) {
        int n = list.size();
        int middle = (int) Math.floor(n / 2.0);

        List<T> subList1 = list.subList(0, middle);
        List<T> subList2 = list.subList(middle, n);

        subList1 = sort(subList1);
        subList2 = sort(subList2);

        return merge(subList1, subList2);
    }

    private List<T> merge(List<T> l1, List<T> l2) {
        List<T> mergedList = mergeSublists(l1, l2);
        addRemainingItems(l1, l2, mergedList);
        return mergedList;
    }

    private List<T> mergeSublists(List<T> l1, List<T> l2) {
        List<T> mergedList = new ArrayList<>();

        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (l1.get(0).compareTo(l2.get(0)) > 0)
                mergedList.add(l2.remove(0));
            else
                mergedList.add(l1.remove(0));
        }
        return mergedList;
    }

    private void addRemainingItems(List<T> l1, List<T> l2, List<T> mergedList) {
        List<T> remainingItems = l1.isEmpty() ? l2 : l1;
        mergedList.addAll(remainingItems);
    }
}

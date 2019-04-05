package sorting;

import org.junit.Test;
import sorting.implementations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListSortingAlgorithmTest {

    @Test
    public void bubbleSortTest() {
        testSortingAlgorithm(new BubbleSort<>());
    }

    @Test
    public void insertionSortTest() {
        testSortingAlgorithm(new InsertionSort<>());
    }

    @Test
    public void selectionSortTest() {
        testSortingAlgorithm(new SelectionSort<>());
    }

    @Test
    public void mergeSortTest() {
        testSortingAlgorithm(new MergeSort<>());
    }

    @Test
    public void quickSortTest() {
        testSortingAlgorithm(new QuickSort<>());
    }

    private void testSortingAlgorithm(ListSortingAlgorithm<Integer> algo) {
        listWithOneElementShouldRemainUnchanged(algo);
        sortedListShouldRemainUnchanged(algo);
        unsortedListWithMoreThanOneElementsShouldBeSorted(algo);
    }

    private void listWithOneElementShouldRemainUnchanged(ListSortingAlgorithm<Integer> algo) {
        List<Integer> list = Collections.singletonList(0);
        assertEquals(list, algo.sort(list));
    }

    private void sortedListShouldRemainUnchanged(ListSortingAlgorithm<Integer> algo) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        assertEquals(list, algo.sort(list));
    }

    private void unsortedListWithMoreThanOneElementsShouldBeSorted(ListSortingAlgorithm<Integer> algo) {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 5, 1, 7, 6, 2));
        List<Integer> sortedList = Arrays.asList(1, 2, 5, 6, 7, 9);
        assertEquals(sortedList, algo.sort(list));
    }
}

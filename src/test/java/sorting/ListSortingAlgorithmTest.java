package sorting;

import org.junit.Test;

import java.util.Arrays;
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

    private void testSortingAlgorithm(ListSortingAlgorithm<Integer> algo) {
        // Given
        List<Integer> list = Arrays.asList(9, 5, 1, 7, 6, 2);
        List<Integer> sortedList = Arrays.asList(1, 2, 5, 6, 7, 9);

        // When
        List<Integer> actualSortedList = algo.sort(list);

        // Then
        assertEquals(sortedList, actualSortedList);
    }


}

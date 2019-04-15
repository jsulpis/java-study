package unit.sorting;

import org.junit.Test;
import sorting.ListSortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class ListSortingAlgorithmTest {

    protected ListSortingAlgorithm<Integer> algo;

    @Test
    public void listWithOneElementShouldRemainUnchanged() {
        List<Integer> list = Collections.singletonList(0);
        assertEquals(list, algo.sort(list));
    }

    @Test
    public void sortedListShouldRemainUnchanged() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        assertEquals(list, algo.sort(list));
    }

    @Test
    public void unsortedListWithMoreThanOneElementShouldBeSorted() {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 5, 1, 7, 6, 2));
        List<Integer> sortedList = Arrays.asList(1, 2, 5, 6, 7, 9);
        assertEquals(sortedList, algo.sort(list));
    }
}

package unit.sorting;

import org.junit.Test;
import sorting.ListSortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ListSortingAlgorithmTest {

    protected ListSortingAlgorithm<Integer> algo;

    @Test
    public void listWithOneElementShouldRemainUnchanged() {
        List<Integer> list = Collections.singletonList(0);
        assertThat(algo.sort(list)).isEqualTo(list);
    }

    @Test
    public void sortedListShouldRemainUnchanged() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
        assertThat(algo.sort(list)).isEqualTo(list);
    }

    @Test
    public void unsortedListWithMoreThanOneElementShouldBeSorted() {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 5, 1, 7, 6, 2));
        List<Integer> sortedList = Arrays.asList(1, 2, 5, 6, 7, 9);
        assertThat(algo.sort(list)).isEqualTo(sortedList);
    }
}

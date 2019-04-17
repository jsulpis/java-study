package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.MergeSort;
import unit.sorting.ListSortingAlgorithmTest;

public class MergeSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new MergeSort<>();
    }
}

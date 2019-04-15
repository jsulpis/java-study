package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.QuickSort;
import unit.sorting.ListSortingAlgorithmTest;

public class QuickSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new QuickSort<>();
    }
}

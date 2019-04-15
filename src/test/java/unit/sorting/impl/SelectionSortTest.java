package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.SelectionSort;
import unit.sorting.ListSortingAlgorithmTest;

public class SelectionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new SelectionSort<>();
    }
}

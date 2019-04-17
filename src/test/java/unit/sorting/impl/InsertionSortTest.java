package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.InsertionSort;
import unit.sorting.ListSortingAlgorithmTest;

public class InsertionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new InsertionSort<>();
    }
}

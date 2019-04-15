package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.BubbleSort;
import unit.sorting.ListSortingAlgorithmTest;

public class BubbleSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new BubbleSort<>();
    }
}

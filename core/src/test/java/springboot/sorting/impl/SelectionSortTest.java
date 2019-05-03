package springboot.sorting.impl;

import org.junit.Before;
import sorting.impl.SelectionSort;
import springboot.sorting.ListSortingAlgorithmTest;

public class SelectionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new SelectionSort<>();
    }
}

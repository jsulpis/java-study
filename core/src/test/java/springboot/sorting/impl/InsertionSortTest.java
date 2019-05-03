package springboot.sorting.impl;

import org.junit.Before;
import sorting.impl.InsertionSort;
import springboot.sorting.ListSortingAlgorithmTest;

public class InsertionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new InsertionSort<>();
    }
}

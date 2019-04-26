package springboot.sorting.impl;

import org.junit.Before;
import sorting.impl.BubbleSort;
import springboot.sorting.ListSortingAlgorithmTest;

public class BubbleSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new BubbleSort<>();
    }
}

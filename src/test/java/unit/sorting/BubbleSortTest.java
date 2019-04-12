package unit.sorting;

import org.junit.Before;
import sorting.impl.BubbleSort;

public class BubbleSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new BubbleSort<>();
    }
}

package unit.sorting;

import org.junit.Before;
import sorting.impl.QuickSort;

public class QuickSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new QuickSort<>();
    }
}

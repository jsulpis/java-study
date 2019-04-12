package unit.sorting;

import org.junit.Before;
import sorting.impl.SelectionSort;

public class SelectionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new SelectionSort<>();
    }
}

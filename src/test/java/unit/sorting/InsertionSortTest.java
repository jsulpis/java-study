package unit.sorting;

import org.junit.Before;
import sorting.impl.InsertionSort;

public class InsertionSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new InsertionSort<>();
    }
}

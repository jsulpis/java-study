package unit.sorting;

import org.junit.Before;
import sorting.impl.MergeSort;

public class MergeSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new MergeSort<>();
    }
}

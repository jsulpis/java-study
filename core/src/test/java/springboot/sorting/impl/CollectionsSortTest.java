package springboot.sorting.impl;

import org.junit.Before;
import sorting.impl.CollectionsSort;
import springboot.sorting.ListSortingAlgorithmTest;

public class CollectionsSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new CollectionsSort<>();
    }
}

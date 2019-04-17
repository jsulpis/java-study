package unit.sorting.impl;

import org.junit.Before;
import sorting.impl.CollectionsSort;
import unit.sorting.ListSortingAlgorithmTest;

public class CollectionsSortTest extends ListSortingAlgorithmTest {

    @Before
    public void setUp() {
        algo = new CollectionsSort<>();
    }
}

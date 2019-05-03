package sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sorting.impl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListSortingBenchmark {

    private static final Logger LOG = LoggerFactory.getLogger(ListSortingBenchmark.class);
    private static final int LIST_SIZE = 10;

    public static void main(String[] args) {
        printHeader();
        runBenchmarkAndLogResult();
    }

    private static void runBenchmarkAndLogResult() {
        List<Integer> listToSort = new Random().ints(LIST_SIZE).boxed().collect(Collectors.toList());
        List<ListSortingAlgorithm<Integer>> algorithms = Arrays.asList(new BubbleSort<>(), new InsertionSort<>(), new MergeSort<>(), new QuickSort<>(), new SelectionSort<>(), new CollectionsSort<>());

        for (ListSortingAlgorithm<Integer> algo : algorithms) {
            long startTime = System.currentTimeMillis();
            algo.sort(new ArrayList<>(listToSort));
            formatAndLogString("%20s %15s", algo.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
        }
    }

    private static void printHeader() {
        LOG.info("### Benchmark of the speed of various sorting algorithms ###");
        LOG.info("Running the benchmark on a list of {} elements.", LIST_SIZE);
        LOG.info("");
        LOG.info("-----------------------------------------------");
        formatAndLogString("%18s %20s", "ALGO", "TIME(ms)");
        LOG.info("-----------------------------------------------");
    }

    private static void formatAndLogString(String rawString, Object... params) {
        String formattedString = String.format(rawString, params);
        LOG.info(formattedString);
    }
}

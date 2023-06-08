package mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Integer> listToSort = Arrays.asList(4,5,1,3,2,7,8,6);
        MergeSorter mergeSorter = new MergeSorter(listToSort);

        List<Integer> sortedArray = mergeSorter.call();

        System.out.println(sortedArray);
    }
}

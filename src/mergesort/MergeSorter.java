package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    ExecutorService executorService;

    public MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(listToSort.size() <= 1) {
            return listToSort;
        }

        int mid = listToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        for(int i = 0; i < mid; i++) {
            leftArray.add(listToSort.get(i));
        }

        List<Integer> rightArray = new ArrayList<>();
        for(int i = mid; i < listToSort.size(); i++) {
            rightArray.add(listToSort.get(i));
        }

        MergeSorter leftMergeSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightArray, executorService);


        Future<List<Integer>> leftSortedArrayFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedArrayFuture = executorService.submit(rightMergeSorter);

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        int i = 0;
        int j = 0;
        List<Integer> sortedArray = new ArrayList<>();
        while(i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if(leftSortedArray.get(i) < rightSortedArray.get(j)) {
                sortedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i < leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j < rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }

        return sortedArray;
    }
}

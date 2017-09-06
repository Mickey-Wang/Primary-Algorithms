package test;

import java.util.Arrays;

import generateTestCase.SortTestHelper;

public class testMain {

	public static void main(String[] args) {
		int N = 10000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr9 = Arrays.copyOf(arr1, arr1.length);
        
        // ------------------------ basic --------------------------------
//        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
//        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
//        SortTestHelper.testSort("sortingBasic.bubbleSort.BubbleSort", arr3);
//        SortTestHelper.testSort("sortingBasic.shellSort.ShellSort", arr4); // 希尔排序的性能在前四种中最好
        
        // ------------------------ advance --------------------------------
         /*Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
         可以在1秒之内轻松处理100万数量级的数据
         注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
         否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异*/
        // 当N=100`000，MergeSort : 84ms; 当N=1`000`000，InsertionSort : 17171ms
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSort", arr5);
        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortOpt", arr6);
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortBU", arr7);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort", arr8);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort4NearlyOrdered", arr9);
        

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
//        arr2 = Arrays.copyOf(arr1, arr1.length);
//        arr3 = Arrays.copyOf(arr1, arr1.length);
//        arr4 = Arrays.copyOf(arr1, arr1.length);
//        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
//        arr7 = Arrays.copyOf(arr1, arr1.length);
        arr8 = Arrays.copyOf(arr1, arr1.length);
        arr9 = Arrays.copyOf(arr1, arr1.length);

        // ------------------------ basic --------------------------------
//        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
//        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
//        SortTestHelper.testSort("sortingBasic.bubbleSort.BubbleSort", arr3);
//        SortTestHelper.testSort("sortingBasic.shellSort.ShellSort", arr4);
        
        // ------------------------ advance --------------------------------
         /*对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
         所以可以尝试, 当swapTimes比较大时, MergeSort更快
         但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快*/
        // 当N=1`000`000，MergeSort : 299ms; 当N=1`000`000，InsertionSort : 61ms
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSort", arr5);
        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortOpt", arr6);
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortBU", arr7);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort", arr8);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort4NearlyOrdered", arr9);

        return;
	}

}

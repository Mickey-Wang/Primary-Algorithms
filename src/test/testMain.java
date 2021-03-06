package test;

import java.util.Arrays;

import generateTestCase.SortTestHelper;

public class testMain {

	public static void main(String[] args) {
		int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr9 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr10 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr11 = Arrays.copyOf(arr1, arr1.length);
        
        // ------------------------ basic --------------------------------
//        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
//        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
//        SortTestHelper.testSort("sortingBasic.bubbleSort.BubbleSort", arr3);
//        SortTestHelper.testSort("sortingBasic.shellSort.ShellSort", arr4); // 希尔排序的性能在前四种中最好
        
        // ------------------------ advance --------------------------------
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSort", arr5);
        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortOpt", arr6);
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortBU", arr7);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort", arr8);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort4NearlyOrdered", arr9);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort2Ways", arr10);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort3Ways", arr11);
        

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
//        arr8 = Arrays.copyOf(arr1, arr1.length);
//        arr9 = Arrays.copyOf(arr1, arr1.length);
        arr10 = Arrays.copyOf(arr1, arr1.length);
        arr11 = Arrays.copyOf(arr1, arr1.length);

        // ------------------------ basic --------------------------------
//        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
//        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
//        SortTestHelper.testSort("sortingBasic.bubbleSort.BubbleSort", arr3);
//        SortTestHelper.testSort("sortingBasic.shellSort.ShellSort", arr4);
        
        // ------------------------ advance --------------------------------
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSort", arr5);
        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortOpt", arr6);
//        SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortBU", arr7);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort", arr8);
//        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort4NearlyOrdered", arr9);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort2Ways", arr10);
        SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort3Ways", arr11);

        System.out.println();
        
        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");
        
        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr10 = Arrays.copyOf(arr1, arr1.length);
        arr11 = Arrays.copyOf(arr1, arr1.length);
      
      	SortTestHelper.testSort("sortingAdvance.mergeSort.MergeSortOpt", arr6);
      	SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort2Ways", arr10);
      	SortTestHelper.testSort("sortingAdvance.quickSort.QuickSort3Ways", arr11);
      	
        return;
	}

}

package sortingBasic.insertionSort;

import java.util.Arrays;

import generateTestCase.SortTestHelper;

public class InsertionSort {
    // 我们的算法类不允许产生任何实例
    private InsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 1; i < n; i++) {

            // 寻找元素arr[i]合适的插入位置

            // 写法1
//            for( int j = i ; j > 0 ; j -- )
//                if( arr[j].compareTo( arr[j-1] ) < 0 )
//                    swap( arr, j , j-1 );
//                else
//                    break;

            // 写法2
            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
                swap(arr, j, j-1);
            
            // 写法3 优化改进方法，对有序性较强的数据尤其适合
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1, N);
        
        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
        
        // 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sortingBasic.selectionSort.usingComparable.SelectionSort", arr1);
        SortTestHelper.testSort("sortingBasic.insertionSort.InsertionSort", arr2);
    }
}
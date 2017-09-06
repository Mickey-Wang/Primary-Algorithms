package sortingAdvance.quickSort;

import sortingBasic.insertionSort.InsertionSort;

/*
 * 与优化后的归并排序比较测试后的结果：
	Test for random array, size = 10000000 , random range [0, 10000000]
	MergeSortOpt : 6405ms
	QuickSort4NearlyOrdered : 3770ms
	
	Test for nearly ordered array, size = 10000000 , swap time = 100
	MergeSortOpt : 654ms
	QuickSort4NearlyOrdered : 855ms
	
	对于无序数据排序，快排要比归并有常数级的优势
	对于有序数据排序，优化后的归并要比快排有常数级的优势，因为优化后的归并如果有序便不再排序
 */
public class QuickSort4NearlyOrdered {
	// 我们的算法类不允许产生任何实例
    private QuickSort4NearlyOrdered(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

    		// 由于快速排序在切分子序列时并非均分，所以切分的平衡度不如归并排序，
    		// 这样可能切分lgn层并不够，而远比lgn深，最坏的时间复杂度是退化为O(n^2)
    		// 比如，对于近乎有序的数据，可能p始终位于序列最左侧，这样一共切分n层。
    		// 所以我们随机将arr[l,r]中的某一个值与arr[l]交换，这样时间复杂度的期望值便可达到O(nlgn)
	    	// 优化二：随机在arr[l...r]的范围中, 选择一个数值作为标定点p
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 优化一：对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}

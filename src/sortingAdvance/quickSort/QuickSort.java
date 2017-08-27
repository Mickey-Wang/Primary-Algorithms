package sortingAdvance.quickSort;

import generateTestCase.SortTestHelper;

/**
 * <p>比较Merge Sort和Quick Sort两种排序算法的性能效率。两种排序算法虽然都是O(nlogn)级别的, <b>但是Quick Sort算法有常数级的优势</b>，Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化</p>
 * @author MickeyWang
 *
 */
public class QuickSort {
	// 我们的算法类不允许产生任何实例
    private QuickSort(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        Comparable v = arr[l];

        // 注意初始条件
        int j = l; 
        // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
//                j ++;
//                swap(arr, j, i);
            		 swap(arr, ++j, i); // 更为优雅
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        if( l >= r )
            return;

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

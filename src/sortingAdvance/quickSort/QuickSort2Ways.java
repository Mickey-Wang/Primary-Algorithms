package sortingAdvance.quickSort;

import generateTestCase.SortTestHelper;
import sortingBasic.insertionSort.InsertionSort;

/**
 * 双路快速排序算法也是一个O(nlogn)复杂度的算法，可以在1秒之内轻松处理100万数量级的数据
 * 这里我们用来解决对包含大量相同元素的数组进行排序时partition分布不均的问题
 * @author MickeyWang
 *
 */
public class QuickSort2Ways {
	 // 我们的算法类不允许产生任何实例
    private QuickSort2Ways(){}

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] <= arr[p] ; arr[p+1...r] >= arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;

            // 对于上面的两个边界的设定，是因为对于连续出现相等的情况，前者会交换i和j的值；而后者则会将连续出现的这些值归为其中一方，使得两棵子树不平衡

            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
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

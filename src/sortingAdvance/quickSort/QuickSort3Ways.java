package sortingAdvance.quickSort;

import sortingBasic.insertionSort.InsertionSort;

/**
 * <p>比较Merge Sort和双路快速排序和三路快排三种排序算法的性能效率，对于包含有大量重复数据的数组, 三路快排有巨大的优势</p>
 * <p>对于一般性的随机数组和近乎有序的数组, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里。因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。比如Java:)</p>
 * @author MickeyWang
 *
 */
public class QuickSort3Ways {
	 // 我们的算法类不允许产生任何实例
    private QuickSort3Ways(){}

    // 递归使用快速排序,对arr[l...r]的范围进行排序，将其分为<v;=v;>v三部分。之后继续对<v;>v两部分用三路快排进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i].compareTo(v) < 0 ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i].compareTo(v) > 0 ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
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

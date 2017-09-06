package sortingBasic.insertionSort;

import java.util.Arrays;

import generateTestCase.SortTestHelper;

public class InsertionSort {
    // 我们的算法类不允许产生任何实例
    private InsertionSort(){}

    // 对整个arr数组使用InsertionSort排序
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
//            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
//                swap(arr, j, j-1);
            
            // 写法3 优化改进方法，对有序性较强的数据尤其适合
            Comparable e = arr[i];
            int j;
            for(j = i ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }
    
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){
    	
        if(!(l >= 0 && l <= r && r < arr.length))
//        		throw new RuntimeException("插入排序入参错误不正确");
    			return;

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j;
            for(j = i; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}

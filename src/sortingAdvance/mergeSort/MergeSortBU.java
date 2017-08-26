package sortingAdvance.mergeSort;

import java.util.Arrays;

import generateTestCase.SortTestHelper;
import sortingBasic.insertionSort.InsertionSort;

/**
 * <p>Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环。Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据</p>
 * <p>注意：<b>不要轻易根据循环层数来判断算法的复杂度</b>，Merge Sort BU就是一个反例。</p>
 * @author MickeyWang
 * 
 */
public class MergeSortBU {
	// 我们的算法类不允许产生任何实例
    private MergeSortBU(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
        for (int sz = 1; sz < n; sz *= 2) // sz代表每次归并所考察的数据规模
            for (int i = 0; i + sz < n; i += sz+sz) // i之所以加一个sz是因为，如果最后只剩一个sz，而归并排序是对2sz进行排序，那么此时就没有必要进行下去了
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
//        for( int i = 0 ; i < n ; i += 16 )
//            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );
//
//        for( int sz = 16; sz < n ; sz += sz )
//            for( int i = 0 ; i < n - sz ; i += sz+sz )
//                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
//                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
//                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }

}

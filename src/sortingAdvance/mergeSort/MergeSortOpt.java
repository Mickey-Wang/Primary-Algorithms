package sortingAdvance.mergeSort;

import java.util.Arrays;

import generateTestCase.SortTestHelper;
import sortingBasic.insertionSort.InsertionSort;

public class MergeSortOpt {
	// 我们的算法类不允许产生任何实例
    private MergeSortOpt(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

	    	// i、j都是相对于arr这个数组来讲的，而复制后的aux数组的下标是从0开始的，所以arr[l,r] <=> aux[l-l,r-l]，注意赋值时两个数组之间的偏移量。i-l、j-l是对应到aux数组上的正确下标。
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1); // auxiliary 辅助变量，用于存放一个数据片段的副本

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

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 优化2: 对于小规模数组, 使用插入排序，因为小规模的数组片段比大规模的原数组有序性更强
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge。因为两个子序列是有序的。但此优化无法改变数量级，归并算法无法退化成o(n)复杂度的，还是nlog（n）复杂度
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失，因为判断本身也是需要消耗资源的
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }
    
}

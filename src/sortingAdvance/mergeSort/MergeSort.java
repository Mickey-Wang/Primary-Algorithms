package sortingAdvance.mergeSort;

import java.util.Arrays;

import generateTestCase.SortTestHelper;

/**
 * <p>Merge Sort是我们学习的第一个O(nlogn)复杂度的算法，可以在1秒之内轻松处理100万数量级的数据</p>
 * <p>注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据，否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异</p>
 * <p>当N=100`000，MergeSort : 84ms; 当N=1`000`000，InsertionSort : 17171ms</p>
 * @author MickeyWang
 *
 */
public class MergeSort {
	// 我们的算法类不允许产生任何实例
    private MergeSort(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

	    	// i、j都是相对于arr这个数组来讲的，而复制后的aux数组的下标是从0开始的，所以arr[l,r] <=> aux[l-l,r-l]，注意赋值时两个数组之间的偏移量。i-l、j-l是对应到aux数组上的正确下标。
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1); // auxiliary 辅助变量，用于存放一个数据片段的副本

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){ // 用副本数组中的值，一个个替换覆盖原数组的每一个值，所以要循环r-l+1次

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

        if (l >= r)
            return;

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

}

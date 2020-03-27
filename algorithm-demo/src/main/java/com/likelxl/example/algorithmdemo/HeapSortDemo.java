package com.likelxl.example.algorithmdemo;

/**
 * 堆排序实现
 * 将待排序的序列构造成一个大顶堆(从大到小排要构造成小顶堆)。
 * 此时，整个序列的最大值就是堆顶的根节点，将他和末尾元素交换，然后将剩余的length-1个节点序列重新构造成新的堆。
 * 重复执行，便能得到一个有序序列。
 * */
public class HeapSortDemo {

    public static void main(String[] args) {
//        int[] b = {49, 38, 65, 97, 76, 13, 27, 50};
        int[] b = {49, 60, 65, 97, 76, 13, 98, 50};
        heapSort(b, b.length - 1);
        for (int w : b)
            System.out.print(" " + w);
    }

    static void heapSort(int[] a, int len) {
        int i;
        for (i = len / 2; i >= 0; i--) { /*把a[]构造成一个大顶堆*/
            HeapAdjust(a, i, len);
        }
        for (i = len; i > 0; i--) {
            swap(a, 0, i); /*交换堆顶最大元素和堆尾最小元素*/
            HeapAdjust(a, 0, i - 1);  /*把交换后的堆a[0,i-1]，再次构造成大顶顶，使堆顶元素为最大值*/
        }
    }

    static void HeapAdjust(int[] a, int start, int len) {
        int temp, j;
        temp = a[start];
        for (j = 2 * start; j <= len; j *= 2) {   /*从index最大的有孩子的节点开始筛选，堆排*/
            if (j < len && a[j] < a[j + 1])    /*是index=j的元素为较大的元素 */
                j++; // 这个判断的作用是查找 a[2*start] 和 a[2*start+1] 中较大的，然后后面需要用较大的和 a[start]比较
                    // 如果是小顶堆，那么这里就是要比较出最小的
            if (temp >= a[j])
                break;
            a[start] = a[j];            /*将较大元素赋值给父节点*/
            start = j;
        }
        a[start] = temp;
    }

    static void swap(int a[], int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }


}

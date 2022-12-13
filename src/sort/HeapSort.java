package sort;

import java.util.Arrays;

/**
 * 描述：从堆顶把根卸出来放在有序区之前，再恢复堆。
 * 特点：(最大堆，有序区）
 * 时间复杂度：O(n*log(n))
 * 稳定性：不稳定
 */
public class HeapSort extends Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 6, 7, 4, 5, 1, 3, 2, 8, 9};
        new HeapSort().sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            heapSort(arr, i);
        }
    }

    private void heapSort(int[] arr, int len) {
        int temp;
        int l;
        int mid = len / 2;//最后一个非叶子结点
        //如果父结点小于子结点 则交换
        for (int i = mid; i >= 0; i--) {
            //分为有无右结点
            if (i * 2 + 2 <= len) {
                if (arr[i * 2 + 1] > arr[i * 2 + 2]) {
                    l = i * 2 + 1;
                } else {
                    l = i * 2 + 2;
                }
            } else {
                l = i * 2 + 1;
            }
            if (arr[i] < arr[l]) {
                temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;

            }
        }
        //交换首尾结点
        temp = arr[0];
        arr[0] = arr[len];
        arr[len] = temp;
        System.out.println(Arrays.toString(arr));
    }

}

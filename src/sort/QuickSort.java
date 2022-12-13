package sort;

/**
 * 描述：在区间中挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元索放在基准之后，再分别对小数区与大数区进行排序。
 * 特点：（小数，基准元素，大数）
 * 时间复杂度：O(n*n)
 * 稳定性：不稳定
 */
public class QuickSort extends Sort {
    public static void main(String[] args) {
        TestTime.test(new QuickSort());//消耗时间：9毫秒
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            //在左边找到一个大于等于pivot的
            while (arr[l] < pivot) {
                l++;
            }
            //在右边找到一个小于等于pivot的
            while (arr[r] > pivot) {
                r--;
            }
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}

package sort;

public class ShellSort extends Sort {
    public static void main(String[] args) {
        TestTime.test(new ShellSort());//消耗时间：7毫秒
    }

    /**
     * 移位法（优化）
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap != 0) {
            //遍历各组中所有的元素（共gap组，每组len/gap个），步长为gap
            for (int i = gap; i < len; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //移动
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                //当退出while说明找到了位置
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    /**
     * 交换法
     *
     * @param arr 待排序数组
     */
    public void sort1(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap != 0) {
            //遍历各组中所有的元素（共gap组，每组len/gap个），步长为gap
            for (int i = gap; i < len; i++) {
                for (int j = i - gap; j >= 0; j--) {
                    //如果当前元素大于后面的元素则要交换
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            gap /= 2;
        }
    }
}

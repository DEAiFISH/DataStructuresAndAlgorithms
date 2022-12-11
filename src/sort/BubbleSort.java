package sort;

public class BubbleSort extends Sort {
    public static void main(String[] args) {
        TestTime.test(new BubbleSort());//消耗时间：8374毫秒
    }

    @Override
    //冒泡排序优化2
    public void sort(int[] arr) {
        int len = arr.length;
        int k = len - 1, pos = 0;//pos变量用来标记循环里最后一次交换的位置

        for (int i = 0; i < len - 1; i++)//一共要排序len-1次
        {
            //每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
            boolean flag = false;

            for (int j = 0; j < k; j++)//选出该趟排序的最大值往后移动
            {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;//只要有发生了交换，flag就置为true
                    pos = j;//循环里最后一次交换的位置 j赋给pos
                }
            }

            k = pos;
            //判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!flag) {
                return;
            }
        }

    }

}

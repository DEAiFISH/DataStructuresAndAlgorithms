package sort;

/**
 * 描述：在无序区中找一个最小元素跟在有序区最后。
 * 特点：（有序区，无序区）
 * 时间复杂度：O(n*n)
 * 稳定性：不稳定
 */
public class SelectSort extends Sort {
    public static void main(String[] args) {
        TestTime.test(new SelectSort());//消耗时间：1635毫秒
    }

    @Override
    public void sort(int[] arr) {
        //left指针指向无序边界起点，right指针指向终点，temp用作临时变量交换值
        int left, right, temp;
        //默认指向无序列表起点
        left = 0;
        //默认指向无序列表终点
        right = arr.length - 1;
        //记录每轮找到的最小值的下标
        int min = left;
        //记录每轮找到的最大值的下标
        int max = right;
        //当right >= left时，列表已经有序
        //记录循环的次数
        int index = 0;
        while (left < right) {
            min = left;     //每轮开始前，默认无序列表起点为最小值
            max = right;    //每轮开始前，默认无序列表终点为最大值
            //指针i从左往右扫描，找出最小值，最大值
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[min]) {
                    min = i;    //通过比较，记录最小值的下标
                }
                if (arr[i] > arr[max]) {
                    max = i;    //通过比较，记录最大值的下标
                }
            }
            index++;
            if (min == left && max == right) {
                return;
            } else if (min == right && max == left) {
                //交换一次即可，交换两次的话，序列翻转，相当于没有交换
                temp = arr[left];
                arr[left] = arr[min];
                arr[min] = temp;
            } else {
                //找到最小值，交换
                temp = arr[left];
                arr[left] = arr[min];
                arr[min] = temp;

                //找到最大值，交换
                temp = arr[right];
                arr[right] = arr[max];
                arr[max] = temp;
            }
            //确定最小/大值，指针向中间移动
            left++;
            right--;
        }
    }
}

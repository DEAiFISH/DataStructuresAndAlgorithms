package sort;

/**
 * 描述：一种多关键词的排序算法，可用桶排序实现
 * 特点：空间换时间
 * 时间复杂度：O(n*k)
 * 稳定性：稳定
 */
public class RadixSort extends Sort {
    public static void main(String[] args) {
        TestTime.test(new RadixSort());//消耗时间：5毫秒
    }

    /*
     * 获取数组a中最大值
     *
     * 参数说明:
     *     a -- 数组
     *     n -- 数组长度
     */
    private int getMax(int[] a) {
        int max;

        max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max) {
                max = a[i];
            }

        return max;
    }

    /*
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明:
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private void countSort(int[] a, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < a.length; i++) {
            buckets[(a[i] / exp) % 10]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组output[]中
        for (int i = a.length - 1; i >= 0; i--) {
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }

        output = null;
        buckets = null;
    }

    /*
     * 基数排序
     *
     * 参数说明:
     *     a -- 数组
     */
    @Override
    public void sort(int[] a) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(a);    // 数组a中的最大值

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

}

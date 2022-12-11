package sort;

public class InsertSort extends Sort {
    public static void main(String[] args) {
        TestTIme.test(new InsertSort());//消耗时间：8417毫秒
    }

    //插入排序 insection sort
    public void sort(int[] arr) {

        int insertValue = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i]; //表示待插入的数，根据插入排序定义，从第二个数开始找位置 
            insertIndex = i - 1; //表示待排序数前面的那个索引，即arr[1]前面数的下标

            //给insertValue 找到插入的位置
            //说明：
            //1. insertValue >= 0 保证在给insertValue 找插入位置时，数组不越界
            //2. insertValue < arr[insertIndex] 表示 待插入的数 还没有找到插入位置
            //3. 找到位置后，需要将arr[insertIndex]后移动
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //优化--判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue; //当退出while 循环时，说明找到插入的位置了，即 insertIndex + 1
            }
        }

    }

}
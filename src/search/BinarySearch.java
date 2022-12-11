package search;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 23, 5, 23, -2, 24, 102, 90, -23, -45, 99, 231, 231, 143, -438};

        //二分法查找，查找的必须是在有序数组中
        Arrays.sort(array);

        for (int i : array) {
            System.out.print(i + "  ");
        }

        System.out.println();

        System.out.println(binarySearch(array, 0, array.length - 1, 231));
    }

    /**
     * @param array     数组
     * @param left      左界
     * @param right     右界
     * @param findValue 查找的值
     * @return
     */
    public static ArrayList binarySearch(int[] array, int left, int right, int findValue) {
        int mid = (right + left) / 2;
        if (left > right) {
            return new ArrayList<>();
        }
        if (array[mid] > findValue) {
            return binarySearch(array, left, mid - 1, findValue);
        } else if (array[mid] < findValue) {
            return binarySearch(array, mid + 1, right, findValue);
        } else {

            //不急返回 先判断是否还有findValue
            ArrayList<Integer> resIndexList = new ArrayList<>();

            //向左移动
            int temp = mid - 1;
            while (temp >= 0 && array[temp] == findValue) {
                resIndexList.add(temp--);
            }

            resIndexList.add(mid);
            //向右移动
            temp = mid + 1;
            while (temp < array.length && array[temp] == findValue) {
                resIndexList.add(temp++);
            }
            return resIndexList;
        }
    }
}

package search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] array = {1, 23, 5, 23, -2, 24, 102, 90, -23, -45, 99, 231,231, 143, -438};

        //必须传入有序数组
        Arrays.sort(array);
        System.out.println(insertValueSearch(array, 0, array.length - 1, 1));
    }


    public static int insertValueSearch(int[] array, int left, int right, int findValue){
        if(left > right || findValue < array[0] || findValue > array[array.length - 1]){
            return - 1;
        }
        int mid = left + (right - left) * (findValue - array[left]) / (array[right] - array[left]);
        int midValue = array[mid];

        if(findValue > midValue){
            return insertValueSearch(array,mid + 1,right,findValue);
        }else if(findValue < midValue){
            return insertValueSearch(array,left,right - 1,findValue);
        }else {
            return mid;
        }
    }
}

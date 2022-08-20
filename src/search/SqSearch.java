package search;

import java.util.Date;

public class SqSearch {
    public static void main(String[] args) {
        int[] array = {1,23,5,23,-2,24,102,90,-23,-45,99,231,143,-438};

        System.out.println(sqSearch(array, -2));
        System.out.println(sqSearch(array, -22));
    }

    public static int sqSearch(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }
}

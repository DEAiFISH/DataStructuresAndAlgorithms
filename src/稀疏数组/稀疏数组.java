package 稀疏数组;

import java.io.*;
import java.util.Scanner;

public class 稀疏数组 {
    public static void main(String[] args) {
        int[][] array = new int[10][10];
        int row, col, sum, count;
        sum = 0;
        count = 1;

        //循环输入  多次记录
        while (true) {
            Scanner scanner = new Scanner(System.in);
            row = scanner.nextInt();
            if (row == -1) {
                break;
            }
            col = scanner.nextInt();


            array[row][col] = count++;
            sum++;


            //输入一次 打印一次
            for (int[] arr : array) {
                for (int i : arr) {
                    System.out.print(i + "\t");
                }
                System.out.println();
            }
        }


        System.out.println("原数组");
        for (int[] arr : array) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        ToSparseArray(array, sum);

        System.out.println("读取后数组");
        SAToArray();

    }

    /**
     * 稀疏数组储存
     *
     * @param arr
     * @param sum
     */
    public static void ToSparseArray(int[][] arr, int sum) {
        int len = arr.length;
        int count = 0;
        int[][] SparseArr = new int[sum + 1][3];

        //  rows   cols   value
        //   len    len    sum
        //   0      1       1
        //   2      3       1
        //   2      5       1


        SparseArr[count][0] = SparseArr[count][1] = len;
        SparseArr[count++][2] = sum;

        //记录稀疏数组
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i][j] != 0) {
                    SparseArr[count][0] = i;
                    SparseArr[count][1] = j;
                    SparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }


        //写出到文件储存
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/稀疏数组/稀疏数组储存.txt"));

            for (int[] a : SparseArr) {
                bw.write(a[0] + "\t" + a[1] + "\t" + a[2]);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    /**
     * 稀疏数组读取
     */
    public static void SAToArray() {

        BufferedReader br = null;
        int[][] array = null;
        try {
            br = new BufferedReader(new FileReader("src/稀疏数组/稀疏数组储存.txt"));

            //记录每行字符串
            String lineStr;

            //判断是不是第一次读取文件
            boolean flag = true;
            int count = 0;
            while ((lineStr = br.readLine()) != null) {
                String[] str = lineStr.split("\t");
                if (flag) {
                    //创建 10*10 大小的数组
                    array = new int[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
                    count = Integer.parseInt(str[2]);
                    flag = false;
                } else {
                    array[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        for (int[] arr : array) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
